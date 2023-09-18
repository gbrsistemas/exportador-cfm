package br.com.gbrsistemas.main.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.AnexoSeletorRequest;
import br.com.gbrsistemas.main.dto.ItemAnexo;
import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaRequest;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponse;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorRequest;
import br.com.gbrsistemas.main.dto.VistoriaResponse;
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
	
	public VistoriaResponse listarVistoria(VistoriaEfetuadaRequest vistoriaEfetuadaRequest) throws JsonProcessingException, AccessTokenInvalidoException {
		this.login();
		
		VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest = new VistoriaEfetuadaSeletorRequest();
		vistoriaEfetuadaSeletorRequest.setNumeroDemanda(vistoriaEfetuadaRequest.getNumeroDemanda());
		vistoriaEfetuadaSeletorRequest.setAnoDemanda(vistoriaEfetuadaRequest.getAnoDemanda());
		vistoriaEfetuadaSeletorRequest.setUfDemanda(vistoriaEfetuadaRequest.getUfDemanda());
		vistoriaEfetuadaSeletorRequest.setDataInicialTransmissao(vistoriaEfetuadaRequest.getDataInicialTransmissao());
		vistoriaEfetuadaSeletorRequest.setDataFinalTransmissao(vistoriaEfetuadaRequest.getDataFinalTransmissao());

		VistoriaEfetuadaResponse vistoriaEfetuadaResponse =  this.apiController.listarVistoria(vistoriaEfetuadaSeletorRequest, this.accesToken);

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
		
		this.idDemanda = 500637;
		this.anoDemanda = 2023;
		
		if (this.anoDemanda != null || this.idDemanda != null ) {
			AnexoSeletorRequest anexoSeletorRequest = new AnexoSeletorRequest();
			anexoSeletorRequest.setIdDemanda(this.idDemanda);
			
			List<ItemAnexo> anexoResponse = this.apiController.postAnexo(anexoSeletorRequest, this.accesToken);
			
			if (anexoResponse != null) {
			    for (ItemAnexo anexo : anexoResponse) {
			    	//listaAnexo.add(this.apiController.baixarAnexo(anexo.getId()));
			    	return this.apiController.baixarAnexo(anexo.getId(), this.accesToken);
			    }
			}
		}
		
		return null;
	}

	public void login() throws JsonProcessingException {	    
		LoginRequest loginRequest = new LoginRequest(this.username, this.password);
		
		this.accesToken = this.apiController.postLogin(loginRequest);
	}

}
