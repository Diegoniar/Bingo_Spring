package com.bingo.bingo.Controladores;

import com.bingo.bingo.Entidades.Bingo;
import com.bingo.bingo.Repositorios.BingoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BingoController {
    @Autowired
    private BingoRepository bingoRepository;

    @GetMapping("/bingos")
    public String listarBingos(Model model) {
        List<Bingo> listaDeBingos = bingoRepository.findAll();
        model.addAttribute("bingos", listaDeBingos);
        return "lista-bingos";
    }

}
