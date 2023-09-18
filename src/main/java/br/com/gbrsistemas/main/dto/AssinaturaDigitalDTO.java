package br.com.gbrsistemas.main.dto;

import java.util.Date;

public class AssinaturaDigitalDTO {
	
    private Integer id;
    private Integer idReferencia;
    private String sistema;
    private Integer usuarioAssinante;
    private String certificadoNomeSignatario;
    private String certificadoCpf;
    private Date dataAssinatura;
    private Long timestampAssinatura;

	public AssinaturaDigitalDTO() {}
	
	public AssinaturaDigitalDTO(Integer id, Integer idReferencia, String sistema, Integer usuarioAssinante,
			String certificadoNomeSignatario, String certificadoCpf, Date dataAssinatura, Long timestampAssinatura) {
		this.id = id;
		this.idReferencia = idReferencia;
		this.sistema = sistema;
		this.usuarioAssinante = usuarioAssinante;
		this.certificadoNomeSignatario = certificadoNomeSignatario;
		this.certificadoCpf = certificadoCpf;
		this.dataAssinatura = dataAssinatura;
		this.timestampAssinatura = timestampAssinatura;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdReferencia() {
		return idReferencia;
	}
	public void setIdReferencia(Integer idReferencia) {
		this.idReferencia = idReferencia;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public Integer getUsuarioAssinante() {
		return usuarioAssinante;
	}
	public void setUsuarioAssinante(Integer usuarioAssinante) {
		this.usuarioAssinante = usuarioAssinante;
	}
	public String getCertificadoNomeSignatario() {
		return certificadoNomeSignatario;
	}
	public void setCertificadoNomeSignatario(String certificadoNomeSignatario) {
		this.certificadoNomeSignatario = certificadoNomeSignatario;
	}
	public String getCertificadoCpf() {
		return certificadoCpf;
	}
	public void setCertificadoCpf(String certificadoCpf) {
		this.certificadoCpf = certificadoCpf;
	}
	public Date getDataAssinatura() {
		return dataAssinatura;
	}
	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}
	public Long getTimestampAssinatura() {
		return timestampAssinatura;
	}
	public void setTimestampAssinatura(Long timestampAssinatura) {
		this.timestampAssinatura = timestampAssinatura;
	}
}
