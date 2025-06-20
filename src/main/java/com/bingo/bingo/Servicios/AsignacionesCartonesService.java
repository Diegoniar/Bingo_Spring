package com.bingo.bingo.Servicios;

import com.bingo.bingo.Entidades.*;
import com.bingo.bingo.Eventos.InscripcionExitosaEvent;
import com.bingo.bingo.Repositorios.BingoCartonAfiliadoRepository;
import com.bingo.bingo.Repositorios.BingoCartonRepository;
import com.bingo.bingo.Repositorios.BingoFormularioRepository;
import com.bingo.bingo.Repositorios.BingoCartonRepository;
import com.bingo.bingo.Repositorios.Subsi15Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Este servicio se encarga de la lógica de negocio compleja para registrar una
 * inscripción y asignar los cartones correspondientes de manera transaccional.
 */
@Service
public class AsignacionesCartonesService {

    // --- Inyectamos todos los componentes que necesitamos ---

    @Autowired
    private CalculoCuposService calculoCuposService;

    @Autowired
    private BingoCartonRepository cartonRepository;

    @Autowired
    private BingoCartonAfiliadoRepository bingoCartonAfiliadoRepository;

    @Autowired
    private BingoFormularioRepository formularioRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * Método principal que realiza toda la operación de inscripción.
     * Es transaccional, lo que significa que si ocurre un error en cualquier punto,
     * todos los cambios en la base de datos se revierten automáticamente.
     *
     * @param formulario El objeto BingoFormulario con los datos del afiliado y el bingo seleccionados.
     */
    @Transactional
    public void registrarInscripcionYAsignarCartones(BingoFormulario formulario) {

        // 1. Obtenemos los datos principales que vienen del controlador.
        Subsi15 afiliado = formulario.getAfiliado();
        Bingo bingo = formulario.getBingo();

        Optional<BingoFormulario> yaExiste = formularioRepository.findByBingoAndAfiliado(bingo, afiliado);
        if (yaExiste.isPresent()) {
            System.out.println("ADVERTENCIA: Intento de inscripción duplicada para el afiliado " + afiliado.getId().getCedtra() + " en el bingo " + bingo.getNombrebingo() + ". Ignorando la segunda petición.");
            return; // Salimos del método y no hacemos nada. La primera inscripción ya está en proceso o guardada.
        }

        // 2. Llamamos al otro servicio para calcular los cupos según las reglas de negocio.
        int cupos = calculoCuposService.calcularCuposPorAfiliado(
                afiliado.getId().getCoddoc(),
                afiliado.getId().getCedtra()
        );
        System.out.println("DEBUG: Cupos calculados por el servicio = " + cupos); // <-- LÍNEA DE DEBUG 1
        formulario.setCupos(cupos);

        // Si no tiene derecho a cupos, guardamos y salimos.
        if (cupos == 0) {
            formularioRepository.save(formulario);
            return;
        }

        List<BingoCarton> cartonesParaAsignar = cartonRepository.findByEstado("D", PageRequest.of(0, cupos));
        System.out.println("DEBUG: Cartones disponibles encontrados = " + cartonesParaAsignar.size());

        // 5. Validamos si la base de datos nos dio suficientes cartones
        if (cartonesParaAsignar.size() < cupos) {
            throw new RuntimeException("No hay suficientes cartones disponibles. Se necesitan " + cupos + " y solo hay " + cartonesParaAsignar.size() + ".");
        }

        for (   BingoCarton carton : cartonesParaAsignar) {
            carton.setEstado("A");
        }

        cartonRepository.saveAllAndFlush(cartonesParaAsignar);
        System.out.println("DEBUG: El estado de los " + cartonesParaAsignar.size() + " cartones ha sido actualizado y sincronizado con la BD.");

        List<BingoCartonAfiliado> nuevasAsignaciones = cartonesParaAsignar.stream().map(carton -> {
            BingoCartonAfiliado asignacion = new BingoCartonAfiliado();
            asignacion.setCodigoBingo(bingo.getIdbingo());
            asignacion.setCodigoCarton(carton.getId());
            asignacion.setTipoDocumentoAfiliado(afiliado.getId().getCoddoc());
            asignacion.setCedulaAfiliado(afiliado.getId().getCedtra());
            asignacion.setBingo(bingo);
            asignacion.setCarton(carton);
            asignacion.setAfiliado(afiliado);
            return asignacion;
        }).collect(Collectors.toList());
        System.out.println("DEBUG: Se van a crear " + nuevasAsignaciones.size() + " nuevas asignaciones.");


        // 6. Guardamos todo en la base de datos.
        formularioRepository.save(formulario);
        bingoCartonAfiliadoRepository.saveAll(nuevasAsignaciones);
        cartonRepository.saveAll(cartonesParaAsignar);
        //7. Envio del correo Electrónico
        InscripcionExitosaEvent evento = new InscripcionExitosaEvent(this, formulario.getCorreo(), cartonesParaAsignar);
        eventPublisher.publishEvent(evento);

        System.out.println("---[SERVICIO DE ASIGNACIÓN TERMINADO Y EVENTO PUBLICADO]---");
    }
}