package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "bingo_beneficiario")
public class BingoBeneficiario {
    @EmbeddedId
    private BingoBeneficiarioId id;

    @Column(name = "priape")
    private String priape;
    @Column(name = "segape")
    private String segape;
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "tipodocafi", referencedColumnName = "coddoc"),
            @JoinColumn(name = "documentoafil", referencedColumnName = "cedtra")
    })
    private Subsi15 afiliado;

    public BingoBeneficiarioId getId() {
        return id;
    }

    public void setId(BingoBeneficiarioId id) {
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

    public Subsi15 getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Subsi15 afiliado) {
        this.afiliado = afiliado;
    }

    @Override
    public String toString() {
        return "BingoBeneficiario{" +
                "id=" + id +
                ", priape='" + priape + '\'' +
                ", segape='" + segape + '\'' +
                ", nombre='" + nombre + '\'' +
                ", afiliado=" + afiliado +
                '}';
    }
}
