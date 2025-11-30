package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.PostComunidad;
import com.levelup.levelupapi.repository.PostComunidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostComunidadService {

    private final PostComunidadRepository repo;

    public PostComunidadService(PostComunidadRepository repo) {
        this.repo = repo;
    }

    public List<PostComunidad> listar() {
        return repo.findAll();
    }

    public PostComunidad crear(PostComunidad post) {
        return repo.save(post);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
