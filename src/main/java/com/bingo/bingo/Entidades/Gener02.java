package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "gener02")
public class Gener02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario;

    @Column(name = "cedtra")
    private String cedtra;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clave")
    private String clave;

    @Column(name = "estado")
    private String estado;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getCedtra() {
        return cedtra;
    }

    public void setCedtra(String cedtra) {
        this.cedtra = cedtra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "UsuarioAdmin{" +
                "usuario=" + usuario +
                ", cedtra='" + cedtra + '\'' +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
