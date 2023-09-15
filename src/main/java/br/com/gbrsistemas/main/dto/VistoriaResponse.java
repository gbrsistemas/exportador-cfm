package br.com.gbrsistemas.main.dto;

public class VistoriaResponse {
	private int id;
	private int idDemanda;
	private int numeroDemanda;
	private int anoDemanda;
	private String ufDemanda;
	private String nomeUsuarioTransmissao;
	private int idTablet;
	private String numeroSerieTablet;
	private String dataVistoria;
	private String dataTransmissao;
	private String nomeMunicipio;
	private String nome;
	private String roteiro;
	
	public VistoriaResponse() {}
	
	public VistoriaResponse(int id, int idDemanda, int numeroDemanda, int anoDemanda, String ufDemanda,
			String nomeUsuarioTransmissao, int idTablet, String numeroSerieTablet, String dataVistoria,
			String dataTransmissao, String nomeMunicipio, String nome, String roteiro) {
		this.id = id;
		this.idDemanda = idDemanda;
		this.numeroDemanda = numeroDemanda;
		this.anoDemanda = anoDemanda;
		this.ufDemanda = ufDemanda;
		this.nomeUsuarioTransmissao = nomeUsuarioTransmissao;
		this.idTablet = idTablet;
		this.numeroSerieTablet = numeroSerieTablet;
		this.dataVistoria = dataVistoria;
		this.dataTransmissao = dataTransmissao;
		this.nomeMunicipio = nomeMunicipio;
		this.nome = nome;
		this.roteiro = roteiro;
	}
	
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
	public String getDataVistoria() {
		return dataVistoria;
	}
	public void setDataVistoria(String dataVistoria) {
		this.dataVistoria = dataVistoria;
	}
	public String getDataTransmissao() {
		return dataTransmissao;
	}
	public void setDataTransmissao(String dataTransmissao) {
		this.dataTransmissao = dataTransmissao;
	}
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}
	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRoteiro() {
		return roteiro;
	}
	public void setRoteiro(String roteiro) {
		this.roteiro = roteiro;
	}
	
}
