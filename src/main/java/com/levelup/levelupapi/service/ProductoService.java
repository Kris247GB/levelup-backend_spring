package com.levelup.levelupapi.service;

import com.levelup.levelupapi.exception.ResourceNotFoundException;
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
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Producto no encontrado con ID: " + id));
    }

    public Producto getByCodigo(String codigo) {
        Producto producto = repo.findByCodigo(codigo);
        if (producto == null) {
            throw new ResourceNotFoundException("Producto no encontrado con código: " + codigo);
        }
        return producto;
    }

    public Producto create(Producto p) {
        return repo.save(p);
    }

    public Producto update(Long id, Producto p) {
        Producto original = getById(id); // ← ya lanza excepción si no existe

        original.setCodigo(p.getCodigo());
        original.setCategoria(p.getCategoria());
        original.setNombre(p.getNombre());
        original.setPrecio(p.getPrecio());
        original.setImagen(p.getImagen());
        original.setDescripcion(p.getDescripcion());
        original.setStock(p.getStock());
        original.setDestacado(p.getDestacado());

        return repo.save(original);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("No existe producto con ID: " + id);
        }
        repo.deleteById(id);
    }

    public List<String> listarCategorias() {
        return repo.findAll()
                .stream()
                .map(Producto::getCategoria)
                .filter(c -> c != null && !c.isBlank())
                .distinct()
                .sorted()
                .toList();
    }
}
