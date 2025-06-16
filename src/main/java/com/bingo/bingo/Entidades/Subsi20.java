package com.bingo.bingo.Entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subsi20")
public class Subsi20 {
    @EmbeddedId
    private Subsi20Id id;

    @Column(name = "estado")
    private String estado;

    public Subsi20Id getId() {
        return id;
    }

    public void setId(Subsi20Id id) {
        this.id = id;
    }

    public String getEstado() {
        return estado != null ? estado.trim() : null;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Subsi20{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                '}';
    }
}
