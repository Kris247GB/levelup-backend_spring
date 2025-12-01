package com.levelup.levelupapi.security;

import com.levelup.levelupapi.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthController(UsuarioRepository repo, PasswordEncoder encoder, JwtService jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public Map<String, String> registrar(@RequestBody Usuario u) {
        u.setPassword(encoder.encode(u.getPassword()));
        repo.save(u);

        return Map.of("mensaje", "Usuario registrado correctamente");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        var email = body.get("email");
        var password = body.get("password");

        Usuario usuario = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!encoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        return Map.of("token", jwt.generarToken(email));
    }
}
