package br.com.gbrsistemas.main.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.gbrsistemas.main.FiltroRequest;
import br.com.gbrsistemas.main.util.ObjectToJson;

public class ApiController {

    private String apiUrl;
    private String token;

    public ApiController(String apiUrl, String token) {
        this.apiUrl = apiUrl;
        this.token = token;
    }

    public String post(FiltroRequest filtroRequest) {
    	ObjectToJson objectToJson =  new ObjectToJson();
    	
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(apiUrl);

        String requestBody = objectToJson.convertObjectToJson(filtroRequest);

        Response response = null;
        
        if (token != null) {
            response = target
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + token)
                    .post(Entity.json(requestBody));
        } else {
            response = target
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(requestBody));
        }

        client.close();
        
        if (response.getStatus() == 200) {
            return response.readEntity(String.class);
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
    }
}
