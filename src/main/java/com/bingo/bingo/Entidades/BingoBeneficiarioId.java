package com.bingo.bingo.Entidades;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BingoBeneficiarioId implements Serializable {
    private String tipodocumento;
    private String documentobeneficiario;

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getDocumentobeneficiario() {
        return documentobeneficiario;
    }

    public void setDocumentobeneficiario(String documentobeneficiario) {
        this.documentobeneficiario = documentobeneficiario;
    }

    @Override
    public String toString() {
        return "BingoBeneficiarioId{" +
                "tipodocumento='" + tipodocumento + '\'' +
                ", documentobeneficiario='" + documentobeneficiario + '\'' +
                '}';
    }
}
