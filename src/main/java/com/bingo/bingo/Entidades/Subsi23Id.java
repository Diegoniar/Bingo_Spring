package com.bingo.bingo.Entidades;

import java.io.Serializable;
import java.util.Objects;

public class Subsi23Id implements Serializable {

    private String tipoDocumentoAfiliado;
    private String cedtra;
    private int codben;

    public Subsi23Id() {
    }

    public Subsi23Id(String tipdoc_tra, String cedtra, int codben) {
        this.tipoDocumentoAfiliado = tipdoc_tra;
        this.cedtra = cedtra;
        this.codben = codben;
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

    public int getCodben() {
        return codben;
    }

    public void setCodben(int codben) {
        this.codben = codben;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subsi23Id subsi23Id = (Subsi23Id) o;
        return codben == subsi23Id.codben && Objects.equals(tipoDocumentoAfiliado, subsi23Id.tipoDocumentoAfiliado) && Objects.equals(cedtra, subsi23Id.cedtra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumentoAfiliado, cedtra, codben);
    }
}
