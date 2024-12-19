package br.com.guntz.transito.api.domain.service;

import br.com.guntz.transito.api.domain.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secretToken;

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secretToken);

            return JWT.create()
                    .withIssuer("API - Autuação de Trânsito")
                    .withSubject(usuario.getUsuario())
                    .withClaim("id", usuario.getId())
                    .withClaim("role", "xpto")
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("erro ao gerar token JWT. ", ex);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritimo = Algorithm.HMAC256(secretToken);

            return JWT.require(algoritimo)
                    .withIssuer("API - Autuação de Trânsito")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            throw new RuntimeException("Token JWT inválido ou expirado. ", ex);
        }
    }

    private Instant dataExpiracao() {
        return OffsetDateTime.now()
                .plusHours(1)
                .toInstant();
    }
}
