package com.bingo.bingo.Eventos;

import com.bingo.bingo.Entidades.BingoCarton;
import org.springframework.context.ApplicationEvent;

import java.util.List;

public class InscripcionExitosaEvent extends ApplicationEvent {
    private final String destinatario;
    private final List<BingoCarton> cartones;

    public InscripcionExitosaEvent(Object source, String destinatario, List<BingoCarton> cartones) {
        super(source);
        this.destinatario = destinatario;
        this.cartones = cartones;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public List<BingoCarton> getCartones() {
        return cartones;
    }
}
