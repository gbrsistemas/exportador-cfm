package br.com.gbrsistemas.main.controller;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.core.Form;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorDTO;
import br.com.gbrsistemas.main.dto.ItemAnexoDTO;
import br.com.gbrsistemas.main.dto.AnexoDTO;
import br.com.gbrsistemas.main.dto.VistoriaDTO;
import br.com.gbrsistemas.main.dto.ItemVistoriaDTO;
import br.com.gbrsistemas.main.dto.AnexoSeletorDTO;
import br.com.gbrsistemas.main.dto.IrregularidadeSeletorDTO;
import br.com.gbrsistemas.main.dto.LoginDTO;
import br.com.gbrsistemas.main.dto.IrregularidadesSeletorDemandasDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponseDTO;

import br.com.gbrsistemas.main.util.JsonConverter;

@Stateless
public class ApiController {
    
    @Inject
    @ConfigProperty(name = "cfm.login")
    private String apiLogin;
    
    @Inject
    @ConfigProperty(name = "cfm.api")
    private String api;
       
    public String postLogin(LoginDTO loginRequest) throws JsonProcessingException {
    	    	
    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target(this.apiLogin + "/oauth2/token");

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

    public VistoriaEfetuadaResponseDTO listarVistoria(VistoriaEfetuadaSeletorDTO vistoriaEfetuadaSeletorRequest, String token) throws JsonProcessingException {
    	    	
        Client client = null;
        try {
            client = ClientBuilder.newClient();
    
            WebTarget target = client.target(this.api + "/crvirtual-demandas/vistoria/pesquisar-vistorias-efetuadas");
    
            String requestBody = JsonConverter.objectToJson(vistoriaEfetuadaSeletorRequest);
    
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .header("Authorization", "Bearer " + token)
                    .post(Entity.json(requestBody));
                            
            if (response.getStatus() == 200) {
                VistoriaEfetuadaResponseDTO vistoriaResponse = JsonConverter.jsonToObject(response.readEntity(String.class), VistoriaEfetuadaResponseDTO.class);
                
                return vistoriaResponse;
            } else {
                System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
                return null;
            }
        } finally {
            if(client != null)
                client.close();
        }
    }
    
    public Response baixarAnexo(Integer id, String token) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.api + "/crvirtual-demandas/anexo/baixar/" + id);

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

	public List<ItemAnexoDTO> postAnexo(AnexoSeletorDTO anexoSeletorRequest, String token) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(this.api + "/crvirtual-demandas/anexo/dto/");

        String requestBody = JsonConverter.objectToJson(anexoSeletorRequest);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(requestBody));

        if (response.getStatus() == 200) {
            String responseBody = response.readEntity(String.class);
            
            try {
            	AnexoDTO anexoResponse = JsonConverter.jsonToObject(responseBody, AnexoDTO.class);

                List<ItemAnexoDTO> anexos = anexoResponse.getItens();

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
	
	public List<ItemVistoriaDTO> postIrregularidade(IrregularidadeSeletorDTO irregularidadSeletor, String token) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
        IrregularidadesSeletorDemandasDTO irregularidadeSeletorDemandas = new IrregularidadesSeletorDemandasDTO();
        irregularidadeSeletorDemandas.setIdDemanda(irregularidadSeletor.getIdDemanda());
        
        WebTarget target = client.target(this.api + "/crvirtual-demandas/irregularidade/dto");

        String requestBody = JsonConverter.objectToJson(irregularidadeSeletorDemandas);

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.json(requestBody));

        if (response.getStatus() == 200) {
            String responseBody = response.readEntity(String.class);

        	VistoriaDTO itemVistoriaDTO = JsonConverter.jsonToObject(responseBody, VistoriaDTO.class);
            List<ItemVistoriaDTO> anexos = itemVistoriaDTO.getItens();
            
            return anexos;
        } else {
            System.err.println("Erro na solicitação. Código de resposta: " + response.getStatus());
            return null;
        }
	}
}
