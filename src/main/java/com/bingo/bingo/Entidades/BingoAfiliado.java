package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name="bingo_afiliado")
public class BingoAfiliado {
    @EmbeddedId
    private BingoAfiliadoId id;

    @Column(name = "priape")
    private String priape;
    @Column(name = "segape")
    private String segape;
    @Column(name = "nombre")
    private String nombre;
    @Column(name="categoria")
    private char categoria;
    @Column(name = "codigomunicipio")
    private String codigomunicipio;
    @Column(name = "nit")
    private String nit;

    public BingoAfiliadoId getId() {
        return id;
    }

    public void setId(BingoAfiliadoId id) {
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

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public String getCodigomunicipio() {
        return codigomunicipio;
    }

    public void setCodigomunicipio(String codigomunicipio) {
        this.codigomunicipio = codigomunicipio;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "BingoAfiliado{" +
                "id=" + id +
                ", priape='" + priape + '\'' +
                ", segape='" + segape + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", codigomunicipio='" + codigomunicipio + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }
}
