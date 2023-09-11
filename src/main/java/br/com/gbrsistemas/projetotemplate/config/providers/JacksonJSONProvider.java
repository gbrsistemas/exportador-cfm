package br.com.gbrsistemas.projetotemplate.config.providers;

import br.com.gbrsistemas.projetotemplate.util.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.google.common.primitives.Longs;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Provider
@Consumes(Constants.JSON_UTF8)
@Produces(Constants.JSON_UTF8)
public class JacksonJSONProvider extends com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider {

    static final DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    public JacksonJSONProvider() {
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
        hibernate5Module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Date.class, new JsonDateDeserializer());

        _mapperConfig.getDefaultMapper()
                .setDateFormat(dateTimeFormat)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .registerModule(module)
                .registerModule(hibernate5Module);
    }
}

// Deserializer customizado pra parsear datas com e sem timezone.
class JsonDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        String dateText = parser.getText();

        Long timestamp = Longs.tryParse(dateText);
        if (timestamp != null) {
            return new Date(timestamp);
        }

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
            return df.parse(dateText);
        } catch (ParseException e) {
            try {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                return df.parse(dateText);
            } catch (ParseException e1) {
                throw new JsonParseException(parser, String.format("Unparseable date: '%s'", dateText), e1);
            }
        }
    }
}