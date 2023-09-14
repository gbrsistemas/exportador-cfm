package br.com.gbrsistemas.main.service.cfm;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.gbrsistemas.main.controller.CfmController;
import br.com.gbrsistemas.main.dto.FiltroRequest;
import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.service.base.AbstractBaseService;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;
import br.com.gbrsistemas.main.util.Constants;

@Path("/cfm")
@Consumes(Constants.JSON_UTF8)
@Produces(Constants.JSON_UTF8)
public class CfmService extends AbstractBaseService {
	
	@Inject
	private CfmController cfmController;

    @POST
    @Path("/login")
    public Response exportaDados(LoginRequest loginRequest) throws AccessTokenInvalidoException {
    	this.cfmController.iniciaFluxo();
    	this.cfmController.postLogin(loginRequest);
        return Response.ok(String.format("Olá, %s!", this.usuarioAutenticado.getNome())).build();
    }
    
    @POST
    @Path("/login")
    public Response postVistorias(FiltroRequest filtroRequest) throws AccessTokenInvalidoException {
    	this.cfmController.postVistorias(filtroRequest);
        return Response.ok(String.format("Olá, %s!", this.usuarioAutenticado.getNome())).build();
    }
    
    @GET
    @Path("/anexo/{id}")
    public Response getAnexo(Integer id) throws AccessTokenInvalidoException {
    	this.cfmController.getAnexo(id);
        return Response.ok(String.format("Olá, %s!", this.usuarioAutenticado.getNome())).build();
    }

}
