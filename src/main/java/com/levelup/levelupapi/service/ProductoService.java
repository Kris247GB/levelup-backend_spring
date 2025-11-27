package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Producto;
import com.levelup.levelupapi.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> getAll() {
        return repo.findAll();
    }

    public Producto getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Producto getByCodigo(String codigo) {
        return repo.findByCodigo(codigo);
    }

    public Producto create(Producto p) {
        return repo.save(p);
    }

    public Producto update(Long id, Producto p) {
        Producto original = getById(id);
        if (original == null) {
            return null;
        }

        original.setCodigo(p.getCodigo());
        original.setCategoria(p.getCategoria());
        original.setNombre(p.getNombre());
        original.setPrecio(p.getPrecio());
        original.setImagen(p.getImagen());
        original.setDescripcion(p.getDescripcion());
        original.setStock(p.getStock());
        original.setDestacado(p.isDestacado());

        return repo.save(original);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
