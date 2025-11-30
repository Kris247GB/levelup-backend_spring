package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.ComentarioComunidad;
import com.levelup.levelupapi.repository.ComentarioComunidadRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComentarioComunidadService {

    private final ComentarioComunidadRepository repo;

    public ComentarioComunidadService(ComentarioComunidadRepository repo) {
        this.repo = repo;
    }

    // Obtener comentarios de un post
    public List<ComentarioComunidad> obtenerPorPost(Long postId) {
        return repo.findByPostId(postId);
    }

    // Crear comentario ligado a un post
    public ComentarioComunidad crearComentario(Long postId, ComentarioComunidad comentario) {
        comentario.setPostId(postId);
        comentario.setFecha(LocalDateTime.now());
        comentario.setLikes(0);
        return repo.save(comentario);
    }

    // Dar like
    public ComentarioComunidad like(Long comentarioId) {
        ComentarioComunidad c = repo.findById(comentarioId)
                .orElseThrow(() -> new RuntimeException("Comentario no existe"));

        c.setLikes(c.getLikes() + 1);
        return repo.save(c);
    }

    // Agregar respuesta
    public ComentarioComunidad responder(Long comentarioId, String respuesta) {
        ComentarioComunidad c = repo.findById(comentarioId)
                .orElseThrow(() -> new RuntimeException("Comentario no existe"));

        c.getRespuestas().add(respuesta);
        return repo.save(c);
    }
}
