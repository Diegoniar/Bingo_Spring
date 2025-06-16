package com.bingo.bingo.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subsi02")
public class Subsi02 {
    @Id
    @Column(name = "nit")
    private String nit;

    @Column(name = "razsoc")
    private String razsoc;

    public String getNit() {
        return nit != null ? nit.trim() : null;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazsoc() {
        return razsoc != null ? razsoc.trim() : null;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
    }

    @Override
    public String toString() {
        return "Subsi02{" +
                "nit='" + nit + '\'' +
                ", razsoc='" + razsoc + '\'' +
                '}';
    }
}
