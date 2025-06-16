package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "subsi23")
@IdClass(Subsi23Id.class)
public class Subsi23 {
    @Id
    @Column(name = "tipdoc_tra")
    private String tipoDocumentoAfiliado;

    @Id
    @Column(name = "cedtra")
    private String cedtra;

    @Id
    @Column(name = "codben")
    private int codben;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codben", referencedColumnName = "codben", insertable = false, updatable = false)
    private Subsi22 beneficiario;

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

    public Integer getCodben() {
        return codben;
    }

    public void setCodben(Integer codben) {
        this.codben = codben;
    }

    public Subsi22 getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Subsi22 beneficiario) {
        this.beneficiario = beneficiario;
    }
}
