package com.bingo.bingo.Repositorios;

import com.bingo.bingo.Entidades.Bingo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface BingoRepository extends JpaRepository<Bingo, Integer> {
    List<Bingo> findByFechabingoGreaterThanEqual(Date fecha);

}
