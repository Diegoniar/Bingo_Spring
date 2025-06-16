package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.Gener18;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Gener18Repository extends JpaRepository<Gener18, String> {
    List<Gener18> findByCoddoc(String coddoc);
    List<Gener18> findByEstado(String estado);
}
