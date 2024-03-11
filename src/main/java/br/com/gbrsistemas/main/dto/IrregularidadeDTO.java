package br.com.gbrsistemas.main.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IrregularidadeDTO {
    private List<ItemIrregularidadeDTO> itens;
    private Integer total;
    
	public IrregularidadeDTO() {}
    
	public IrregularidadeDTO(List<ItemIrregularidadeDTO> itens, Integer total) {
		this.itens = itens;
		this.total = total;
	}
	
	public List<ItemIrregularidadeDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemIrregularidadeDTO> itens) {
		this.itens = itens;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
}