package br.com.gbrsistemas.main.dto;

import java.util.Date;

public class VistoriaEfetuadaSeletorRequest {

    private Integer id;
    private Integer idUsuarioTransmissao;
    private Integer idTablet;
    private String numeroSerieTablet;
    private Integer numeroDemanda;
    private Integer anoDemanda;
    private String ufDemanda;
    private Date dataInicialTransmissao;    
    private Date dataFinalTransmissao;    
    private Date dataInicialVistoria;    
    private Date dataFinalVistoria;    
    private String nome;
    private String nomeMunicipio;
    private String nomeUsuarioTransmissao;
    private Integer idRoteiro;
    private Integer limite;
    private Integer pagina;
    private String orderField;
    private String orderType;
    
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
	
	public String getNumeroSerieTablet() {
		return numeroSerieTablet;
	}
	
	public void setNumeroSerieTablet(String numeroSerieTablet) {
		this.numeroSerieTablet = numeroSerieTablet;
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
	
	public Integer getLimite() {
		return limite;
	}
	
	public void setLimite(Integer limite) {
		this.limite = limite;
	}
	
	public Integer getPagina() {
		return pagina;
	}
	
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	
	public String getOrderField() {
		return orderField;
	}
	
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	
	public String getOrderType() {
		return orderType;
	}
	
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
    
}