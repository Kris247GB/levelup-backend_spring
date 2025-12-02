package com.levelup.levelupapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    public String generarToken(String email, String rol) {
        return Jwts.builder()
                .subject(email)
                .claim("rol", rol)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 3600_000)) // 1 hora
                .signWith(key)
                .compact();
    }

    private Claims extraerClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)   // ← ESTO EXISTE EN 0.12.5
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String obtenerEmailDesdeToken(String token) {
        return extraerClaims(token).getSubject();
    }

    public String obtenerRolDesdeToken(String token) {
        return extraerClaims(token).get("rol", String.class);
    }
}
