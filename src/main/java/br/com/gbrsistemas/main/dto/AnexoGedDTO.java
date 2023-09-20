package br.com.gbrsistemas.main.dto;

public class AnexoGedDTO {
	
	private Integer idTipoDocumento;
	private Integer idProcesso;
	private String codigoDocumento;
	private String nome;
	private byte[] arquivo;

	private Integer numeroDemanda;
	private Integer anoDemanda;

	public AnexoGedDTO() {
	}

	public AnexoGedDTO(Integer idTipoDocumento, String codigoDocumento, String nome, byte[] arquivo,
			Integer numeroDemanda, Integer anoDemanda, Integer idProcesso) {
		this.idTipoDocumento = idTipoDocumento;
		this.codigoDocumento = codigoDocumento;
		this.nome = nome;
		this.arquivo = arquivo;
		this.numeroDemanda = numeroDemanda;
		this.anoDemanda = anoDemanda;
		this.idProcesso = idProcesso;
	}
	
	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getCodigoDocumento() {
		return codigoDocumento;
	}
	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
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
	
}
