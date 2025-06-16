package com.bingo.bingo.Servicios;

import com.bingo.bingo.Entidades.*;
import com.bingo.bingo.Repositorios.BingoCartonAfiliadoRepository;
import com.bingo.bingo.Repositorios.BingoCartonRepository;
import com.bingo.bingo.Repositorios.BingoFormularioRepository;
import com.bingo.bingo.Repositorios.BingoCartonRepository;
import com.bingo.bingo.Repositorios.Subsi15Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    /**
     * Método principal que realiza toda la operación de inscripción.
     * Es transaccional, lo que significa que si ocurre un error en cualquier punto,
     * todos los cambios en la base de datos se revierten automáticamente.
     *
     * @param formulario El objeto BingoFormulario con los datos del afiliado y el bingo seleccionados.
     */
    @Transactional
    public void registrarInscripcionYAsignarCartones(BingoFormulario formulario) {

        // --- ESTAS LÍNEAS INICIALES SON ESENCIALES Y PROBABLEMENTE FALTABAN ---
        // 1. Obtenemos los datos principales que vienen del controlador.
        Subsi15 afiliado = formulario.getAfiliado();
        Bingo bingo = formulario.getBingo();

        // 2. Llamamos al otro servicio para calcular los cupos según las reglas de negocio.
        int cupos = calculoCuposService.calcularCuposPorAfiliado(
                afiliado.getId().getCoddoc(),
                afiliado.getId().getCedtra()
        );
        formulario.setCupos(cupos);

        // Si no tiene derecho a cupos, guardamos y salimos.
        if (cupos == 0) {
            formularioRepository.save(formulario);
            return;
        }

        // 3. Buscamos en la base de datos N cartones disponibles para este bingo.
        List<BingoCarton> cartonesDisponibles = cartonRepository.findCartonesDisponibles(
                bingo.getIdbingo(),
                PageRequest.of(0, cupos)
        );

        // 4. Validación CRÍTICA: ¿Hay suficientes cartones disponibles?
        if (cartonesDisponibles.size() < cupos) {
            throw new RuntimeException("No hay suficientes cartones disponibles para el bingo: " + bingo.getNombrebingo());
        }
        // --- FIN DE LAS LÍNEAS ESENCIALES ---


        // 5. Creamos las nuevas filas para la tabla de asignación.
        //    Esta parte del código usa las variables 'cartonesDisponibles', 'bingo' y 'afiliado'.
        List<BingoCartonAfiliado> nuevasAsignaciones = cartonesDisponibles.stream().map(carton -> {

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

        // 6. Guardamos todo en la base de datos.
        formularioRepository.save(formulario);
        bingoCartonAfiliadoRepository.saveAll(nuevasAsignaciones);

        System.out.println("---[SERVICIO DE ASIGNACIÓN TERMINADO CON ÉXITO]---");
    }
}