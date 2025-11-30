package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Comentario;
import com.levelup.levelupapi.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository repo;

    public ComentarioService(ComentarioRepository repo) {
        this.repo = repo;
    }

    public List<Comentario> obtenerComentariosPorProducto(Long productoId) {
        return repo.findByProductoId(productoId);
    }

    public Comentario agregarComentario(Long productoId, Comentario comentario) {
        comentario.setProductoId(productoId);
        comentario.setFecha(LocalDate.now().toString());
        comentario.setLikes(0);
        return repo.save(comentario);
    }

    public Comentario agregarLike(Long id) {
        Comentario c = repo.findById(id).orElseThrow();
        c.setLikes(c.getLikes() + 1);
        return repo.save(c);
    }

    public Comentario agregarRespuesta(Long id, String texto) {
        Comentario c = repo.findById(id).orElseThrow();
        c.getRespuestas().add(texto);
        return repo.save(c);
    }
}
