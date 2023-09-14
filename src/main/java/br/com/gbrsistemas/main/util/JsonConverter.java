package br.com.gbrsistemas.main.util;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
	
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }
    
    public static <T> List<T> jsonToList(String json, Class<T> clazz) throws JsonProcessingException {
        TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {};
        return objectMapper.readValue(json, typeReference);
    }

}
