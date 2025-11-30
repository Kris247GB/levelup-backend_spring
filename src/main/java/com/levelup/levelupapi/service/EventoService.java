package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Evento;
import com.levelup.levelupapi.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository repo;

    public EventoService(EventoRepository repo) {
        this.repo = repo;
    }

    public List<Evento> listar() {
        return repo.findAll();
    }

    public Evento crear(Evento evento) {
        return repo.save(evento);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
