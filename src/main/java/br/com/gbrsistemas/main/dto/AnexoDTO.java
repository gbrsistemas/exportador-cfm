package br.com.gbrsistemas.main.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class AnexoDTO {
	
	private Integer id;
	private String s3;
	private String descricao;
	private Integer idTipoDocumento;
	private Date data;
	private String nome;
	private String extensao;
	private String nomeResponsavel;
	private String tipoDocumento;
	private Boolean enviadoFiscalizado;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getExtensao() {
		return extensao;
	}
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Boolean getEnviadoFiscalizado() {
		return enviadoFiscalizado;
	}
	public void setEnviadoFiscalizado(Boolean enviadoFiscalizado) {
		this.enviadoFiscalizado = enviadoFiscalizado;
	}

}
