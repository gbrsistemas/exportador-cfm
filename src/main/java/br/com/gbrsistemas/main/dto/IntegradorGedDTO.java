package br.com.gbrsistemas.main.dto;

import java.util.Date;

public class IntegradorGedDTO {
	
	private Date dataVistoria;
	private Integer numeroDemanda;
	private Integer anoDemanda;
	private Integer idProcesso;

	public IntegradorGedDTO() {}

	public IntegradorGedDTO(Date dataVistoria, Integer numeroDemanda, Integer anoDemanda, Integer idProcesso) {
		this.dataVistoria = dataVistoria;
		this.numeroDemanda = numeroDemanda;
		this.anoDemanda = anoDemanda;
		this.idProcesso = idProcesso;
	}

	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Date getDataVistoria() {
		return dataVistoria;
	}
	
	public void setDataVistoria(Date dataVistoria) {
		this.dataVistoria = dataVistoria;
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
}
