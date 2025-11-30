package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.PostComunidad;
import com.levelup.levelupapi.model.ComentarioComunidad;
import com.levelup.levelupapi.repository.PostComunidadRepository;
import com.levelup.levelupapi.repository.ComentarioComunidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunidadService {

    private final PostComunidadRepository postRepo;
    private final ComentarioComunidadRepository comentarioRepo;

    public ComunidadService(PostComunidadRepository postRepo, ComentarioComunidadRepository comentarioRepo) {
        this.postRepo = postRepo;
        this.comentarioRepo = comentarioRepo;
    }

    // POSTS
    public PostComunidad crearPost(PostComunidad post) {
        return postRepo.save(post);
    }

    public List<PostComunidad> listarPosts() {
        return postRepo.findAll();
    }

    public PostComunidad likePost(Long id) {
        PostComunidad p = postRepo.findById(id).orElseThrow();
        p.setLikes(p.getLikes() + 1);
        return postRepo.save(p);
    }

    // COMENTARIOS
    public List<ComentarioComunidad> obtenerComentarios(Long postId) {
        return comentarioRepo.findByPostId(postId);
    }

    public ComentarioComunidad agregarComentario(Long postId, ComentarioComunidad c) {
        c.setPostId(postId);
        return comentarioRepo.save(c);
    }

    public ComentarioComunidad likeComentario(Long id) {
        ComentarioComunidad c = comentarioRepo.findById(id).orElseThrow();
        c.setLikes(c.getLikes() + 1);
        return comentarioRepo.save(c);
    }

    public ComentarioComunidad responderComentario(Long id, String texto) {
        ComentarioComunidad c = comentarioRepo.findById(id).orElseThrow();
        c.getRespuestas().add(texto);
        return comentarioRepo.save(c);
    }
}
