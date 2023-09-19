package client;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.gbrsistemas.main.dto.AnexoGedDTO;
import br.com.gbrsistemas.main.util.Constants;

@RegisterClientHeaders
@Dependent
@RegisterRestClient
@Path("/processo-fiscalizacao")
public interface ProcessoFiscalizacaoServiceClient {

    @Path("/upload")
    @POST
    @Produces(Constants.JSON_UTF8)
    @Consumes(Constants.JSON_UTF8)
    Response inserirDocumento(AnexoGedDTO anexoGedDTO);

}
