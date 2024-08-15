package br.com.gbrsistemas.main.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UltimaMovimentacaoDTO {

    private Integer id;
    private Integer idIrregularidade;
    private Integer idSituacaoIrregularidadeMovimentacao;
    private String usuario;
    private String observacao;
    private String data;

    public UltimaMovimentacaoDTO() {
    }

    public UltimaMovimentacaoDTO(Integer id, Integer idIrregularidade, String usuario, String observacao, String data) {
        super();
        this.id = id;
        this.idIrregularidade = idIrregularidade;
        this.usuario = usuario;
        this.observacao = observacao;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdIrregularidade() {
        return idIrregularidade;
    }

    public void setIdIrregularidade(Integer idIrregularidade) {
        this.idIrregularidade = idIrregularidade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getIdSituacaoIrregularidadeMovimentacao() {
        return idSituacaoIrregularidadeMovimentacao;
    }

    public void setIdSituacaoIrregularidadeMovimentacao(Integer idSituacaoIrregularidadeMovimentacao) {
        this.idSituacaoIrregularidadeMovimentacao = idSituacaoIrregularidadeMovimentacao;
    }

}
