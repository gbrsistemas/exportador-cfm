package br.com.gbrsistemas.main.dto;

import java.util.List;
import br.com.gbrsistemas.main.dto.ItemAnexoDTO;

public class AnexoDTO {
	
    private List<ItemAnexoDTO> itens;
    private Integer total;
    
	public List<ItemAnexoDTO> getItens() {
		return itens;
	}
	public void setItens(List<ItemAnexoDTO> itens) {
		this.itens = itens;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

}