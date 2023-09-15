package br.com.gbrsistemas.main.dto;

import java.util.Date;
import java.util.List;

public class DemandasRequest {

	private List<Integer> idsDemanda;
	private Integer numero;
	private Integer ano;
	private String uf;
	private Integer idMunicipio;
	private String cep;

	private List<Integer> idsOrigem;
	private List<Integer> idsSituacao;
	private List<Integer> idsMotivo;
	private List<Integer> idsUsuariosResponsaveisEncaminhamento;
	private List<Integer> idsUsuariosQueEncaminharam;
	private List<String> nomesIrregularidades;

	private Integer semCrm;
	private Integer numeroCrm;
	private String nome;
	private String nomeFantasia;
	private String cpfCnpj;
	private Integer numeroCrmDiretor;
	private String nomeDiretor;
	private Boolean temEncaminhamentoAtrasado;

	private Integer tipoPessoa;
	private Boolean temIrregularidade;
	private Boolean temInterdicao;

	private Date dataInicial;
	private Date dataFinal;

	private String classificacaoPJ;

	private Date prazoEncaminhamentoInicio;
	private Date prazoEncaminhamentoFim;

	private Date prazoIrregularidadeInicio;
	private Date prazoIrregularidadeFim;

	private Date prazoInterdicaoInicio;
	private Date prazoInterdicaoFim;
	
	private List<Integer> idsSituacaoIrregularidade;

	private String nomeSocial;
	
	private String nomePesquisa;

	private Boolean fiscalizadoNotificado;
	
	public List<Integer> getIdsDemanda() {
		return idsDemanda;
	}

	public void setIdsDemanda(List<Integer> idsDemanda) {
		this.idsDemanda = idsDemanda;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getSemCrm() {
		return this.semCrm;
	}

	public void setSemCrm(Integer semCrm) {
		this.semCrm = semCrm;
	}

	public Integer getNumeroCrm() {
		return this.numeroCrm;
	}

	public void setNumeroCrm(Integer numeroCrm) {
		this.numeroCrm = numeroCrm;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCpfCnpj() {
		//TODO melhorar isso
		if(this.cpfCnpj != null && !this.cpfCnpj.isEmpty()){
			this.cpfCnpj = this.cpfCnpj.replace(".","")
					                   .replace("-", "")
					                   .replace("/", "");
		}

		return this.cpfCnpj;
	}

	public void setCpfCnpj(String cpfcnpj) {
		this.cpfCnpj = cpfcnpj;
	}

	public Integer getNumeroCrmDiretor() {
		return this.numeroCrmDiretor;
	}

	public void setNumeroCrmDiretor(Integer numeroCrmDiretor) {
		this.numeroCrmDiretor = numeroCrmDiretor;
	}

	public String getNomeDiretor() {
		return this.nomeDiretor;
	}

	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}

	public Integer getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(Integer tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Integer> getIdsOrigem() {
		return idsOrigem;
	}

	public void setIdsOrigem(List<Integer> idsOrigem) {
		this.idsOrigem = idsOrigem;
	}

	public List<Integer> getIdsSituacao() {
		return idsSituacao;
	}

	public void setIdsSituacao(List<Integer> idsSituacao) {
		this.idsSituacao = idsSituacao;
	}

	public List<Integer> getIdsMotivo() {
		return idsMotivo;
	}

	public void setIdsMotivo(List<Integer> idsMotivo) {
		this.idsMotivo = idsMotivo;
	}

	public Boolean temIrregularidade() {
		return temIrregularidade;
	}

	public void setTemIrregularidade(Boolean temIrregularidade) {
		this.temIrregularidade = temIrregularidade;
	}

	public List<Integer> getIdsUsuariosResponsaveisEncaminhamento() {
		return idsUsuariosResponsaveisEncaminhamento;
	}

	public void setIdsUsuariosResponsaveisEncaminhamento(List<Integer> idsUsuariosResponsaveisEncaminhamento) {
		this.idsUsuariosResponsaveisEncaminhamento = idsUsuariosResponsaveisEncaminhamento;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<String> getNomesIrregularidades() {
		return nomesIrregularidades;
	}

	public void setNomesIrregularidades(List<String> nomesIrregularidades) {
		this.nomesIrregularidades = nomesIrregularidades;
	}

	public List<Integer> getIdsUsuariosQueEncaminharam() {
		return idsUsuariosQueEncaminharam;
	}

	public void setIdsUsuariosQueEncaminharam(List<Integer> idsUsuariosQueEncaminharam) {
		this.idsUsuariosQueEncaminharam = idsUsuariosQueEncaminharam;
	}

	public Boolean getTemEncaminhamentoAtrasado() {
		return temEncaminhamentoAtrasado;
	}

	public void setTemEncaminhamentoAtrasado(Boolean temEncaminhamentoAtrasado) {
		this.temEncaminhamentoAtrasado = temEncaminhamentoAtrasado;
	}

	public Boolean getTemIrregularidade() {
		return temIrregularidade;
	}

	public String getClassificacaoPJ() {
		return classificacaoPJ;
	}

	public void setClassificacaoPJ(String classificacaoPJ) {
		this.classificacaoPJ = classificacaoPJ;
	}

	public Boolean temInterdicao() {
		return temInterdicao;
	}

	public void setTemInterdicao(Boolean temInterdicao) {
		this.temInterdicao = temInterdicao;
	}

	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Date getPrazoEncaminhamentoInicio() {
		return prazoEncaminhamentoInicio;
	}

	public void setPrazoEncaminhamentoInicio(Date prazoEncaminhamentoInicio) {
		this.prazoEncaminhamentoInicio = prazoEncaminhamentoInicio;
	}

	public Date getPrazoEncaminhamentoFim() {
		return prazoEncaminhamentoFim;
	}

	public void setPrazoEncaminhamentoFim(Date prazoEncaminhamentoFim) {
		this.prazoEncaminhamentoFim = prazoEncaminhamentoFim;
	}

	public Date getPrazoIrregularidadeInicio() {
		return prazoIrregularidadeInicio;
	}

	public void setPrazoIrregularidadeInicio(Date prazoIrregularidadeInicio) {
		this.prazoIrregularidadeInicio = prazoIrregularidadeInicio;
	}

	public Date getPrazoIrregularidadeFim() {
		return prazoIrregularidadeFim;
	}

	public void setPrazoIrregularidadeFim(Date prazoIrregularidadeFim) {
		this.prazoIrregularidadeFim = prazoIrregularidadeFim;
	}

	public Date getPrazoInterdicaoInicio() {
		return prazoInterdicaoInicio;
	}

	public void setPrazoInterdicaoInicio(Date prazoInterdicaoInicio) {
		this.prazoInterdicaoInicio = prazoInterdicaoInicio;
	}

	public Date getPrazoInterdicaoFim() {
		return prazoInterdicaoFim;
	}

	public void setPrazoInterdicaoFim(Date prazoInterdicaoFim) {
		this.prazoInterdicaoFim = prazoInterdicaoFim;
	}

	public List<Integer> getIdsSituacaoIrregularidade() {
		return idsSituacaoIrregularidade;
	}

	public void setIdsSituacaoIrregularidade(List<Integer> idsSituacaoIrregularidade) {
		this.idsSituacaoIrregularidade = idsSituacaoIrregularidade;
	}

	public String getNomeSocial() {
        return this.nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }
    
    public Boolean getFiscalizadoNotificado() {
		return fiscalizadoNotificado;
	}

	public void setFiscalizadoNotificado(Boolean fiscalizadoNotificado) {
		this.fiscalizadoNotificado = fiscalizadoNotificado;
	}

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }
}
