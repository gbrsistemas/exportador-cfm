package br.com.gbrsistemas.main.dto;

import java.util.Date;

public class VistoriaEfetuadaDTO {
	
    private Integer numeroDemanda;
    private Integer anoDemanda;
    private String ufDemanda;
    private Date dataInicialTransmissao;    
    private Date dataFinalTransmissao;   
    
	public VistoriaEfetuadaDTO() {
	}
    
	public VistoriaEfetuadaDTO(Integer numeroDemanda, Integer anoDemanda, String ufDemanda,
			Date dataInicialTransmissao, Date dataFinalTransmissao) {
		this.numeroDemanda = numeroDemanda;
		this.anoDemanda = anoDemanda;
		this.ufDemanda = ufDemanda;
		this.dataInicialTransmissao = dataInicialTransmissao;
		this.dataFinalTransmissao = dataFinalTransmissao;
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
    
}
