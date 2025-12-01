package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.Evento;
import com.levelup.levelupapi.service.EventoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService service;

    public EventoController(EventoService service) {
        this.service = service;
    }

    // ✔ LISTAR EVENTOS
    @GetMapping
    public List<Evento> listar() {
        return service.listar();
    }

    // ✔ CREAR EVENTO
    @PostMapping
    public Evento crear(@RequestBody Evento evento) {
        return service.crear(evento);
    }

    // ✔ ELIMINAR EVENTO
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
