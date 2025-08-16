package com.alura.challenge.foro.infrastructure.security.token;

import com.alura.challenge.foro.domain.model.usuario.Usuario;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import com.auth0.jwt.JWT;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    public String crearToken(Usuario usuario){
        try {
            Algorithm algorithm=Algorithm.HMAC256("hola");
            return JWT.create()
                    .withIssuer("foro_hud")
                    .withSubject(usuario.getNombre())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algorithm);
        }catch ( JWTCreationException e){
            return new RuntimeException("Errorr al generar el token",e).toString();
        }
    }
    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));

    }


    public String getSubject(String token){
        try {
            var algoritmo = Algorithm.HMAC256("hola");

            return JWT.require(algoritmo)
                    .withIssuer("foro_hud")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT invalido o expirado!");
        }
    }
}
