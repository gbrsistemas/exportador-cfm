package br.com.gbrsistemas.main.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

public class JwtUtil {

    public void verificaAccessToken(String accessToken) throws AccessTokenInvalidoException {
        try {
    		if (accessToken == null) {
                throw new AccessTokenInvalidoException("Access token não pode ser nulo");
    		}
    		
            JwtParser parser = Jwts.parserBuilder().build();

            Claims claims = parser
                    .parseClaimsJwt(accessToken)
                    .getBody();

            if (claims.getExpiration() != null) {
                long agoraEmMillis = System.currentTimeMillis();
                if (claims.getExpiration().getTime() < agoraEmMillis) {
                    throw new AccessTokenInvalidoException("Access token expirado");
                }
            }

        } catch (ExpiredJwtException e) {
            throw new AccessTokenInvalidoException("Access token expirado");
        } catch (MalformedJwtException e) {
            throw new AccessTokenInvalidoException("Access token inválido");
        } catch (Exception e) {
            throw new AccessTokenInvalidoException("Erro ao verificar o access token");
        }
    }
	
}
