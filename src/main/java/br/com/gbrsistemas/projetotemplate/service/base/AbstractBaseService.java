package br.com.gbrsistemas.projetotemplate.service.base;

import br.com.gbrsistemas.crvirtual.util.token.UsuarioToken;
import br.com.gbrsistemas.projetotemplate.config.annotations.IdUsuarioAutenticado;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.inject.Inject;

public abstract class AbstractBaseService {

    @IdUsuarioAutenticado
    @Inject
    protected int idUsuarioAutenticado;

    @Inject
    private JsonWebToken jwt;

    @Inject
    protected UsuarioToken usuarioAutenticado;

}
