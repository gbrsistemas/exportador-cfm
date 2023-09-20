package br.com.gbrsistemas.main.service.cfm;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.controller.CfmController;
import br.com.gbrsistemas.main.dto.IntegradorGedDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaDTO;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;
import br.com.gbrsistemas.main.util.Constants;

@Path("/importar")
@Consumes(Constants.JSON_UTF8)
@Produces(Constants.JSON_UTF8)
public class CfmService {
	
	@Inject
	private CfmController cfmController;

	@POST
    @Path("/vistoria-realizada")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response vistoriaRealizada(VistoriaEfetuadaDTO vistoriaEfetuadaRequest) throws AccessTokenInvalidoException, JsonProcessingException {
    	return Response.ok(this.cfmController.listarVistoria(vistoriaEfetuadaRequest)).build(); 
    }
	
	@POST
	@Path("/integrar-ged/{idDemanda}")
	public Response integrarGed(
			@PathParam("idDemanda") Integer idDemanda, 
			IntegradorGedDTO integradorGedDTO
			) throws Exception {		
		
		this.cfmController.integrarIrregularidades(idDemanda);
	    this.cfmController.integrarAnexos(idDemanda,integradorGedDTO);
	    
	    return Response.ok().build();
	}
	
}
