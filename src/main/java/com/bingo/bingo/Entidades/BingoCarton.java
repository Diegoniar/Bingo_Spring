package com.bingo.bingo.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bingo_carton")
public class BingoCarton {
    @Id
    @Column(name = "idcarton")
    private int id;

    @Column(name = "rutacarton")
    private String rutacarton;

    @Column(name = "estado")
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int idcarton) {
        this.id = idcarton;
    }

    public String getRutacarton() {
        return rutacarton;
    }

    public void setRutacarton(String rutacarton) {
        this.rutacarton = rutacarton;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "BingoCarton{" +
                "idcarton=" + id +
                ", rutacarton='" + rutacarton + '\'' +
                '}';
    }
}
