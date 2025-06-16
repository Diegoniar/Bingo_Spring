package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name="bingo_formulario")
public class BingoFormulario {
    @Id
    @Column(name = "idformulario")
    private int idformulario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            // El 'name' ahora coincide con la columna real en la tabla 'bingo_formulario'
            @JoinColumn(name = "tipodocumento", referencedColumnName = "coddoc"),
            @JoinColumn(name = "documentoafiliado", referencedColumnName = "cedtra")
    })
    private Subsi15 afiliado;

    @Column(name = "cupos")
    private int cupos;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
// La columna 'idbingo' de esta tabla apunta a la columna 'idbingo' de la tabla 'bingo'
    @JoinColumn(name = "idbingo", referencedColumnName = "idbingo")
    private Bingo bingo;


    public int getIdformulario() {
        return idformulario;
    }

    public void setIdformulario(int idformulario) {
        this.idformulario = idformulario;
    }

    public Subsi15 getAfiliado() {
        return afiliado;
    }

    public void setAfiliado(Subsi15 afiliado) {
        this.afiliado = afiliado;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Bingo getBingo() {
        return bingo;
    }

    public void setBingo(Bingo bingo) {
        this.bingo = bingo;
    }

    @Override
    public String toString() {
        return "BingoFormulario{" +
                "idformulario=" + idformulario +
                ", afiliado=" + afiliado +
                ", cupos=" + cupos +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", bingo=" + bingo +
                '}';
    }
}
