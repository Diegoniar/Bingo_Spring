package com.bingo.bingo.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gener18")
public class Gener18 {
    @Id
    @Column(name = "coddoc")
    private String coddoc;

    @Column(name = "detdoc")
    private String detalle;

    @Column(name = "estado")
    private String estado;

    public String getCoddoc() {
        return coddoc != null ? coddoc.trim() : null;
    }

    public void setCoddoc(String coddoc) {
        this.coddoc = coddoc;
    }

    public String getDetalle() {
        return detalle != null ? detalle.trim() : null;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Gener18{" +
                "coddoc='" + coddoc + '\'' +
                ", detalle='" + detalle + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
