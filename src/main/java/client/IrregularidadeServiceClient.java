package client;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.gbrsistemas.main.dto.IrregularidadesGedDTO;
import br.com.gbrsistemas.main.util.Constants;

@RegisterClientHeaders
@Dependent
@RegisterRestClient
@Path("/irregularidade")
public interface IrregularidadeServiceClient {

    @Path("/integracao-ged")
    @POST
    @Produces(Constants.JSON_UTF8)
    @Consumes(Constants.JSON_UTF8)
    Response integracaoGed(List<IrregularidadesGedDTO> lista);

}
