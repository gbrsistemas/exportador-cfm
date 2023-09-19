package br.com.gbrsistemas.main.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.gbrsistemas.main.dto.AnexoSeletorDTO;
import br.com.gbrsistemas.main.dto.IrregularidadesGedDTO;
import br.com.gbrsistemas.main.dto.ItemAnexoDTO;
import br.com.gbrsistemas.main.dto.ItemIrregularidadeDTO;
import br.com.gbrsistemas.main.dto.LoginDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponseDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorDTO;
import br.com.gbrsistemas.main.dto.VistoriaResponseDTO;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;
import client.IrregularidadeServiceClient;

@Stateless
public class CfmController {
    
    private String accesToken;
	
	@Inject
	private ApiController apiController;
	    
    @Inject
    @ConfigProperty(name = "cfm.username")
    private String username;
    
    @Inject
    @ConfigProperty(name = "cfm.password")
    private String password;
    
    @Inject
    @RestClient
    private IrregularidadeServiceClient irregularidadeServiceClient;
	
	public VistoriaResponseDTO listarVistoria(VistoriaEfetuadaDTO vistoriaEfetuadaRequest) throws JsonProcessingException, AccessTokenInvalidoException {
		this.login();
		
		VistoriaEfetuadaSeletorDTO vistoriaEfetuadaSeletorRequest = new VistoriaEfetuadaSeletorDTO();
		vistoriaEfetuadaSeletorRequest.setNumeroDemanda(vistoriaEfetuadaRequest.getNumeroDemanda());
		vistoriaEfetuadaSeletorRequest.setAnoDemanda(vistoriaEfetuadaRequest.getAnoDemanda());
		vistoriaEfetuadaSeletorRequest.setUfDemanda(vistoriaEfetuadaRequest.getUfDemanda());
		vistoriaEfetuadaSeletorRequest.setDataInicialTransmissao(vistoriaEfetuadaRequest.getDataInicialTransmissao());
		vistoriaEfetuadaSeletorRequest.setDataFinalTransmissao(vistoriaEfetuadaRequest.getDataFinalTransmissao());

		VistoriaEfetuadaResponseDTO vistoriaEfetuadaResponse =  this.apiController.listarVistoria(vistoriaEfetuadaSeletorRequest, this.accesToken);

		if(vistoriaEfetuadaResponse != null && vistoriaEfetuadaResponse.getItens() != null && 
		        !vistoriaEfetuadaResponse.getItens().isEmpty() && vistoriaEfetuadaResponse.getItens().get(0) != null) {	
			
			return vistoriaEfetuadaResponse.getItens().get(0);
			
		}	
		return null;
	}
	
	public Response integrarAnexos(Integer idDemanda, Date dataVistoria) throws AccessTokenInvalidoException, JsonProcessingException {
		this.login();
		
		LocalDateTime dataAnexo = null;
		
		if (idDemanda != null && dataVistoria != null ) {
			AnexoSeletorDTO anexoSeletorRequest = new AnexoSeletorDTO();
			anexoSeletorRequest.setIdDemanda(idDemanda);
			
			List<ItemAnexoDTO> anexoResponse = this.apiController.postAnexo(anexoSeletorRequest, this.accesToken);
			
			//Filtra a lista de anexos, removendo os que estão com data que não vão ser utilizadas.
			if (anexoResponse != null) {
			    for (ItemAnexoDTO anexo : anexoResponse) {
					dataAnexo = LocalDateTime.parse(anexo.getData());
					LocalDateTime dataVistoriaLocalDateTime = dataVistoria.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	                
	                if(dataAnexo.isBefore(dataVistoriaLocalDateTime)) {
	                    anexoResponse.remove(anexo);
	                }
			    }
			}
			
			//TODO Chamar api do GED para cada anexo da lista.
		}
		
		return null;
	}
	
	public List<ItemIrregularidadeDTO> integrarIrregularidades(Integer idDemanda) throws AccessTokenInvalidoException, JsonProcessingException {
		this.login();
		
		if(idDemanda != null) {
		    List<ItemIrregularidadeDTO> lista =  this.apiController.postIrregularidade(idDemanda, accesToken);			
		    List<IrregularidadesGedDTO> listaIntegracao = new ArrayList<>();
		    
		    if(!lista.isEmpty() && lista.get(0) != null) {
			    for (ItemIrregularidadeDTO item : lista) {
			        IrregularidadesGedDTO irregularidadeGedDTO = new IrregularidadesGedDTO();
			        irregularidadeGedDTO.setAnoDemanda(item.getAnoDemanda());
			        irregularidadeGedDTO.setDescricao(item.getDescricao());
			        irregularidadeGedDTO.setGrupo(item.getGrupo());
			        irregularidadeGedDTO.setId(item.getId());
			        irregularidadeGedDTO.setIdSituacaoIrregularidade(item.getIdSituacaoIrregularidade());
			        irregularidadeGedDTO.setNome(item.getNome());
			        irregularidadeGedDTO.setNumeroDemanda(item.getNumeroDemanda());
			        irregularidadeGedDTO.setSituacaoIrregularidade(item.getSituacaoIrregularidade());
			        irregularidadeGedDTO.setUfDemanda(item.getUfDemanda());

			        listaIntegracao.add(irregularidadeGedDTO);
			    }
			    
			    this.irregularidadeServiceClient.integracaoGed(listaIntegracao);
		    }
		    
		    return lista;
		}
		
		return null;
	}

	public void login() throws JsonProcessingException {	    
		LoginDTO loginRequest = new LoginDTO(this.username, this.password);
		
		this.accesToken = this.apiController.postLogin(loginRequest);
	}

}
