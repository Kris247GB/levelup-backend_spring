package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.PostComunidad;
import com.levelup.levelupapi.service.PostComunidadService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunidad")
@Tag(name = "Comunidad", description = "API para publicaciones de usuarios en la comunidad gamer")
public class PostComunidadController {

    private final PostComunidadService service;

    public PostComunidadController(PostComunidadService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar publicaciones")
    public List<PostComunidad> listar() {
        return service.listar();
    }

    @PostMapping
    @Operation(summary = "Crear nueva publicación")
    public PostComunidad crear(@RequestBody PostComunidad post) {
        return service.crear(post);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar publicación por ID")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
