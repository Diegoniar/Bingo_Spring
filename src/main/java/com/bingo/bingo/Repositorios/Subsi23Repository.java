package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.Subsi23;
import com.bingo.bingo.Entidades.Subsi23Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Subsi23Repository extends JpaRepository<Subsi23, Subsi23Id> {
    List<Subsi23> findByTipoDocumentoAfiliadoAndCedtra(String tipdoc_tra, String cedtra);
}

