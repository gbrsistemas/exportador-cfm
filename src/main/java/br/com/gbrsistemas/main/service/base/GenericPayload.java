package br.com.gbrsistemas.main.service.base;

import javax.ws.rs.BadRequestException;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class GenericPayload extends HashMap<String, Object> {

    public <T> T get(String key) {
        Object obj = super.get(key);
        if (obj == null) {
            throw new BadRequestException(String.format("Parâmetro '%s' não especificado.", key));
        }
        return (T) obj;
    }

    public <T> T getNullable(String key) {
        return (T) super.get(key);
    }
}
