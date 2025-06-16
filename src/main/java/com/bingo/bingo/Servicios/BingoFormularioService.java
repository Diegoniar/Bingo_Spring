package com.bingo.bingo.Servicios;

import com.bingo.bingo.Entidades.BingoFormulario;
import com.bingo.bingo.Repositorios.BingoFormularioRepository;
import com.bingo.bingo.Repositorios.BingoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class BingoFormularioService {
    @Autowired
    private BingoFormularioRepository formularioRepository;

    @Autowired
    private BingoRepository bingoRepository;

    @Transactional(readOnly = true)
    public BingoFormulario guardarFormulario(BingoFormulario formulario){
        System.out.println("Guardando nuevo formulario para el bingo: " + formulario.toString());
        return formularioRepository.save(formulario);
    }

}
