package com.levelup.levelupapi.security;

import com.levelup.levelupapi.model.Usuario;
import com.levelup.levelupapi.repository.UsuarioRepository;
import com.levelup.levelupapi.security.dto.LoginRequest;
import com.levelup.levelupapi.security.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

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

    // =====================================================
    // ============= REGISTRO ==============================
    // =====================================================
    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody RegisterRequest req) {

        if (repo.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "El email ya está registrado"));
        }

        if (req.getMayor18() == null || !req.getMayor18()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Debes confirmar que eres mayor de 18 años"));
        }

        Usuario u = new Usuario();
        u.setNombre(req.getNombre());
        u.setEmail(req.getEmail());
        u.setMayor18(req.getMayor18());
        u.setPreferencias(req.getPreferencias());
        u.setCodigoReferente(req.getCodigoReferente());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setFechaRegistro(LocalDateTime.now());
        u.setCodigoReferido(generarCodigo());

        if (req.getEmail().toLowerCase().contains("duoc")) {
            u.setDescuentoDuoc(20);
        }

        if (req.getCodigoReferente() != null && !req.getCodigoReferente().isBlank()) {
            var referidor = repo.findByCodigoReferido(req.getCodigoReferente().toUpperCase());
            if (referidor.isPresent()) {
                u.setLevelUpPoints(50);
                var ref = referidor.get();
                ref.setLevelUpPoints(ref.getLevelUpPoints() + 100);
                repo.save(ref);
            }
        }

        repo.save(u);

        return ResponseEntity.ok(Map.of(
                "mensaje", "Usuario registrado correctamente",
                "codigoReferido", u.getCodigoReferido()
        ));
    }

    private String generarCodigo() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) sb.append(chars.charAt(r.nextInt(chars.length())));
        return sb.toString();
    }

    // =====================================================
    // ============= LOGIN =================================
    // =====================================================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        Usuario usuario = repo.findByEmail(req.getEmail()).orElse(null);

        if (usuario == null) {
            return ResponseEntity.status(401).body(Map.of("error", "Usuario no encontrado"));
        }

        if (!encoder.matches(req.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
        }

        String token = jwt.generarToken(req.getEmail());

        return ResponseEntity.ok(
                Map.of(
                        "token", token,
                        "email", usuario.getEmail(),
                        "nombre", usuario.getNombre(),
                        "rol", usuario.getRol()
                )
        );
    }
}
