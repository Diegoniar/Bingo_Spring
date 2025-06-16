package com.bingo.bingo.Controladores;

import com.bingo.bingo.Entidades.Subsi02;
import com.bingo.bingo.Entidades.Subsi15;
import com.bingo.bingo.Entidades.Subsi15Id;
import com.bingo.bingo.Repositorios.Subsi15Repository;
import com.bingo.bingo.Servicios.CalculoCuposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/afiliados")
public class Subsi15ApiController {
    @Autowired
    private Subsi15Repository subsi15Repository;

    @Autowired
    private CalculoCuposService  calculoCuposService;

    @GetMapping("/{coddoc}/{cedtra}")
    public ResponseEntity<?> buscarYValidarAfiliado(@PathVariable String coddoc, @PathVariable String cedtra) {
        // Asegúrate de tener el constructor con parámetros en tu clase AfiliadoId
        Subsi15Id id = new Subsi15Id(coddoc, cedtra);
        Optional<Subsi15> afiliadoOpt = subsi15Repository.findById(id);

        if (afiliadoOpt.isEmpty()) {
            return ResponseEntity.status(404).body("Afiliado no encontrado.");
        }

        Subsi15 afiliado = afiliadoOpt.get();

        // --- INICIO DEL BLOQUE DE DEPURACIÓN AVANZADA ---
        String estadoDesdeBD = afiliado.getEstado();
        String categoriaDesdeBD = afiliado.getCodcat();

        System.out.println("----- DEBUGGING PROFUNDO DEL AFILIADO -----");
        System.out.println("Estado leído de BD: '" + estadoDesdeBD + "' (Longitud: " + estadoDesdeBD.length() + ")");
        System.out.println("Categoría leída de BD: '" + categoriaDesdeBD + "' (Longitud: " + categoriaDesdeBD.length() + ")");

        String estadoLimpio = estadoDesdeBD.trim();
        String categoriaLimpia = categoriaDesdeBD.trim();

        System.out.println("Estado después de trim(): '" + estadoLimpio + "' (Longitud: " + estadoLimpio.length() + ")");
        System.out.println("Categoría después de trim(): '" + categoriaLimpia + "' (Longitud: " + categoriaLimpia.length() + ")");
        System.out.println("-------------------------------------------");
        // --- FIN DEL BLOQUE DE DEPURACIÓN ---

        if (!"A".equalsIgnoreCase(estadoLimpio)) {
            return ResponseEntity.status(400).body("El afiliado no se encuentra en estado ACTIVO.");
        }

        if (!("A".equalsIgnoreCase(categoriaLimpia) || "B".equalsIgnoreCase(categoriaLimpia))) {
            // Este es el mensaje de error que estás viendo
            return ResponseEntity.status(400).body("El afiliado no se encuentra en categoría A ó B.");
        }

        Subsi02 sub02 = afiliado.getSubsi02();

        java.util.Map<String, String> responseData = new java.util.HashMap<>();
        responseData.put("nombreAfiliado", afiliado.getNombre().trim() + " " + afiliado.getPriape().trim()+" "+afiliado.getSegape().trim());
        responseData.put("telefono", afiliado.getTelefono().trim());
        responseData.put("correo", afiliado.getEmail().trim());

        if (sub02 != null){
            responseData.put("nitEmpresa", sub02.getNit());
            responseData.put("nombreEmpresa", sub02.getRazsoc());
        } else {
            responseData.put("nitEmpresa", "N/A");
            responseData.put("nombreEmpresa", "N/A");
        }

        int cuposCalculados = calculoCuposService.calcularCuposPorAfiliado(coddoc, cedtra);
        responseData.put("cupos", String.valueOf(cuposCalculados));
        return ResponseEntity.ok(responseData);
    }

}
