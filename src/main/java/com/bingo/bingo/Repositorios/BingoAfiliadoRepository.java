package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.BingoAfiliado;
import com.bingo.bingo.Entidades.BingoAfiliadoId;
import com.bingo.bingo.Entidades.Subsi15;
import com.bingo.bingo.Entidades.Subsi15Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BingoAfiliadoRepository extends JpaRepository<BingoAfiliado, BingoAfiliadoId> {
}
