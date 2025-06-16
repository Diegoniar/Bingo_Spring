package com.bingo.bingo.Entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Subsi15Id implements Serializable {

    @Column(name = "coddoc")
    private String coddoc;

    @Column(name = "cedtra")
    private String cedtra;

    public Subsi15Id() {
    }

    public Subsi15Id(String coddoc, String cedtra) {
        this.coddoc = coddoc;
        this.cedtra = cedtra;
    }

    public String getCoddoc() {
        return coddoc != null ? coddoc.trim() : null;
    }

    public void setCoddoc(String coddoc) {
        this.coddoc = coddoc;
    }

    public String getCedtra() {
        return cedtra;
    }

    public void setCedtra(String cedtra) {
        this.cedtra = cedtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subsi15Id subsi15Id = (Subsi15Id) o;
        return Objects.equals(coddoc, subsi15Id.coddoc) && Objects.equals(cedtra, subsi15Id.cedtra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coddoc, cedtra);
    }

    @Override
    public String toString() {
        return "Subsi15Id{" +
                "coddoc='" + coddoc + '\'' +
                ", cedtra='" + cedtra + '\'' +
                '}';
    }
}
