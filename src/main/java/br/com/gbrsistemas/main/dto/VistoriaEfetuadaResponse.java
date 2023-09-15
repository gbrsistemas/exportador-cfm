package br.com.gbrsistemas.main.dto;

import java.util.List;

public class VistoriaEfetuadaResponse {
    private List<VistoriaResponse> itens;
    private int total;

    public List<VistoriaResponse> getItens() {
        return itens;
    }

    public void setItens(List<VistoriaResponse> itens) {
        this.itens = itens;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
