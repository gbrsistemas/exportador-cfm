package br.com.gbrsistemas.main.dto;

public class IrregularidadesGedDTO {
	
	private String grupo;
	private String nome;
	private String descricao;
	private String situacaoIrregularidade;
	private String ufDemanda;
	private Integer idSituacaoIrregularidade ;
	private Integer numeroDemanda;
	private Integer anoDemanda;
	private Integer id;
	private Integer idProcesso;
	
	public IrregularidadesGedDTO() {}

	public IrregularidadesGedDTO(Integer id, Integer idSituacaoIrregularidade, Integer numeroDemanda, Integer anoDemanda, String grupo, String nome,
			String descricao, String situacaoIrregularidade, String ufDemanda, Integer idProcesso) {
		this.id = id;
		this.idSituacaoIrregularidade = idSituacaoIrregularidade;
		this.numeroDemanda = numeroDemanda;
		this.anoDemanda = anoDemanda;
		this.grupo = grupo;
		this.nome = nome;
		this.descricao = descricao;
		this.situacaoIrregularidade = situacaoIrregularidade;
		this.ufDemanda = ufDemanda;
		this.idProcesso = idProcesso;
	}
	
	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Integer getIdSituacaoIrregularidade() {
		return idSituacaoIrregularidade;
	}

	public void setIdSituacaoIrregularidade(Integer idSituacaoIrregularidade) {
		this.idSituacaoIrregularidade = idSituacaoIrregularidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUfDemanda() {
		return ufDemanda;
	}

	public void setUfDemanda(String ufDemanda) {
		this.ufDemanda = ufDemanda;
	}
}
