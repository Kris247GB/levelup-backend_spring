package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.Usuario;
import com.levelup.levelupapi.repository.UsuarioRepository;
import com.levelup.levelupapi.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final JwtService jwtService;
    private final UsuarioRepository repo;

    public UsuarioController(JwtService jwtService, UsuarioRepository repo) {
        this.jwtService = jwtService;
        this.repo = repo;
    }

    @GetMapping("/perfil")
    public ResponseEntity<?> obtenerPerfil(@RequestHeader("Authorization") String header) {

        if (header == null || !header.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body(
                    java.util.Map.of("error", "Token no enviado")
            );
        }

        String token = header.substring(7);

        String email;
        try {
            email = jwtService.obtenerEmailDesdeToken(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(
                    java.util.Map.of("error", "Token inválido o expirado")
            );
        }

        Usuario usuario = repo.findByEmail(email).orElse(null);

        if (usuario == null) {
            return ResponseEntity.status(404).body(
                    java.util.Map.of("error", "Usuario no encontrado")
            );
        }

        // ⚠️ IMPORTANTE:
        // Map.of() soporta máximo 10 pares clave-valor
        // Por eso pasamos a Map<String,Object>

        java.util.Map<String, Object> datos = new java.util.HashMap<>();
        datos.put("id", usuario.getId());
        datos.put("nombre", usuario.getNombre());
        datos.put("email", usuario.getEmail());
        datos.put("rol", usuario.getRol());
        datos.put("mayor18", usuario.getMayor18());
        datos.put("codigoReferido", usuario.getCodigoReferido());
        datos.put("codigoReferente", usuario.getCodigoReferente());
        datos.put("levelUpPoints", usuario.getLevelUpPoints());
        datos.put("descuentoDuoc", usuario.getDescuentoDuoc());
        datos.put("preferencias", usuario.getPreferencias());
        datos.put("fechaRegistro", usuario.getFechaRegistro());

        return ResponseEntity.ok(datos);
    }
}
