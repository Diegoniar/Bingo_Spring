package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.Subsi21;
import com.bingo.bingo.Entidades.Subsi21Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Subsi21Repository extends JpaRepository<Subsi21, Subsi21Id> {
    List<Subsi21> findByTipoDocumentoAfiliadoAndCedtra(String tipdoc_tra, String cedtra);
}
