package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.Bingo;
import com.bingo.bingo.Entidades.BingoFormulario;
import com.bingo.bingo.Entidades.Subsi15;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface BingoFormularioRepository extends JpaRepository<BingoFormulario, Integer> {
    Optional<BingoFormulario> findByBingoAndAfiliado(Bingo bingo, Subsi15 afiliado);
}
