package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.BingoCartonAfiliado;
import com.bingo.bingo.Entidades.BingoCartonAfiliadoId;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface BingoCartonAfiliadoRepository extends JpaRepository<BingoCartonAfiliado, BingoCartonAfiliadoId> {

}
