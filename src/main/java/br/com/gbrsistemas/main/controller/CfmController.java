package br.com.gbrsistemas.main.controller;

import br.com.gbrsistemas.main.util.JwtUtil;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorRequest;
import br.com.gbrsistemas.main.dto.AnexoResponse;
import br.com.gbrsistemas.main.dto.AnexoSeletorRequest;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponse;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;

public class CfmController {
	
	private String ACCESS_TOKEN;
	
	private ApiController apiController;
	
	private JwtUtil jwtUtil;

	
	public CfmController () {
		this.jwtUtil = new JwtUtil();
	}
	
	public void iniciaFluxo(LoginRequest loginRequest, VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest) throws AccessTokenInvalidoException, JsonProcessingException {
		this.postLogin(loginRequest.getLogin(), loginRequest.getSenha());
		VistoriaEfetuadaResponse vistoriaEfetuadaResponse = this.postVistorias(vistoriaEfetuadaSeletorRequest);
		
		//TODO
		//VERIFICAR DATAS
		AnexoSeletorRequest anexoSeletorRequest = new AnexoSeletorRequest();
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
		
		this.ACCESS_TOKEN = this.apiController.postLogin(loginRequest);
		this.apiController = new ApiController(this.ACCESS_TOKEN);
	}
	
	public VistoriaEfetuadaResponse postVistorias (VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest) throws AccessTokenInvalidoException, JsonProcessingException {
		this.verificaJwt();
		
		return this.apiController.postVistorias(vistoriaEfetuadaSeletorRequest);
	}
	
	public void getAnexo (Integer id) throws AccessTokenInvalidoException {
		this.verificaJwt();
		this.apiController.getAnexo(id);
	}
	
	public void verificaJwt() throws AccessTokenInvalidoException {
		this.jwtUtil.verificaAccessToken(this.ACCESS_TOKEN);
	}

}
