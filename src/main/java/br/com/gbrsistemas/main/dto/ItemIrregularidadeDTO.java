package br.com.gbrsistemas.main.dto;

public class ItemIrregularidadeDTO {
	
    private Integer id;
    private Integer vistoria;
    private String grupo;
    private String nome;
    private String descricao;
    private String situacaoIrregularidade;
    private Integer idSituacaoIrregularidade;
    private Boolean origemVistoria;
    private String dataAtualizacao;
    private String prazoLegal;
    private String codigoTablet;
    private String nomeUsuarioTransmissao;
    private Integer idDemanda;
    private Integer numeroDemanda;
    private Integer anoDemanda;
    private String ufDemanda;
    private String respostaQuestao;
    private Integer numeroCrm;
    private String nomeDemanda;
    private String nomeDiretor;
    private UltimaMovimentacaoDTO ultimaMovimentacao;
    private String dataAtualizacaoFormatada;
    private Integer totalAnexos;
    
	public ItemIrregularidadeDTO() {
	}
	
	public ItemIrregularidadeDTO(Integer id, Integer vistoria, String grupo, String nome, String descricao,
			String situacaoIrregularidade, Integer idSituacaoIrregularidade, Boolean origemVistoria,
			String dataAtualizacao, String prazoLegal, String codigoTablet, String nomeUsuarioTransmissao,
			Integer idDemanda, Integer numeroDemanda, Integer anoDemanda, String ufDemanda, String respostaQuestao,
			Integer numeroCrm, String nomeDemanda, String nomeDiretor, UltimaMovimentacaoDTO ultimaMovimentacao,
			String dataAtualizacaoFormatada, Integer totalAnexos) {
		this.id = id;
		this.vistoria = vistoria;
		this.grupo = grupo;
		this.nome = nome;
		this.descricao = descricao;
		this.situacaoIrregularidade = situacaoIrregularidade;
		this.idSituacaoIrregularidade = idSituacaoIrregularidade;
		this.origemVistoria = origemVistoria;
		this.dataAtualizacao = dataAtualizacao;
		this.prazoLegal = prazoLegal;
		this.codigoTablet = codigoTablet;
		this.nomeUsuarioTransmissao = nomeUsuarioTransmissao;
		this.idDemanda = idDemanda;
		this.numeroDemanda = numeroDemanda;
		this.anoDemanda = anoDemanda;
		this.ufDemanda = ufDemanda;
		this.respostaQuestao = respostaQuestao;
		this.numeroCrm = numeroCrm;
		this.nomeDemanda = nomeDemanda;
		this.nomeDiretor = nomeDiretor;
		this.ultimaMovimentacao = ultimaMovimentacao;
		this.dataAtualizacaoFormatada = dataAtualizacaoFormatada;
		this.totalAnexos = totalAnexos;
	}
	
	public Integer getTotalAnexos() {
		return totalAnexos;
	}

	public void setTotalAnexos(Integer totalAnexos) {
		this.totalAnexos = totalAnexos;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVistoria() {
		return vistoria;
	}
	public void setVistoria(Integer vistoria) {
		this.vistoria = vistoria;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSituacaoIrregularidade() {
		return situacaoIrregularidade;
	}
	public void setSituacaoIrregularidade(String situacaoIrregularidade) {
		this.situacaoIrregularidade = situacaoIrregularidade;
	}
	public Integer getIdSituacaoIrregularidade() {
		return idSituacaoIrregularidade;
	}
	public void setIdSituacaoIrregularidade(Integer idSituacaoIrregularidade) {
		this.idSituacaoIrregularidade = idSituacaoIrregularidade;
	}
	public Boolean getOrigemVistoria() {
		return origemVistoria;
	}
	public void setOrigemVistoria(Boolean origemVistoria) {
		this.origemVistoria = origemVistoria;
	}
	public String getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getPrazoLegal() {
		return prazoLegal;
	}
	public void setPrazoLegal(String prazoLegal) {
		this.prazoLegal = prazoLegal;
	}
	public String getCodigoTablet() {
		return codigoTablet;
	}
	public void setCodigoTablet(String codigoTablet) {
		this.codigoTablet = codigoTablet;
	}
	public String getNomeUsuarioTransmissao() {
		return nomeUsuarioTransmissao;
	}
	public void setNomeUsuarioTransmissao(String nomeUsuarioTransmissao) {
		this.nomeUsuarioTransmissao = nomeUsuarioTransmissao;
	}
	public Integer getIdDemanda() {
		return idDemanda;
	}
	public void setIdDemanda(Integer idDemanda) {
		this.idDemanda = idDemanda;
	}
	public Integer getNumeroDemanda() {
		return numeroDemanda;
	}
	public void setNumeroDemanda(Integer numeroDemanda) {
		this.numeroDemanda = numeroDemanda;
	}
	public Integer getAnoDemanda() {
		return anoDemanda;
	}
	public void setAnoDemanda(Integer anoDemanda) {
		this.anoDemanda = anoDemanda;
	}
	public String getUfDemanda() {
		return ufDemanda;
	}
	public void setUfDemanda(String ufDemanda) {
		this.ufDemanda = ufDemanda;
	}
	public String getRespostaQuestao() {
		return respostaQuestao;
	}
	public void setRespostaQuestao(String respostaQuestao) {
		this.respostaQuestao = respostaQuestao;
	}
	public Integer getNumeroCrm() {
		return numeroCrm;
	}
	public void setNumeroCrm(Integer numeroCrm) {
		this.numeroCrm = numeroCrm;
	}
	public String getNomeDemanda() {
		return nomeDemanda;
	}
	public void setNomeDemanda(String nomeDemanda) {
		this.nomeDemanda = nomeDemanda;
	}
	public String getNomeDiretor() {
		return nomeDiretor;
	}
	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}
	public UltimaMovimentacaoDTO getUltimaMovimentacao() {
		return ultimaMovimentacao;
	}
	public void setUltimaMovimentacao(UltimaMovimentacaoDTO ultimaMovimentacao) {
		this.ultimaMovimentacao = ultimaMovimentacao;
	}
	public String getDataAtualizacaoFormatada() {
		return dataAtualizacaoFormatada;
	}
	public void setDataAtualizacaoFormatada(String dataAtualizacaoFormatada) {
		this.dataAtualizacaoFormatada = dataAtualizacaoFormatada;
	}
    
    
}
