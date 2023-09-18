package br.com.gbrsistemas.main.dto;

import java.util.List;

public class VistoriaEfetuadaResponseDTO {
    private List<VistoriaResponseDTO> itens;
    private int total;

    public List<VistoriaResponseDTO> getItens() {
        return itens;
    }

    public void setItens(List<VistoriaResponseDTO> itens) {
        this.itens = itens;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
