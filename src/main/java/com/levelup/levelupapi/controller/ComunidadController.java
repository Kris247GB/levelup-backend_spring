package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.PostComunidad;
import com.levelup.levelupapi.model.ComentarioComunidad;
import com.levelup.levelupapi.service.ComunidadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunidad")
public class ComunidadController {

    private final ComunidadService service;

    public ComunidadController(ComunidadService service) {
        this.service = service;
    }

    // POSTS
    @GetMapping("/posts")
    public List<PostComunidad> listarPosts() {
        return service.listarPosts();
    }

    @PostMapping("/posts")
    public PostComunidad crearPost(@RequestBody PostComunidad post) {
        return service.crearPost(post);
    }

    @PostMapping("/posts/{id}/like")
    public PostComunidad likePost(@PathVariable Long id) {
        return service.likePost(id);
    }

    // COMENTARIOS
    @GetMapping("/posts/{postId}/comentarios")
    public List<ComentarioComunidad> obtenerComentarios(@PathVariable Long postId) {
        return service.obtenerComentarios(postId);
    }

    @PostMapping("/posts/{postId}/comentarios")
    public ComentarioComunidad agregarComentario(
            @PathVariable Long postId,
            @RequestBody ComentarioComunidad comentario
    ) {
        return service.agregarComentario(postId, comentario);
    }

    @PostMapping("/comentarios/{id}/like")
    public ComentarioComunidad likeComentario(@PathVariable Long id) {
        return service.likeComentario(id);
    }

    @PostMapping("/comentarios/{id}/respuesta")
    public ComentarioComunidad responderComentario(
            @PathVariable Long id,
            @RequestBody String respuesta
    ) {
        return service.responderComentario(id, respuesta);
    }
}
