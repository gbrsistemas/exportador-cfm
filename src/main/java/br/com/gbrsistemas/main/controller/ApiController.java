package br.com.gbrsistemas.main.controller;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Form;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorRequest;
import br.com.gbrsistemas.main.dto.ItemAnexo;
import br.com.gbrsistemas.main.dto.AnexoResponse;
import br.com.gbrsistemas.main.dto.AnexoSeletorRequest;
import br.com.gbrsistemas.main.dto.DemandasRequest;
import br.com.gbrsistemas.main.dto.DemandaResponse;
import br.com.gbrsistemas.main.dto.LoginRequest;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponse;
import br.com.gbrsistemas.main.util.JsonConverter;

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

    	Form form = new Form();
    	form.param("username", loginRequest.getLogin());
    	form.param("password", loginRequest.getSenha());
    	form.param("grant_type", "password");

    	Response response = target
    	    .request(MediaType.APPLICATION_JSON)
    	    .post(Entity.form(form));

    	client.close();
        
        if (response.getStatus() == 200) {
        	String jsonResponse = response.readEntity(String.class);

        	ObjectMapper objectMapper = new ObjectMapper();
        	JsonNode jsonNode = objectMapper.readTree(jsonResponse);
        	String accessToken = jsonNode.get("access_token").asText();
        	
        	return accessToken;
        	} 
        else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
    }

    public VistoriaEfetuadaResponse listarVistoria(VistoriaEfetuadaSeletorRequest vistoriaEfetuadaSeletorRequest) throws JsonProcessingException {
    	    	
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
    
    public Response baixarAnexo(Integer id) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.API + "/crvirtual-demandas/anexo/baixar/" + id);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .get();

        client.close();
        
        if (response.getStatus() == 200) {
            return response;
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
    }

	public List<ItemAnexo> postAnexo(AnexoSeletorRequest anexoSeletorRequest) throws JsonProcessingException {
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
            	AnexoResponse anexoResponse = JsonConverter.jsonToObject(responseBody, AnexoResponse.class);

                List<ItemAnexo> anexos = anexoResponse.getItens();

                return anexos;
            } catch (JsonProcessingException e) {
                System.err.println("Erro ao processar o JSON de resposta: " + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
	}
	
	public List<DemandaResponse> postDemanda(DemandasRequest demandasRequest) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.API + "/crvirtual-demandas/demanda/dto");

        String requestBody = JsonConverter.objectToJson(demandasRequest);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(requestBody));

        if (response.getStatus() == 200) {
            String responseBody = response.readEntity(String.class);
            
            try {
                List<DemandaResponse> demandas = JsonConverter.jsonToList(responseBody, DemandaResponse.class);
                return demandas;
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
