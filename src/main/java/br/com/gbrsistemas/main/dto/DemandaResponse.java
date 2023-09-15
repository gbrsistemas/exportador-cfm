package br.com.gbrsistemas.main.dto;

import java.util.List;

public class DemandaResponse {
	
	private List<DemandaDTO> itens;
	private int total;
	
	public List<DemandaDTO> getItens() {
	    return itens;
	}
	
	public void setItens(List<DemandaDTO> itens) {
	    this.itens = itens;
	}
	
	public int getTotal() {
	    return total;
	}
	
	public void setTotal(int total) {
	    this.total = total;
	}

}
