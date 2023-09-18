package br.com.gbrsistemas.main.dto;

import java.util.List;

public class VistoriaDTO {
    private List<ItemVistoriaDTO> itens;
    private Integer total;
    
	public VistoriaDTO() {}
    
	public VistoriaDTO(List<ItemVistoriaDTO> itens, Integer total) {
		this.itens = itens;
		this.total = total;
	}
	
	public List<ItemVistoriaDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemVistoriaDTO> itens) {
		this.itens = itens;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
}