package br.com.gbrsistemas.main.dto;

import java.util.List;

public class AnexoResponse {
	
    private List<AnexoDTO> itens;
    private Integer total;
    
	public List<AnexoDTO> getItens() {
		return itens;
	}
	public void setItens(List<AnexoDTO> itens) {
		this.itens = itens;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

}