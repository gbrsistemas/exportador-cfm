package br.com.gbrsistemas.main.dto;

import java.util.List;

public class IrregularidadesSeletorDemandasDTO {
	private Integer id;
    private List<Integer> ids;
    private Integer vistoria;
    private String grupo;
    private String nome;
    private String descricao;
    private Integer origemVistoria;
    private Integer idDemanda;
    private Integer idSituacaoIrregularidade;
    private List<Integer> idsSituacaoIrregularidade;

    private Integer tipoPessoaDemanda;
    private Integer crmDemanda;
    private String ufCrmDemanda;

    private Integer idProcessoSged;
    private Boolean acessoFiscalizado;
    private Boolean carregarHistorico;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVistoria() {
        return this.vistoria;
    }

    public void setVistoria(Integer vistoria) {
        this.vistoria = vistoria;
    }

    public String getGrupo() {
        return this.grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrigemVistoria() {
        return this.origemVistoria;
    }

    public void setOrigemVistoria(Integer origemVistoria) {
        this.origemVistoria = origemVistoria;
    }

    public Integer getIdSituacaoIrregularidade() {
        return this.idSituacaoIrregularidade;
    }

    public void setIdSituacaoIrregularidade(Integer idSituacaoIrregularidade) {
        this.idSituacaoIrregularidade = idSituacaoIrregularidade;
    }

    public Integer getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(Integer idDemanda) {
        this.idDemanda = idDemanda;
    }

    public List<Integer> getIdsSituacaoIrregularidade() {
        return idsSituacaoIrregularidade;
    }

    public void setIdsSituacaoIrregularidade(List<Integer> idsSituacaoIrregularidade) {
        this.idsSituacaoIrregularidade = idsSituacaoIrregularidade;
    }

    public Integer getCrmDemanda() {
        return crmDemanda;
    }

    public void setCrmDemanda(Integer crmDemanda) {
        this.crmDemanda = crmDemanda;
    }

    public String getUfCrmDemanda() {
        return ufCrmDemanda;
    }

    public void setUfCrmDemanda(String ufCrmDemanda) {
        this.ufCrmDemanda = ufCrmDemanda;
    }

    public Integer getTipoPessoaDemanda() {
        return tipoPessoaDemanda;
    }

    public void setTipoPessoaDemanda(Integer tipoPessoaDemanda) {
        this.tipoPessoaDemanda = tipoPessoaDemanda;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getIdProcessoSged() {
        return idProcessoSged;
    }

    public void setIdProcessoSged(Integer idProcessoSged) {
        this.idProcessoSged = idProcessoSged;
    }

    public Boolean getAcessoFiscalizado() {
        return acessoFiscalizado;
    }

    public void setAcessoFiscalizado(Boolean acessoFiscalizado) {
        this.acessoFiscalizado = acessoFiscalizado;
    }

    public Boolean getCarregarHistorico() {
        return carregarHistorico;
    }

    public void setCarregarHistorico(Boolean carregarHistorico) {
        this.carregarHistorico = carregarHistorico;
    }
}
