package br.com.gbrsistemas.main.service.cfm;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.controller.CfmController;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaRequest;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;
import br.com.gbrsistemas.main.util.Constants;

@Path("/importar")
@Consumes(Constants.JSON_UTF8)
@Produces(Constants.JSON_UTF8)
public class CfmService {
	
	@Inject
	private CfmController cfmController;

	@GET
    @Path("/vistoria-realizada")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vistoriaRealizada(VistoriaEfetuadaRequest vistoriaEfetuadaRequest) throws AccessTokenInvalidoException, JsonProcessingException {
    	return Response.ok(this.cfmController.listarVistoria(vistoriaEfetuadaRequest)).build(); 
    }
	
	@GET
    @Path("/anexos")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response baixarAnexo() throws AccessTokenInvalidoException, JsonProcessingException {
    	return this.cfmController.baixarAnexo();
    }
	
}
