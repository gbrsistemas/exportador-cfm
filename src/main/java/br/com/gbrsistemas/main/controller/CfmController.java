package br.com.gbrsistemas.main.controller;

import br.com.gbrsistemas.main.util.JwtUtil;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorRequest;
import br.com.gbrsistemas.main.dto.AnexoResponse;
import br.com.gbrsistemas.main.dto.AnexoSeletorRequest;
import br.com.gbrsistemas.main.dto.DemandaResponse;

import java.util.List;

import javax.inject.Inject;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.dto.LoginRequestWrapper;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponse;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;
import br.com.gbrsistemas.main.dto.DemandasRequest;

public class CfmController {
	
	private String accesToken;
	
	private ApiController apiController;
	
	private JwtUtil jwtUtil;

	
	public CfmController () {
		this.apiController = new ApiController(null);
		this.jwtUtil = new JwtUtil();
	}
	
	public void iniciaFluxo(LoginRequestWrapper loginRequestWrapper) throws AccessTokenInvalidoException, JsonProcessingException {
		this.postLogin(loginRequestWrapper.getLoginRequest().getLogin(), loginRequestWrapper.getLoginRequest().getSenha());
		VistoriaEfetuadaResponse vistoriaEfetuadaResponse = this.postVistorias(loginRequestWrapper.getVistoriaEfetuadaSeletorRequest());
		
		//TODO
		//VERIFICAR DATAS
		AnexoSeletorRequest anexoSeletorRequest = new AnexoSeletorRequest();

		
		List<DemandaResponse> demandas = this.postDemanda(
				loginRequestWrapper.getVistoriaEfetuadaSeletorRequest().getNumeroDemanda(),
				loginRequestWrapper.getVistoriaEfetuadaSeletorRequest().getAnoDemanda()
						);
		
		if (demandas != null) {
		    for (DemandaResponse demanda : demandas) {
		    	anexoSeletorRequest.setIdDemanda(demanda.getItens().get(0).getId());
		    }
		}
		
		List<AnexoResponse> anexoResponse = this.postAnexo(anexoSeletorRequest);
		
		if (anexoResponse != null) {
		    for (AnexoResponse anexo : anexoResponse) {
				this.getAnexo(anexo.getId());
		    }
		}
	}
	
	private List<AnexoResponse> postAnexo(AnexoSeletorRequest anexoSeletorRequest) throws JsonProcessingException, AccessTokenInvalidoException {
		this.verificaJwt();
		
		return this.apiController.postAnexo(anexoSeletorRequest);	
	}

	public void postLogin (String login, String senha) throws JsonProcessingException {
		LoginRequest loginRequest = new LoginRequest(login, senha);
		
		this.accesToken = this.apiController.postLogin(loginRequest);
		this.apiController = new ApiController(this.accesToken);
	}
	
	public VistoriaEfetuadaResponse postVistorias (VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest) throws AccessTokenInvalidoException, JsonProcessingException {
		this.verificaJwt();
		
		return this.apiController.postVistorias(vistoriaEfetuadaSeletorRequest);
	}
	
	public  List<DemandaResponse> postDemanda (Integer numeroDemanda, Integer anoDemanda) throws AccessTokenInvalidoException, JsonProcessingException {
		this.verificaJwt();
		
		DemandasRequest demandaRequest = new DemandasRequest();
		demandaRequest.setNumero(numeroDemanda);
		demandaRequest.setAno(anoDemanda);
		
		return this.apiController.postDemanda(demandaRequest);
	}
	
	public void getAnexo (Integer id) throws AccessTokenInvalidoException {
		this.verificaJwt();
		this.apiController.getAnexo(id);
	}
	
	public void verificaJwt() throws AccessTokenInvalidoException {
		//this.jwtUtil.verificaAccessToken(this.accesToken);
	}

}
