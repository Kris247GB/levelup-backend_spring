package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Boleta;
import com.levelup.levelupapi.repository.BoletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaService {

    private final BoletaRepository repo;

    public BoletaService(BoletaRepository repo) {
        this.repo = repo;
    }

    public Boleta crearBoleta(Boleta boleta) {
        return repo.save(boleta);
    }

    public Boleta obtenerBoleta(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Boleta> listar() {
        return repo.findAll();
    }

    public List<Boleta> buscarPorUsuario(String email) {
        return repo.findByEmailUsuario(email);
    }

}
