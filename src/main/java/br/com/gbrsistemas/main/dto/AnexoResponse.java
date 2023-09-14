package br.com.gbrsistemas.main.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.gbrsistemas.main.dto.AssinaturaReferenciaDTO;

public class AnexoResponse {
	
	private Integer id;
    private String s3;
    private String descricao;
    private Integer protocolo;
    private Integer ano;
    private Integer idTipoDocumento;
    private Date data;
    private String nome;
    private String extensao;
    private String nomeResponsavel;
    private String roteiro;

    private String tipoDocumento;

    private List<AssinaturaReferenciaDTO> assinaturasDigitais;

    private String assinaturaLabel;
    
    private boolean enviadoFiscalizado;
    
    private Date dataCiencia;
    private Date dataLeitura;
    
    private String enviadoPor;
    private Date dataEnvio;
    private String emailRecebidoPor;

    public void addAssinatura(AssinaturaReferenciaDTO dto){
        if (this.assinaturasDigitais == null){
            this.assinaturasDigitais = new ArrayList<>();
        }
        this.assinaturasDigitais.add(dto);
        if (this.assinaturasDigitais.size() == 1){
            this.assinaturaLabel = "Assinado por " + dto.getCertificadoNomeSignatario();
        }
        else{
            this.assinaturaLabel = this.assinaturasDigitais.size() + " assinaturas";
        }
    }

    @Override
    public String toString() {
        return "{  id: " + this.id + ", s3: " + this.s3 + ", descricao: " + this.descricao + ", protocolo: " + this.protocolo + ", ano: " + this.ano + "}";
    }

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<AssinaturaReferenciaDTO> getAssinaturasDigitais() {
        return assinaturasDigitais;
    }

    public void setAssinaturasDigitais(List<AssinaturaReferenciaDTO> assinaturasDigitais) {
        this.assinaturasDigitais = assinaturasDigitais;
    }

    public String getAssinaturaLabel() {
        return assinaturaLabel;
    }

    public void setAssinaturaLabel(String assinaturaLabel) {
        this.assinaturaLabel = assinaturaLabel;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEnviadoFiscalizado() {
        return enviadoFiscalizado;
    }

    public void setEnviadoFiscalizado(boolean enviadoFiscalizado) {
        this.enviadoFiscalizado = enviadoFiscalizado;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(String roteiro) {
        this.roteiro = roteiro;
    }

	public Date getDataCiencia() {
		return dataCiencia;
	}

	public void setDataCiencia(Date dataCiencia) {
		this.dataCiencia = dataCiencia;
	}

	public Date getDataLeitura() {
		return dataLeitura;
	}

	public void setDataLeitura(Date dataLeitura) {
		this.dataLeitura = dataLeitura;
	}

	public String getEnviadoPor() {
		return enviadoPor;
	}

	public void setEnviadoPor(String enviadoPor) {
		this.enviadoPor = enviadoPor;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getEmailRecebidoPor() {
		return emailRecebidoPor;
	}

	public void setEmailRecebidoPor(String emailRecebidoPor) {
		this.emailRecebidoPor = emailRecebidoPor;
	}
}
