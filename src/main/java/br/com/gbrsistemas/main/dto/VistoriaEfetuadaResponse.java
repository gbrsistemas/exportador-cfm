package br.com.gbrsistemas.main.dto;

import java.util.Date;

public class VistoriaEfetuadaResponse {
	
    private int id;
    private int idDemanda;
    private int numeroDemanda;
    private int anoDemanda;
    private String ufDemanda;
    private String nomeUsuarioTransmissao;
    private int idTablet;
    private String numeroSerieTablet;
    private Date dataVistoria;
    private Date dataTransmissao;
    private String nome;
    private String nomeMunicipio;
    private String roteiro;
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdDemanda() {
		return idDemanda;
	}
	
	public void setIdDemanda(int idDemanda) {
		this.idDemanda = idDemanda;
	}
	
	public int getNumeroDemanda() {
		return numeroDemanda;
	}
	
	public void setNumeroDemanda(int numeroDemanda) {
		this.numeroDemanda = numeroDemanda;
	}
	
	public int getAnoDemanda() {
		return anoDemanda;
	}
	
	public void setAnoDemanda(int anoDemanda) {
		this.anoDemanda = anoDemanda;
	}
	
	public String getUfDemanda() {
		return ufDemanda;
	}
	
	public void setUfDemanda(String ufDemanda) {
		this.ufDemanda = ufDemanda;
	}
	
	public String getNomeUsuarioTransmissao() {
		return nomeUsuarioTransmissao;
	}
	
	public void setNomeUsuarioTransmissao(String nomeUsuarioTransmissao) {
		this.nomeUsuarioTransmissao = nomeUsuarioTransmissao;
	}
	
	public int getIdTablet() {
		return idTablet;
	}
	
	public void setIdTablet(int idTablet) {
		this.idTablet = idTablet;
	}
	
	public String getNumeroSerieTablet() {
		return numeroSerieTablet;
	}
	
	public void setNumeroSerieTablet(String numeroSerieTablet) {
		this.numeroSerieTablet = numeroSerieTablet;
	}
	
	public Date getDataVistoria() {
		return dataVistoria;
	}
	
	public void setDataVistoria(Date dataVistoria) {
		this.dataVistoria = dataVistoria;
	}
	
	public Date getDataTransmissao() {
		return dataTransmissao;
	}
	
	public void setDataTransmissao(Date dataTransmissao) {
		this.dataTransmissao = dataTransmissao;
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
	
	public String getRoteiro() {
		return roteiro;
	}
	
	public void setRoteiro(String roteiro) {
		this.roteiro = roteiro;
	}
}
