package br.com.gbrsistemas.main.service.cfm;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.controller.CfmController;
import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.dto.LoginRequestWrapper;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorRequest;
import br.com.gbrsistemas.main.service.base.AbstractBaseService;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;
import br.com.gbrsistemas.main.util.Constants;

@Path("/cfm")
@Consumes(Constants.JSON_UTF8)
@Produces(Constants.JSON_UTF8)
public class CfmService {
	
	@Inject
	private CfmController cfmController;

	@POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	@PermitAll
    public Response exportaDados(LoginRequestWrapper loginRequestWrapper) throws AccessTokenInvalidoException, JsonProcessingException {
    	this.cfmController.iniciaFluxo(loginRequestWrapper);
        return Response.ok(String.format("Olá, %s!", "teste")).build();
    }

}
