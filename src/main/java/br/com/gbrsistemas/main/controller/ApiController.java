package br.com.gbrsistemas.main.controller;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorRequest;
import br.com.gbrsistemas.main.dto.AnexoResponse;
import br.com.gbrsistemas.main.dto.AnexoSeletorRequest;
import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponse;
import br.com.gbrsistemas.main.util.JsonConverter;

import com.fasterxml.jackson.core.type.TypeReference;

public class ApiController {

    private String token;
	private String API;

    public ApiController(String token) {
		this.API = "https://cfm.crvirtual.online";
        this.token = token;
    }
    
    public String postLogin(LoginRequest loginRequest) throws JsonProcessingException {
    	    	
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.API + "/oauth2/token");

        String requestBody = JsonConverter.objectToJson(loginRequest);

        Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(requestBody));

        client.close();
        
        if (response.getStatus() == 200) {
            return response.readEntity(String.class);
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
    }

    public VistoriaEfetuadaResponse postVistorias(VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest) throws JsonProcessingException {
    	    	
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.API + "/crvirtual-demandas/vistoria/pesquisar-vistorias-efetuadas/");

        String requestBody = JsonConverter.objectToJson(vistoriaEfetuadaSeletorRequest);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(requestBody));

        client.close();
        
        if (response.getStatus() == 200) {
            VistoriaEfetuadaResponse vistoriaResponse = JsonConverter.jsonToObject(response.readEntity(String.class), VistoriaEfetuadaResponse.class);
            
            return vistoriaResponse;
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
    }
    
    public String getAnexo(Integer id) {
    	
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.API + "/crvirtual-demandas/anexo/exportar/" + id);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(null);

        client.close();
        
        if (response.getStatus() == 200) {
            return response.readEntity(String.class);
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
    }

	public List<AnexoResponse> postAnexo(AnexoSeletorRequest anexoSeletorRequest) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.API + "/crvirtual-demandas/anexo/dto/");

        String requestBody = JsonConverter.objectToJson(anexoSeletorRequest);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(requestBody));

        if (response.getStatus() == 200) {
            String responseBody = response.readEntity(String.class);
            
            try {
                List<AnexoResponse> vistorias = JsonConverter.jsonToList(responseBody, AnexoResponse.class);
                return vistorias;
            } catch (JsonProcessingException e) {
                System.err.println("Erro ao processar o JSON de resposta: " + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
	}
}
