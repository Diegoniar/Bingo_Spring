package com.bingo.bingo.Servicios;

import com.bingo.bingo.Repositorios.Subsi21Repository;
import com.bingo.bingo.Repositorios.Subsi23Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalculoCuposService {
    @Autowired
    private Subsi21Repository subsi21Repository;

    @Autowired
    private Subsi23Repository subsi23Repository;

    @Transactional(readOnly = true)
    public int calcularCuposPorAfiliado(String tipdoc_tra, String cedtra) {
        long conyuguesActivos = subsi21Repository.findByTipoDocumentoAfiliadoAndCedtra(tipdoc_tra, cedtra)
                .stream()
                .filter(relacion -> "S".equalsIgnoreCase(relacion.getComper()))
                .map(relacion -> relacion.getConyugue())
                .filter(conyuge -> !"M".equalsIgnoreCase(conyuge.getEstado()))
                .count();

        long beneficariosActivos = subsi23Repository.findByTipoDocumentoAfiliadoAndCedtra(tipdoc_tra, cedtra)
                .stream()
                .map(relacion -> relacion.getBeneficiario())
                .filter(beneficiario -> beneficiario != null && "A".equalsIgnoreCase(beneficiario.getEstado()))
                .count();

        return (int) (conyuguesActivos + beneficariosActivos + 1);
    }

}
