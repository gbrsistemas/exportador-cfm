package br.com.gbrsistemas.main;

import java.util.Date;

public class FiltroRequest {

    private Integer id;
    private Integer idUsuarioTransmissao;
    private Integer idTablet;
    private Integer idRoteiro;
    private Integer numeroDemanda;
    private Integer anoDemanda;
    private String nome;
    private String nomeMunicipio;
    private String nomeUsuarioTransmissao;
    private String numeroSerieTablet;
    private String ufDemanda;
    private Date dataInicialTransmissao;
    private Date dataFinalTransmissao;
    private Date dataInicialVistoria;
    private Date dataFinalVistoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuarioTransmissao() {
        return idUsuarioTransmissao;
    }

    public void setIdUsuarioTransmissao(Integer idUsuarioTransmissao) {
        this.idUsuarioTransmissao = idUsuarioTransmissao;
    }

    public Integer getIdTablet() {
        return idTablet;
    }

    public void setIdTablet(Integer idTablet) {
        this.idTablet = idTablet;
    }

    public Integer getNumeroDemanda() {
        return numeroDemanda;
    }

    public void setNumeroDemanda(Integer numeroDemanda) {
        this.numeroDemanda = numeroDemanda;
    }

    public Integer getAnoDemanda() {
        return anoDemanda;
    }

    public void setAnoDemanda(Integer anoDemanda) {
        this.anoDemanda = anoDemanda;
    }

    public String getUfDemanda() {
        return ufDemanda;
    }

    public void setUfDemanda(String ufDemanda) {
        this.ufDemanda = ufDemanda;
    }

    public Date getDataInicialTransmissao() {
        return dataInicialTransmissao;
    }

    public void setDataInicialTransmissao(Date dataInicialTransmissao) {
        this.dataInicialTransmissao = dataInicialTransmissao;
    }

    public Date getDataFinalTransmissao() {
        return dataFinalTransmissao;
    }

    public void setDataFinalTransmissao(Date dataFinalTransmissao) {
        this.dataFinalTransmissao = dataFinalTransmissao;
    }

    public Date getDataInicialVistoria() {
        return dataInicialVistoria;
    }

    public void setDataInicialVistoria(Date dataInicialVistoria) {
        this.dataInicialVistoria = dataInicialVistoria;
    }

    public Date getDataFinalVistoria() {
        return dataFinalVistoria;
    }

    public void setDataFinalVistoria(Date dataFinalVistoria) {
        this.dataFinalVistoria = dataFinalVistoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroSerieTablet() {
        return numeroSerieTablet;
    }

    public void setNumeroSerieTablet(String numeroSerieTablet) {
        this.numeroSerieTablet = numeroSerieTablet;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public String getNomeUsuarioTransmissao() {
        return nomeUsuarioTransmissao;
    }

    public void setNomeUsuarioTransmissao(String nomeUsuarioTransmissao) {
        this.nomeUsuarioTransmissao = nomeUsuarioTransmissao;
    }

    public Integer getIdRoteiro() {
        return idRoteiro;
    }

    public void setIdRoteiro(Integer idRoteiro) {
        this.idRoteiro = idRoteiro;
    }
}
