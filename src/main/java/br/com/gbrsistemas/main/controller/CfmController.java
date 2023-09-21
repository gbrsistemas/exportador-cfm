package br.com.gbrsistemas.main.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;

import java.nio.charset.StandardCharsets;

import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.core.Response;


import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.google.common.base.Strings;

import br.com.gbrsistemas.main.dto.AnexoSeletorDTO;
import br.com.gbrsistemas.main.dto.IntegradorGedDTO;
import br.com.gbrsistemas.main.dto.IrregularidadesGedDTO;
import br.com.gbrsistemas.main.dto.ItemAnexoDTO;
import br.com.gbrsistemas.main.dto.ItemIrregularidadeDTO;
import br.com.gbrsistemas.main.dto.LoginDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaResponseDTO;
import br.com.gbrsistemas.main.dto.VistoriaEfetuadaSeletorDTO;
import br.com.gbrsistemas.main.dto.VistoriaResponseDTO;
import br.com.gbrsistemas.main.dto.AnexoGedDTO;
import br.com.gbrsistemas.main.util.AccessTokenInvalidoException;

import client.IrregularidadeServiceClient;
import client.ProcessoFiscalizacaoServiceClient;

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
	
    @Inject
    @RestClient
    private ProcessoFiscalizacaoServiceClient processoFiscalizacaoServiceClient;
    
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
	
	public Response integrarAnexos(Integer idDemanda, IntegradorGedDTO integradorGedDTO) throws AccessTokenInvalidoException, IOException {
		this.login();
		
		if (idDemanda != null && integradorGedDTO.getDataVistoria() != null ) {
			AnexoSeletorDTO anexoSeletorRequest = new AnexoSeletorDTO();
			anexoSeletorRequest.setIdDemanda(idDemanda);
			
			List<ItemAnexoDTO> anexoResponse = this.apiController.postAnexo(anexoSeletorRequest, this.accesToken);
			
			if (anexoResponse != null && !anexoResponse.isEmpty()) {
			    List<String> nomesAceitos = Arrays.asList(ItemAnexoDTO.NOME_RELATORIO_VISTORIA, ItemAnexoDTO.NOME_RELATORIO_VISTORIA_CONSOLIDADO, ItemAnexoDTO.NOME_TERMO_NOTIFICACAO, ItemAnexoDTO.NOME_TERMO_VISTORIA);
			    List<Integer> idsTiposAceitos = Arrays.asList(ItemAnexoDTO.ID_RELATORIO_VISTORIA, ItemAnexoDTO.ID_RELATORIO_VISTORIA_CONSOLIDADO, ItemAnexoDTO.ID_TERMO_NOTIFICACAO, ItemAnexoDTO.ID_TERMO_VISTORIA);		    
			    			    
			    anexoResponse = aplicarFiltrosAnexo(anexoResponse, integradorGedDTO.getDataVistoria(), nomesAceitos, idsTiposAceitos);

			    for(ItemAnexoDTO dto: anexoResponse) {			      
			        Response response = this.apiController.baixarAnexo(dto.getId(), this.accesToken);
			        
			        if(response.getStatus() == 200) {
			            InputStream arquivo = response.readEntity(InputStream.class);
			            String nomeArquivo = dto.getDescricao() != null ? dto.getDescricao() : dto.getTipoDocumento();
			            byte[] bytes = IOUtils.toByteArray(arquivo);

			            AnexoGedDTO anexoGedDTO = new AnexoGedDTO();
			            anexoGedDTO.setAnoDemanda(integradorGedDTO.getAnoDemanda());
			            anexoGedDTO.setArquivo(bytes);
			            anexoGedDTO.setCodigoDocumento(dto.getNome());
			            anexoGedDTO.setIdTipoDocumento(idDemanda);
			            anexoGedDTO.setNome(nomeArquivo);
			            anexoGedDTO.setNumeroDemanda(integradorGedDTO.getNumeroDemanda());
			            anexoGedDTO.setIdProcesso(integradorGedDTO.getIdProcesso());
			            
					    this.processoFiscalizacaoServiceClient.inserirDocumento(anexoGedDTO);
			        }
			    }
			}
		}
		
		return null;
	}
	
    public static List<ItemAnexoDTO> aplicarFiltrosAnexo(List<ItemAnexoDTO> anexos, Date dataVistoriaLocalDateTime, List<String> nomesAceitos, List<Integer> idsTiposAceitos) {
    	anexos = anexos.stream().filter(a -> (a.getNome() != null && nomesAceitos.contains(a.getNome())) || (a.getIdTipoDocumento() != null && idsTiposAceitos.contains(a.getIdTipoDocumento()))).collect(Collectors.toList());

        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    	anexos = anexos.stream().filter(a -> {
			try {
				return a.getData() != null && (formatoData.parse(a.getData()).after(dataVistoriaLocalDateTime)) || formatoData.parse(a.getData()) == dataVistoriaLocalDateTime;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return false;
		}).collect(Collectors.toList());
    	
    	
        Map<String, List<ItemAnexoDTO>> anexosAgrupados = anexos.stream()
            .collect(Collectors.groupingBy(ItemAnexoDTO::getNome));

        List<ItemAnexoDTO> anexosFiltrados = new ArrayList<>();

        for (Map.Entry<String, List<ItemAnexoDTO>> entry : anexosAgrupados.entrySet()) {
            List<ItemAnexoDTO> anexosDoMesmoNome = entry.getValue();

            anexosDoMesmoNome.sort(Comparator.comparing(ItemAnexoDTO::getData).reversed());

            anexosFiltrados.add(anexosDoMesmoNome.get(0));
        }

        return anexosFiltrados;
    }

	public Attachment getAsAttachment(String nomeArquivo, InputStream is) throws UnsupportedEncodingException {
        if (Strings.isNullOrEmpty(FilenameUtils.getExtension(nomeArquivo))) {
            nomeArquivo += ".pdf";
        }

        ContentDisposition cd = new ContentDisposition("attachment;filename*=UTF-8''" + URLEncoder.encode(nomeArquivo, StandardCharsets.UTF_8.name()));
        return new Attachment(nomeArquivo, is, cd);
    }
	
	public List<ItemIrregularidadeDTO> integrarIrregularidades(Integer idDemanda, Integer idProcesso) throws AccessTokenInvalidoException, JsonProcessingException {
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
			        irregularidadeGedDTO.setIdProcesso(idProcesso);
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
