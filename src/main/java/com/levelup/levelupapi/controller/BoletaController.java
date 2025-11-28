package com.levelup.levelupapi.controller;

import com.levelup.levelupapi.model.Boleta;
import com.levelup.levelupapi.service.BoletaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletas")
public class BoletaController {

    private final BoletaService service;

    public BoletaController(BoletaService service) {
        this.service = service;
    }

    @PostMapping
    public Boleta crearBoleta(@RequestBody Boleta boleta) {
        return service.crearBoleta(boleta);
    }

    @GetMapping
    public List<Boleta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Boleta obtener(@PathVariable Long id) {
        return service.obtenerBoleta(id);
    }

    @GetMapping("/usuario/{email}")
    public List<Boleta> buscarPorUsuario(@PathVariable String email) {
        return service.buscarPorUsuario(email);
    }

}
