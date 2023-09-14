package br.com.gbrsistemas.main.dto;

import java.util.List;

public class AnexoSeletorRequest {

    private Integer id;
    private String s3;
    private String descricao;
    private Integer protocolo;
    private Integer ano;
    private Integer idTipoDocumento;
    private List<Integer> idsTipoDocumento;
    private Integer idDemanda;
    private List<Integer> ids;
    private Boolean enviadoFiscalizado;
    private Boolean possuiCiencia;
    private Integer numeroCrm;
	private Integer numeroCrmDiretor;
	private Integer tipoPessoa;

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getS3() {
        return this.s3;
    }
    public void setS3(String s3) {
        this.s3 = s3;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getProtocolo() {
        return this.protocolo;
    }
    public void setProtocolo(Integer protocolo) {
        this.protocolo = protocolo;
    }
    public Integer getAno() {
        return this.ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(Integer idDemanda) {
        this.idDemanda = idDemanda;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Boolean isEnviadoFiscalizado() {
        return enviadoFiscalizado;
    }

    public void setEnviadoFiscalizado(Boolean enviadoFiscalizado) {
        this.enviadoFiscalizado = enviadoFiscalizado;
    }
    public List<Integer> getIdsTipoDocumento() {
        return idsTipoDocumento;
    }
    public void setIdsTipoDocumento(List<Integer> idsTipoDocumento) {
        this.idsTipoDocumento = idsTipoDocumento;
    }
	public Boolean getPossuiCiencia() {
		return possuiCiencia;
	}
	public void setPossuiCiencia(Boolean possuiCiencia) {
		this.possuiCiencia = possuiCiencia;
	}
	public Integer getNumeroCrmDiretor() {
		return numeroCrmDiretor;
	}
	public void setNumeroCrmDiretor(Integer numeroCrmDiretor) {
		this.numeroCrmDiretor = numeroCrmDiretor;
	}
	public Integer getNumeroCrm() {
		return numeroCrm;
	}
	public void setNumeroCrm(Integer numeroCrm) {
		this.numeroCrm = numeroCrm;
	}
	public Integer getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(Integer tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
}
