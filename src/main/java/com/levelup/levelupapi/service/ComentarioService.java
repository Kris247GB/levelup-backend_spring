package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Comentario;
import com.levelup.levelupapi.model.Producto;
import com.levelup.levelupapi.repository.ComentarioRepository;
import com.levelup.levelupapi.repository.ProductoRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository repo;
    private final ProductoRepository productoRepo;

    public ComentarioService(ComentarioRepository repo, ProductoRepository productoRepo) {
        this.repo = repo;
        this.productoRepo = productoRepo;
    }

    public List<Comentario> obtenerComentariosPorProducto(Long productoId) {
        return repo.findByProductoId(productoId);
    }

    public Comentario agregarComentario(Long productoId, Comentario comentario) {

        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        comentario.setProducto(producto);

        return repo.save(comentario);
    }
}
