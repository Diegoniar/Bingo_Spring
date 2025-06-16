package com.bingo.bingo.Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Subsi21Id implements Serializable {
    private String tipoDocumentoAfiliado;
    private String cedtra;
    private String tipoDocumentoConyuge;
    private String cedcon;

    public Subsi21Id() {
    }

    public Subsi21Id(String tipoDocumentoAfiliado, String cedtra, String tipdoc_con, String cedcon) {
        this.tipoDocumentoAfiliado = tipoDocumentoAfiliado;
        this.cedtra = cedtra;
        this.tipoDocumentoConyuge = tipdoc_con;
        this.cedcon = cedcon;
    }

    public String getTipoDocumentoAfiliado() {
        return tipoDocumentoAfiliado != null ? tipoDocumentoAfiliado.trim() : null;
    }

    public void setTipoDocumentoAfiliado(String tipdoc_tra) {
        this.tipoDocumentoAfiliado = tipdoc_tra;
    }

    public String getCedtra() {
        return cedtra != null ? cedtra.trim() : null;
    }

    public void setCedtra(String cedtra) {
        this.cedtra = cedtra;
    }

    public String getTipoDocumentoConyuge() {
        return tipoDocumentoConyuge != null ? tipoDocumentoConyuge.trim() : null;
    }

    public void setTipoDocumentoConyuge(String tipoDocumentoConyuge) {
        this.tipoDocumentoConyuge = tipoDocumentoConyuge;
    }

    public String getCedcon() {
        return cedcon != null ? cedcon.trim() : null;
    }

    public void setCedcon(String cedcon) {
        this.cedcon = cedcon;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subsi21Id subsi21Id = (Subsi21Id) o;
        return Objects.equals(tipoDocumentoAfiliado, subsi21Id.tipoDocumentoAfiliado) && Objects.equals(cedtra, subsi21Id.cedtra) && Objects.equals(tipoDocumentoConyuge, subsi21Id.tipoDocumentoConyuge) && Objects.equals(cedcon, subsi21Id.cedcon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumentoAfiliado, cedtra, tipoDocumentoConyuge, cedcon);
    }
}
