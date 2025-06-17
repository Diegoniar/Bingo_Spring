package com.bingo.bingo.Controladores;

import com.bingo.bingo.Entidades.*;
import com.bingo.bingo.Repositorios.BingoRepository;
import com.bingo.bingo.Repositorios.Gener18Repository;
import com.bingo.bingo.Repositorios.Subsi15Repository;
import com.bingo.bingo.Servicios.AsignacionesCartonesService;
import com.bingo.bingo.Servicios.BingoFormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FormularioController {
    @Autowired
    private BingoFormularioService bingoFormularioService;

    @Autowired
    private BingoRepository bingoRepository;

    @Autowired
    private Gener18Repository gener18Repository;

    @Autowired
    private AsignacionesCartonesService asignacionService;

    @Autowired
    private Subsi15Repository subsi15Repository;

    @GetMapping("/formulario/nuevo")
    public String mostrarFormulario(Model model) {
            // 1. Obtenemos la lista de bingos para el menú desplegable
            List<Bingo> bingosActivos = bingoRepository.findAll();
            List<Gener18> tiposDeDocumento = gener18Repository.findByEstado("A");

            model.addAttribute("formulario", new BingoFormulario());
            model.addAttribute("listaDeBingos", bingosActivos);
            model.addAttribute("listaDeTiposDoc", tiposDeDocumento);

            return "formulario-bingo";
    }

    @PostMapping("/formulario/guardar")
    public String guardarFormulario(@ModelAttribute("formulario") BingoFormulario formulario) {
        System.out.println("Formulario recibido: " + formulario.toString());
        try {
            Subsi15Id afiliadoId = formulario.getAfiliado().getId();
            asignacionService.registrarInscripcionYAsignarCartones(formulario);
            Subsi15 afiliadoCompleto = subsi15Repository.findById(afiliadoId)
                    .orElseThrow(() -> new RuntimeException("Error Crítico: El afiliado no fue encontrado en la base de datos."));

            Integer bingoId = formulario.getBingo().getIdbingo();
            Bingo bingoCompleto = bingoRepository.findById(bingoId)
                    .orElseThrow(() -> new RuntimeException("Error Crítico: El bingo seleccionado no fue encontrado en la base de datos."));

            formulario.setAfiliado(afiliadoCompleto);
            formulario.setBingo(bingoCompleto);

            asignacionService.registrarInscripcionYAsignarCartones(formulario);


        } catch (RuntimeException e) {
            System.err.println("Error al procesar la inscripción: " + e.getMessage());
            return "redirect:/formulario/nuevo?error=true";
        }

        return "redirect:/inscripcion-exitosa";
    }

    @GetMapping("/inscripcion-exitosa")
    public String mostrarPaginaDeExito() {
        return "inscripcion-exitosa"; // Esto le dice a Spring que busque un archivo HTML con este nombre.
    }
}
