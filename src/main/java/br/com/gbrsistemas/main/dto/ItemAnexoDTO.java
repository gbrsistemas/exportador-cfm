package br.com.gbrsistemas.main.dto;

import java.util.List;

public class ItemAnexoDTO {
    
    public static final String NOME_TERMO_VISTORIA = "termo-vistoria";
    public static final String NOME_RELATORIO_VISTORIA = "relatorio-vistoria";
    public static final String NOME_RELATORIO_VISTORIA_CONSOLIDADO = "relatorio-vistoria-consolidado";
    public static final String NOME_TERMO_NOTIFICACAO = "pdf-notificacao";
    
    public static final int ID_RELATORIO_VISTORIA_CONSOLIDADO = 12;
    public static final int ID_RELATORIO_VISTORIA = 11;
    public static final int ID_TERMO_VISTORIA = 10;
    public static final int ID_TERMO_NOTIFICACAO = 9;
	
    private Integer id;
    private String s3;
    private String descricao;
    private Integer idTipoDocumento;
    private String data;
    private String nome;
    private String extensao;
    private String nomeResponsavel;
    private String tipoDocumento;
    private List<AssinaturaDigitalDTO> assinaturasDigitais;
    private String assinaturaLabel;
    private Boolean enviadoFiscalizado;
    private String enviadoPor;
    private String dataEnvio;
    private String emailRecebidoPor;
	private String roteiro;
	private String dataCiencia;
	private String dataLeitura;

	public String getDataCiencia() {
		return dataCiencia;
	}
	public void setDataCiencia(String dataCiencia) {
		this.dataCiencia = dataCiencia;
	}
	public String getDataLeitura() {
		return dataLeitura;
	}
	public void setDataLeitura(String dataLeitura) {
		this.dataLeitura = dataLeitura;
	}
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
	public List<AssinaturaDigitalDTO> getAssinaturasDigitais() {
		return assinaturasDigitais;
	}
	public void setAssinaturasDigitais(List<AssinaturaDigitalDTO> assinaturasDigitais) {
		this.assinaturasDigitais = assinaturasDigitais;
	}
	public String getAssinaturaLabel() {
		return assinaturaLabel;
	}
	public void setAssinaturaLabel(String assinaturaLabel) {
		this.assinaturaLabel = assinaturaLabel;
	}
	public Boolean getEnviadoFiscalizado() {
		return enviadoFiscalizado;
	}
	public void setEnviadoFiscalizado(Boolean enviadoFiscalizado) {
		this.enviadoFiscalizado = enviadoFiscalizado;
	}
	public String getEnviadoPor() {
		return enviadoPor;
	}
	public void setEnviadoPor(String enviadoPor) {
		this.enviadoPor = enviadoPor;
	}
	public String getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public String getEmailRecebidoPor() {
		return emailRecebidoPor;
	}
	public void setEmailRecebidoPor(String emailRecebidoPor) {
		this.emailRecebidoPor = emailRecebidoPor;
	}
	public String getRoteiro() {
		return roteiro;
	}
	public void setRoteiro(String roteiro) {
		this.roteiro = roteiro;
	}
}
