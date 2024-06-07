package br.com.gbrsistemas.main.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VistoriaResponseDTO {
	private Integer id;
	private Integer idDemanda;
	private Integer numeroDemanda;
	private Integer anoDemanda;
	private String ufDemanda;
	private String nomeUsuarioTransmissao;
	private Integer idTablet;
	private String numeroSerieTablet;
	private String dataVistoria;
	private String dataTransmissao;
	private String nomeMunicipio;
	private String nome;
	private String roteiro;
	private Integer idUsuarioTransmissao;
	
	public VistoriaResponseDTO() {}
	
	public VistoriaResponseDTO(Integer id, Integer idDemanda, Integer numeroDemanda, Integer anoDemanda, String ufDemanda,
			String nomeUsuarioTransmissao, Integer idTablet, String numeroSerieTablet, String dataVistoria,
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdDemanda() {
		return idDemanda;
	}
	public void setIdDemanda(Integer idDemanda) {
		this.idDemanda = idDemanda;
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
	public String getNomeUsuarioTransmissao() {
		return nomeUsuarioTransmissao;
	}
	public void setNomeUsuarioTransmissao(String nomeUsuarioTransmissao) {
		this.nomeUsuarioTransmissao = nomeUsuarioTransmissao;
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

    public Integer getIdUsuarioTransmissao() {
        return idUsuarioTransmissao;
    }

    public void setIdUsuarioTransmissao(Integer idUsuarioTransmissao) {
        this.idUsuarioTransmissao = idUsuarioTransmissao;
    }
    
}
