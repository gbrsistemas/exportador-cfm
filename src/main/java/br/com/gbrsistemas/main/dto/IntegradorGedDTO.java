package br.com.gbrsistemas.main.dto;

import java.util.Date;

public class IntegradorGedDTO {
	
	private Date dataVistoria;
	private Integer numeroDemanda;
	private Integer anoDemanda;

	public IntegradorGedDTO() {}

	public IntegradorGedDTO(Date dataVistoria, Integer numeroDemanda, Integer anoDemanda) {
		this.dataVistoria = dataVistoria;
		this.numeroDemanda = numeroDemanda;
		this.anoDemanda = anoDemanda;
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
