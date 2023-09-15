package br.com.gbrsistemas.main.controller;

import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorRequest;
import br.com.gbrsistemas.main.dto.VistoriaResponse;
import br.com.gbrsistemas.main.dto.AnexoResponse;
import br.com.gbrsistemas.main.dto.AnexoSeletorRequest;
import br.com.gbrsistemas.main.dto.AnexoDTO;

import java.util.List;
import java.util.ArrayList;


import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaRequest;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponse;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;

public class CfmController {
	
	private String accesToken;
	private ApiController apiController;

	private Integer idDemanda;
	private Integer anoDemanda;
	
	public CfmController () {
		this.apiController = new ApiController(null);
	}
	
	public VistoriaResponse listarVistoria(VistoriaEfetuadaRequest vistoriaEfetuadaRequest) throws JsonProcessingException, AccessTokenInvalidoException {
		this.login();
		
		VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest = new VistoriaEfetuadaSeletorRequest();
		vistoriaEfetuadaSeletorRequest.setNumeroDemanda(vistoriaEfetuadaRequest.getAnoDemanda());
		vistoriaEfetuadaSeletorRequest.setAnoDemanda(vistoriaEfetuadaRequest.getAnoDemanda());
		vistoriaEfetuadaSeletorRequest.setUfDemanda(vistoriaEfetuadaRequest.getUfDemanda());
		vistoriaEfetuadaSeletorRequest.setDataInicialTransmissao(vistoriaEfetuadaRequest.getDataInicialTransmissao());
		vistoriaEfetuadaSeletorRequest.setDataFinalTransmissao(vistoriaEfetuadaRequest.getDataFinalTransmissao());

		VistoriaEfetuadaResponse vistoriaEfetuadaResponse =  this.apiController.listarVistoria(vistoriaEfetuadaSeletorRequest);

		if(vistoriaEfetuadaResponse.getItens().get(0) != null) {
			this.idDemanda = vistoriaEfetuadaResponse.getItens().get(0).getIdDemanda();
			this.anoDemanda = vistoriaEfetuadaResponse.getItens().get(0).getAnoDemanda();
			
			
			return vistoriaEfetuadaResponse.getItens().get(0);
			
		}	
		return null;
	}
	
	public List<String> baixarAnexo() throws AccessTokenInvalidoException, JsonProcessingException {
		this.login();
		
		this.idDemanda = 500637;
		this.anoDemanda = 2023;
		
		List<String> listaAnexo = new ArrayList<>();
		
		if (this.anoDemanda != null || this.idDemanda != null ) {
			AnexoSeletorRequest anexoSeletorRequest = new AnexoSeletorRequest();
			anexoSeletorRequest.setIdDemanda(this.idDemanda);
			//anexoSeletorRequest.setAno(this.anoDemanda);
			
			List<AnexoDTO> anexoResponse = this.apiController.postAnexo(anexoSeletorRequest);
			
			if (anexoResponse != null) {
			    for (AnexoDTO anexo : anexoResponse) {
			    	listaAnexo.add(this.apiController.baixarAnexo(anexo.getId()));
			    }
			}
			
			return listaAnexo;
		}

		return null;
	}

	public void login() throws JsonProcessingException {
		LoginRequest loginRequest = new LoginRequest("administradorfederal@teste.com.br", "@Cfm123");
		
		this.accesToken = this.apiController.postLogin(loginRequest);
		this.apiController = new ApiController(this.accesToken);
	}

}
