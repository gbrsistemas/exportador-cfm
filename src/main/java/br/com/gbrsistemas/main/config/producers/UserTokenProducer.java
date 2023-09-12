package br.com.gbrsistemas.main.config.producers;

import br.com.gbrsistemas.crvirtual.util.token.TokenParser;
import br.com.gbrsistemas.crvirtual.util.token.UsuarioToken;
import br.com.gbrsistemas.main.config.annotations.IdUsuarioAutenticado;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.inject.Produces;

public class UserTokenProducer {

    @Produces
    public UsuarioToken getUser(JsonWebToken token) throws Exception {
        return TokenParser.getUsuarioLogin(token);
    }

    @IdUsuarioAutenticado
    @Produces
    public Long getIdUsUarioAutenticado(UsuarioToken user){
        return user.getId();
    }

    @IdUsuarioAutenticado
    @Produces
    public int getIdUsUarioAutenticadoInt(UsuarioToken user){
        return user.getId().intValue();
    }

}
