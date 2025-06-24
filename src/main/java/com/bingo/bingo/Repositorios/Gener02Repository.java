package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.Gener02;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Gener02Repository extends JpaRepository<Gener02,Integer> {
    Optional<Gener02> findByCedtra(String cedtra);

}
