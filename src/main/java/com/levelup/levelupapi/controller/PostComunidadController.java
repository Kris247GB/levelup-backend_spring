package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.PostComunidad;
import com.levelup.levelupapi.model.ComentarioComunidad;
import com.levelup.levelupapi.service.PostComunidadService;
import com.levelup.levelupapi.service.ComentarioComunidadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunidad")
@Tag(name = "Comunidad", description = "API para publicaciones y comentarios de la comunidad gamer")
public class PostComunidadController {

    private final PostComunidadService postService;
    private final ComentarioComunidadService comentarioService;

    public PostComunidadController(PostComunidadService postService,
                                   ComentarioComunidadService comentarioService) {
        this.postService = postService;
        this.comentarioService = comentarioService;
    }


    @GetMapping("/posts")
    @Operation(summary = "Listar todos los posts de la comunidad")
    public List<PostComunidad> listarPosts() {
        return postService.listar();
    }

    @PostMapping("/posts")
    @Operation(summary = "Crear una nueva publicación")
    public PostComunidad crearPost(@RequestBody PostComunidad post) {
        return postService.crear(post);
    }

    @DeleteMapping("/posts/{id}")
    @Operation(summary = "Eliminar un post por ID")
    public void eliminarPost(@PathVariable Long id) {
        postService.eliminar(id);
    }


    @GetMapping("/posts/{postId}/comentarios")
    @Operation(summary = "Obtener comentarios de un post")
    public List<ComentarioComunidad> obtenerComentarios(@PathVariable Long postId) {
        return comentarioService.obtenerPorPost(postId);
    }

    @PostMapping("/posts/{postId}/comentarios")
    @Operation(summary = "Agregar comentario a un post")
    public ComentarioComunidad comentar(@PathVariable Long postId,
                                        @RequestBody ComentarioComunidad comentario) {
        return comentarioService.crearComentario(postId, comentario);
    }


    @PostMapping("/comentarios/{id}/like")
    @Operation(summary = "Dar like a un comentario")
    public ComentarioComunidad likeComentario(@PathVariable Long id) {
        return comentarioService.like(id);
    }


    @PostMapping("/comentarios/{id}/respuesta")
    @Operation(summary = "Responder un comentario")
    public ComentarioComunidad responderComentario(@PathVariable Long id,
                                                   @RequestBody String respuesta) {
        return comentarioService.responder(id, respuesta);
    }
}
