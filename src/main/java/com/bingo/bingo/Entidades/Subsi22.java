package com.bingo.bingo.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subsi22")
public class Subsi22 {
    @Id
    @Column(name = "codben")
    private int codben;

    @Column(name = "estado")
    private String estado;

    public int getCodben() {
        return codben;
    }

    public void setCodben(int codben) {
        this.codben = codben;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Subsi22{" +
                "codben=" + codben +
                ", estado='" + estado + '\'' +
                '}';
    }
}

