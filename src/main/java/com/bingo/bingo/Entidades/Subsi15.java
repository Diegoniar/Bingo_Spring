package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "subsi15")
public class Subsi15 {
    @EmbeddedId
    private Subsi15Id id;

    @Column(name = "priape")
    private String priape;

    @Column(name = "segape")
    private String segape;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @Column(name = "codcat")
    private String codcat;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nit")
    private Subsi02 subsi02;

    public Subsi15Id getId() {
        return id;
    }

    public void setId(Subsi15Id id) {
        this.id = id;
    }

    public String getPriape() {
        return priape;
    }

    public void setPriape(String priape) {
        this.priape = priape;
    }

    public String getSegape() {
        return segape;
    }

    public void setSegape(String segape) {
        this.segape = segape;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado != null ? estado.trim() : null;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodcat() {
        return codcat != null ? codcat.trim() : null;
    }

    public void setCodcat(String codcat) {
        this.codcat = codcat;
    }

    public Subsi02 getSubsi02() {
        return subsi02;
    }

    public void setSubsi02(Subsi02 subsi02) {
        this.subsi02 = subsi02;
    }

    public String getTelefono() {
        return telefono != null ? telefono.trim() : null;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email != null ? email.trim() : null;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Subsi15{" +
                "id=" + id +
                ", priape='" + priape + '\'' +
                ", segape='" + segape + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", codcat=" + codcat +
                ", subsi02=" + subsi02 +
                '}';
    }
}
