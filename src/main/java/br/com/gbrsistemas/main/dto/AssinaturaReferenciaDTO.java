package br.com.gbrsistemas.main.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssinaturaReferenciaDTO {

    private Integer id;
    private Integer idReferencia;

    private String sistema;

    private Integer usuarioAssinante;
    private String certificadoNomeSignatario;
    private String certificadoCpf;

    private String cpfCnpjAssinanteExterno;

    private Date dataAssinatura;
    private Long timestampAssinatura;

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

    public String getCertificadoNomeSignatario() {
        return certificadoNomeSignatario;
    }

    public void setCertificadoNomeSignatario(String certificadoNomeSignatario) {
        this.certificadoNomeSignatario = certificadoNomeSignatario;
    }

    public Date getDataAssinatura() {
        return dataAssinatura;
    }

    public void setDataAssinatura(Date dataAssinatura) {
        this.dataAssinatura = dataAssinatura;
    }

    public Integer getUsuarioAssinante() {
        return usuarioAssinante;
    }

    public void setUsuarioAssinante(Integer usuarioAssinante) {
        this.usuarioAssinante = usuarioAssinante;
    }

    public String getCertificadoCpf() {
        return certificadoCpf;
    }

    public void setCertificadoCpf(String certificadoCpf) {
        this.certificadoCpf = certificadoCpf;
    }

    public Long getTimestampAssinatura() {
        return timestampAssinatura;
    }

    public void setTimestampAssinatura(Long timestampAssinatura) {
        this.timestampAssinatura = timestampAssinatura;
    }

    public String getCpfCnpjAssinanteExterno() {
        return cpfCnpjAssinanteExterno;
    }

    public void setCpfCnpjAssinanteExterno(String cpfCnpjAssinanteExterno) {
        this.cpfCnpjAssinanteExterno = cpfCnpjAssinanteExterno;
    }
}
