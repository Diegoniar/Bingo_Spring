package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.BingoCarton;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface BingoCartonRepository extends JpaRepository<BingoCarton, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM BingoCarton c WHERE c.id NOT IN (SELECT bca.codigoCarton FROM BingoCartonAfiliado bca)")
    List<BingoCarton> findByEstado(String estado, Pageable pageable);

}
