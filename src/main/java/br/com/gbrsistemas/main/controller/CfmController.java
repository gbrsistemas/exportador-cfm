package br.com.gbrsistemas.main.controller;

import br.com.gbrsistemas.main.FiltroRequest;
import br.com.gbrsistemas.main.util.JwtUtil;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;

public class CfmController {
	
	private String API;
	private String ACCESS_TOKEN;
	
	private ApiController apiController;
	private JwtUtil jwtUtil;

	
	public CfmController () {
		this.API = "https://cfm.crvirtual.online";
		this.jwtUtil = new JwtUtil();
	}
	
	public void login (String login, String senha) {
		this.apiController = new ApiController(
				this.API + "/oauth2/token", 
				null
				);
		
		this.ACCESS_TOKEN = this.apiController.post(null);
	}
	
	public void listaVistorias (FiltroRequest filtroRequest) throws AccessTokenInvalidoException {
		this.verificaJwt();
		
		this.apiController = new ApiController(
				this.API + "/crvirtual-demandas/vistoria/pesquisar-vistorias-efetuadas/", 
				this.ACCESS_TOKEN
				);
		
	}
	
	public void exportarVistorias () throws AccessTokenInvalidoException {
		this.verificaJwt();

	}
	
	public void verificaJwt() throws AccessTokenInvalidoException {
		this.jwtUtil.verificaAccessToken(this.ACCESS_TOKEN);
	}
}
