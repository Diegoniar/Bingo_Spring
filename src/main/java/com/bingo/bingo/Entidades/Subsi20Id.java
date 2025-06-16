package com.bingo.bingo.Entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Subsi20Id implements Serializable {
    @Column(name = "tipdoc")
    private String tipdoc;

    @Column(name = "cedcon")
    private String cedcon;

    public Subsi20Id() {
    }

    public Subsi20Id(String tipdoc, String cedcon) {
        this.tipdoc = tipdoc;
        this.cedcon = cedcon;
    }

    public String getTipdoc() {
        return tipdoc != null ? tipdoc.trim() : null;
    }

    public void setTipdoc(String tipdoc) {
        this.tipdoc = tipdoc;
    }

    public String getCedcon() {
        return cedcon != null ? cedcon.trim() : null;
    }

    public void setCedcon(String cedcon) {
        this.cedcon = cedcon;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subsi20Id that = (Subsi20Id) o;
        return  Objects.equals(tipdoc, that.tipdoc) && Objects.equals(cedcon, that.cedcon);
    }

    public int hashCode() {
        return Objects.hash(tipdoc, cedcon);
    }
}
