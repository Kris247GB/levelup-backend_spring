package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Boleta;
import com.levelup.levelupapi.repository.BoletaRepository;
import com.levelup.levelupapi.exception.ResourceNotFoundException;  // Importa la excepción

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoletaService {

    private final BoletaRepository boletaRepository;

    public BoletaService(BoletaRepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    public List<Boleta> listar() {
        return boletaRepository.findAll();
    }

    public Boleta obtenerBoleta(Long id) {
        return boletaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la boleta con ID: " + id));
    }

    public List<Boleta> buscarPorUsuario(String email) {
        List<Boleta> boletas = boletaRepository.findByEmailUsuario(email);
        if (boletas == null || boletas.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron boletas para el usuario: " + email);
        }
        return boletas;
    }

    public Boleta crearBoleta(Boleta boleta) {
        return boletaRepository.save(boleta);
    }
}
