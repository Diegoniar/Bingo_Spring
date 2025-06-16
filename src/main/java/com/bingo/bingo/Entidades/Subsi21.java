package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "subsi21")
@IdClass(Subsi21Id.class)
public class Subsi21 {
    @Id
    @Column(name = "tipdoc_tra")
    private String tipoDocumentoAfiliado;

    @Id
    @Column(name = "cedtra")
    private String cedtra;

    @Id
    @Column(name = "tipdoc_con")
    private String tipoDocumentoConyuge;

    @Id
    @Column(name = "cedcon")
    private String cedcon;

    @Column(name = "comper")
    private String comper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "tipdoc_con", referencedColumnName = "tipdoc", insertable = false, updatable = false),
            @JoinColumn(name = "cedcon", referencedColumnName = "cedcon", insertable = false, updatable = false)
    })
    private Subsi20 conyugue;

    public String getTipoDocumentoAfiliado() {
        return tipoDocumentoAfiliado;
    }

    public void setTipoDocumentoAfiliado(String tipdoc_tra) {
        this.tipoDocumentoAfiliado = tipdoc_tra;
    }

    public String getCedtra() {
        return cedtra;
    }

    public void setCedtra(String cedtra) {
        this.cedtra = cedtra;
    }

    public String getTipoDocumentoConyuge() {
        return tipoDocumentoConyuge;
    }

    public void setTipoDocumentoConyuge(String tipdoc_con) {
        this.tipoDocumentoConyuge = tipdoc_con;
    }

    public String getCedcon() {
        return cedcon;
    }

    public void setCedcon(String cedcon) {
        this.cedcon = cedcon;
    }

    public String getComper() {
        return comper != null ? comper.trim() : null;
    }

    public void setComper(String comper) {
        this.comper = comper;
    }

    public Subsi20 getConyugue() {
        return conyugue;
    }

    public void setConyugue(Subsi20 conyugue) {
        this.conyugue = conyugue;
    }


}


