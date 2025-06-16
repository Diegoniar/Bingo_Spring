package com.bingo.bingo.Entidades;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BingoAfiliadoId implements Serializable {
    private String tipodocumento;
    private String documentoafiliado;

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getDocumentoafiliado() {
        return documentoafiliado;
    }

    public void setDocumentoafiliado(String documentoafiliado) {
        this.documentoafiliado = documentoafiliado;
    }

    @Override
    public String toString() {
        return "BingoAfiliadoId{" +
                "tipodocumento='" + tipodocumento + '\'' +
                ", documentoafiliado='" + documentoafiliado + '\'' +
                '}';
    }


}
