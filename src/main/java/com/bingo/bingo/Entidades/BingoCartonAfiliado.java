package com.bingo.bingo.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "bingo_carton_afiliado")
@IdClass(BingoCartonAfiliadoId.class) // Usamos @IdClass
public class BingoCartonAfiliado {

    // Declaramos cada campo de la clave primaria y lo marcamos con @Id
    @Id
    @Column(name = "idbingo")
    private Integer codigoBingo;

    @Id
    @Column(name = "idcarton")
    private Integer codigoCarton;

    @Id
    @Column(name = "tipodocafil")
    private String tipoDocumentoAfiliado;

    @Id
    @Column(name = "documentoafiliado")
    private String cedulaAfiliado;

    // --- Relaciones ---
    // Usamos insertable=false, updatable=false porque estas columnas ya son parte del @Id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idbingo", referencedColumnName = "idbingo", insertable = false, updatable = false)
    private Bingo bingo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcarton", referencedColumnName = "idcarton", insertable = false, updatable = false)
    private BingoCarton carton;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "tipodocafil", referencedColumnName = "coddoc", insertable = false, updatable = false),
            @JoinColumn(name = "documentoafiliado", referencedColumnName = "cedtra", insertable = false, updatable = false)
    })
    private Subsi15 afiliado;

    // Getters y Setters para TODOS los campos (incluyendo los de la clave)
    public Integer getCodigoBingo() { return codigoBingo; }
    public void setCodigoBingo(Integer codigoBingo) { this.codigoBingo = codigoBingo; }
    public Integer getCodigoCarton() { return codigoCarton; }
    public void setCodigoCarton(Integer codigoCarton) { this.codigoCarton = codigoCarton; }
    public String getTipoDocumentoAfiliado() { return tipoDocumentoAfiliado; }
    public void setTipoDocumentoAfiliado(String tipoDocumentoAfiliado) { this.tipoDocumentoAfiliado = tipoDocumentoAfiliado; }
    public String getCedulaAfiliado() { return cedulaAfiliado; }
    public void setCedulaAfiliado(String cedulaAfiliado) { this.cedulaAfiliado = cedulaAfiliado; }
    public Bingo getBingo() { return bingo; }
    public void setBingo(Bingo bingo) { this.bingo = bingo; }
    public BingoCarton getCarton() { return carton; }
    public void setCarton(BingoCarton carton) { this.carton = carton; }
    public Subsi15 getAfiliado() { return afiliado; }
    public void setAfiliado(Subsi15 afiliado) { this.afiliado = afiliado; }
}