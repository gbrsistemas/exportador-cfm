package br.com.gbrsistemas.main.service;

import br.com.gbrsistemas.main.service.base.AbstractBaseService;
import br.com.gbrsistemas.main.util.Constants;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/health")
@Consumes(Constants.JSON_UTF8)
@Produces(Constants.JSON_UTF8)
public class TesteService extends AbstractBaseService {

    @GET
    public Response health() {
        return Response.ok(String.format("Olá, %s!", this.usuarioAutenticado.getNome())).build();
    }

}