package br.com.gbrsistemas.main.dto;

import java.util.List;
import br.com.gbrsistemas.main.dto.ItemAnexo;

public class AnexoResponse {
	
    private List<ItemAnexo> itens;
    private Integer total;
    
	public List<ItemAnexo> getItens() {
		return itens;
	}
	public void setItens(List<ItemAnexo> itens) {
		this.itens = itens;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

}