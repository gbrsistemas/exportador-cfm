package br.com.gbrsistemas.main.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.gbrsistemas.main.FiltroRequest;

public class ObjectToJson {
	
    public String convertObjectToJson(FiltroRequest filtroRequest) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
            return objectWriter.writeValueAsString(filtroRequest);
        } catch (IOException e) {
            System.err.println("Erro ao converter objeto para JSON: " + e.getMessage());
            return null;
        }
    }

}
