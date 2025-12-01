package com.levelup.levelupapi.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final Key clave = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generarToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .signWith(clave)
                .compact();
    }

    public String obtenerEmailDesdeToken(String token) {
        return Jwts.parser()
                .setSigningKey(clave)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
