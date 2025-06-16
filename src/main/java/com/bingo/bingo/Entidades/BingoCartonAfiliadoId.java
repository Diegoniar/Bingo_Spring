package com.bingo.bingo.Entidades;

import java.io.Serializable;
import java.util.Objects;

public class BingoCartonAfiliadoId implements Serializable {

    private Integer codigoBingo;
    private Integer codigoCarton;
    private String tipoDocumentoAfiliado;
    private String cedulaAfiliado;

    // Constructor vacío, getters, setters, equals y hashCode...
    // Es crucial que todos estos elementos estén presentes y correctos.

    public BingoCartonAfiliadoId() {
    }

    public Integer getCodigoBingo() { return codigoBingo; }
    public void setCodigoBingo(Integer codigoBingo) { this.codigoBingo = codigoBingo; }
    public Integer getCodigoCarton() { return codigoCarton; }
    public void setCodigoCarton(Integer codigoCarton) { this.codigoCarton = codigoCarton; }
    public String getTipoDocumentoAfiliado() { return tipoDocumentoAfiliado; }
    public void setTipoDocumentoAfiliado(String tipoDocumentoAfiliado) { this.tipoDocumentoAfiliado = tipoDocumentoAfiliado; }
    public String getCedulaAfiliado() { return cedulaAfiliado; }
    public void setCedulaAfiliado(String cedulaAfiliado) { this.cedulaAfiliado = cedulaAfiliado; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BingoCartonAfiliadoId that = (BingoCartonAfiliadoId) o;
        return Objects.equals(codigoBingo, that.codigoBingo) && Objects.equals(codigoCarton, that.codigoCarton) && Objects.equals(tipoDocumentoAfiliado, that.tipoDocumentoAfiliado) && Objects.equals(cedulaAfiliado, that.cedulaAfiliado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBingo, codigoCarton, tipoDocumentoAfiliado, cedulaAfiliado);
    }
}