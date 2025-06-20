package com.bingo.bingo.Entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="bingo_formulario")
public class BingoFormulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idformulario")
    private int idformulario;

    @NotNull(message = "Debe seleccionar un afiliado.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            // El 'name' ahora coincide con la columna real en la tabla 'bingo_formulario'
            @JoinColumn(name = "tipodocumento", referencedColumnName = "coddoc"),
            @JoinColumn(name = "documentoafiliado", referencedColumnName = "cedtra")
    })
    private Subsi15 afiliado;

    @NotNull(message = "El número de cupos es obligatorio.")
    @Column(name = "cupos")
    private int cupos;

    @NotEmpty(message = "El número de teléfono no puede estar vacío.")
    @Column(name = "telefono")
    private String telefono;

    @NotEmpty(message = "El correo electrónico no puede estar vacío.")
    @Column(name = "correo")
    private String correo;

    @NotNull(message = "Debe seleccionar un bingo para participar.")
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
