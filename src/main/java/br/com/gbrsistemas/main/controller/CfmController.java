package br.com.gbrsistemas.main.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.AnexoSeletorDTO;
import br.com.gbrsistemas.main.dto.ItemAnexoDTO;
import br.com.gbrsistemas.main.dto.ItemVistoriaDTO;
import br.com.gbrsistemas.main.dto.LoginDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponseDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorDTO;
import br.com.gbrsistemas.main.dto.VistoriaResponseDTO;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;

@Stateless
public class CfmController {
    
    private String accesToken;
	
	@Inject
	private ApiController apiController;

	private Integer idDemanda;
	private Integer anoDemanda;
	    
    @Inject
    @ConfigProperty(name = "cfm.username")
    private String username;
    
    @Inject
    @ConfigProperty(name = "cfm.password")
    private String password;
	
	public VistoriaResponseDTO listarVistoria(VistoriaEfetuadaDTO vistoriaEfetuadaRequest) throws JsonProcessingException, AccessTokenInvalidoException {
		this.login();
		
		VistoriaEfetuadaSeletorDTO vistoriaEfetuadaSeletorRequest = new VistoriaEfetuadaSeletorDTO();
		vistoriaEfetuadaSeletorRequest.setNumeroDemanda(vistoriaEfetuadaRequest.getNumeroDemanda());
		vistoriaEfetuadaSeletorRequest.setAnoDemanda(vistoriaEfetuadaRequest.getAnoDemanda());
		vistoriaEfetuadaSeletorRequest.setUfDemanda(vistoriaEfetuadaRequest.getUfDemanda());
		vistoriaEfetuadaSeletorRequest.setDataInicialTransmissao(vistoriaEfetuadaRequest.getDataInicialTransmissao());
		vistoriaEfetuadaSeletorRequest.setDataFinalTransmissao(vistoriaEfetuadaRequest.getDataFinalTransmissao());

		VistoriaEfetuadaResponseDTO vistoriaEfetuadaResponse =  this.apiController.listarVistoria(vistoriaEfetuadaSeletorRequest, this.accesToken);

		if(vistoriaEfetuadaResponse != null && vistoriaEfetuadaResponse.getItens() != null && 
		        !vistoriaEfetuadaResponse.getItens().isEmpty() && vistoriaEfetuadaResponse.getItens().get(0) != null) {
			this.idDemanda = vistoriaEfetuadaResponse.getItens().get(0).getIdDemanda();
			this.anoDemanda = vistoriaEfetuadaResponse.getItens().get(0).getAnoDemanda();			
			
			return vistoriaEfetuadaResponse.getItens().get(0);
			
		}	
		return null;
	}
	
	public Response baixarAnexo() throws AccessTokenInvalidoException, JsonProcessingException {
		this.login();
		
		if (this.anoDemanda != null || this.idDemanda != null ) {
			AnexoSeletorDTO anexoSeletorRequest = new AnexoSeletorDTO();
			anexoSeletorRequest.setIdDemanda(this.idDemanda);
			
			List<ItemAnexoDTO> anexoResponse = this.apiController.postAnexo(anexoSeletorRequest, this.accesToken);
			
			if (anexoResponse != null) {
			    for (ItemAnexoDTO anexo : anexoResponse) {
			    	return this.apiController.baixarAnexo(anexo.getId(), this.accesToken);
			    }
			}
		}
		
		return null;
	}
	
	public List<ItemVistoriaDTO> listaIrregularidades() throws AccessTokenInvalidoException, JsonProcessingException {
		this.login();
		
		if(this.idDemanda != null) {
			return this.apiController.postIrregularidade(this.idDemanda, accesToken);
		}
		
		return null;
	}

	public void login() throws JsonProcessingException {	    
		LoginDTO loginRequest = new LoginDTO(this.username, this.password);
		
		this.accesToken = this.apiController.postLogin(loginRequest);
	}

}
