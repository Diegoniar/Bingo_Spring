package com.bingo.bingo.Controladores;

import com.bingo.bingo.Entidades.Bingo;
import com.bingo.bingo.Repositorios.BingoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/bingos")
public class BingoAdminController {
    @Autowired
    private BingoRepository bingoRepository;

    @GetMapping("/nuevo")
    public String mostrarFormularioDeNuevoBingo(Model model){
        model.addAttribute("bingo", new Bingo());
        return "admin/formulario-bingo";
    }

    @PostMapping("/guardar")
    public String guardarBingo(@Valid @ModelAttribute("bingo") Bingo bingo, BindingResult result, Model model) {
        System.out.println("---[MÉTODO GUARDAR BINGO INICIADO]---");
        System.out.println("Bingo recibido del formulario: " + bingo.toString());

        // PRIMERA VERIFICACIÓN: ¿Hay errores de validación?
        if (result.hasErrors()) {
            System.err.println("¡SE ENCONTRARON ERRORES DE VALIDACIÓN!");
            result.getAllErrors().forEach(error -> System.err.println(" -> " + error.getDefaultMessage()));
            return "admin/formulario-bingo"; // Volvemos al formulario
        }

        try {
            System.out.println("No hay errores de validación. Intentando guardar el bingo...");
            bingoRepository.save(bingo);
            System.out.println("¡Bingo guardado exitosamente en la base de datos!");
        } catch (Exception e) {
            System.err.println("¡OCURRIÓ UNA EXCEPCIÓN AL GUARDAR EN LA BASE DE DATOS!");
            e.printStackTrace();

            // Ahora, esta línea funcionará porque 'model' existe como parámetro.
            model.addAttribute("errorDeGuardado", "Ocurrió un error inesperado al guardar el bingo.");
            return "admin/formulario-bingo";
        }

        return "redirect:/bingos";
    }
}
