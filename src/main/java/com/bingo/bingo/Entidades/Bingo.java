package com.bingo.bingo.Entidades;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "bingo")
public class Bingo {
    @Id
    @Column(name = "idbingo")
    private Integer idbingo;
    @Column(name = "nombrebingo")
    private String nombrebingo;
    @Column(name = "fechabingo")
    private Date fechabingo;
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
