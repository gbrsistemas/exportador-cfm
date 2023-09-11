package br.com.gbrsistemas.projetotemplate.config.annotations;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD,FIELD})
@Retention(RUNTIME)
@Qualifier
public @interface IdUsuarioAutenticado {
}
