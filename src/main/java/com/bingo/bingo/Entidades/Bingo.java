package com.bingo.bingo.Entidades;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "bingo")
public class Bingo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbingo")
    private Integer idbingo;

    @NotEmpty(message = "El nombre del bingo no puede estar vacío.")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres.")
    @Column(name = "nombrebingo")
    private String nombrebingo;

    @NotNull(message = "Debe especificar una fecha para el bingo.")
    @FutureOrPresent(message = "La fecha del bingo no puede ser en el pasado.")
    @Column(name = "fechabingo")
    private Date fechabingo;

    @NotEmpty(message = "Debe seleccionar un estado.")
    @Column(name = "estado")
    private String estado;

    @Column(name = "poster")
    private String poster;

    public Integer getIdbingo() {
        return idbingo;
    }

    public void setIdbingo(Integer idbingo) {
        this.idbingo = idbingo;
    }

    public String getNombrebingo() {
        return nombrebingo;
    }

    public void setNombrebingo(String nombrebingo) {
        this.nombrebingo = nombrebingo;
    }

    public Date getFechabingo() {
        return fechabingo;
    }

    public void setFechabingo(Date fechabingo) {
        this.fechabingo = fechabingo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Bingo{" +
                "idbingo=" + idbingo +
                ", nombrebingo='" + nombrebingo + '\'' +
                ", fechabingo=" + fechabingo +
                ", estado='" + estado + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
