package br.com.gbrsistemas.main.service.cfm;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.gbrsistemas.main.service.base.AbstractBaseService;
import br.com.gbrsistemas.main.util.Constants;

@Path("/cfm")
@Consumes(Constants.JSON_UTF8)
@Produces(Constants.JSON_UTF8)
public class CfmService extends AbstractBaseService {

    @GET
    @Path("/login")
    public Response loginCfm() {
        return Response.ok(String.format("Olá, %s!", this.usuarioAutenticado.getNome())).build();
    }
    
}
