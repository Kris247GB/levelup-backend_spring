package com.levelup.levelupapi.service;

import com.levelup.levelupapi.model.Comentario;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ComentarioService {

    // Almacenamiento temporal de los comentarios (esto se debe conectar a la base de datos)
    private List<Comentario> comentarios = new ArrayList<>();

    // Obtener los comentarios de un producto específico
    public List<Comentario> obtenerComentariosPorProducto(Long productoId) {
        // Aquí se filtraría por productoId (en un caso real, deberíamos consultar la base de datos)
        return comentarios.stream()
                .filter(comentario -> comentario.getProductoId().equals(productoId))
                .toList();
    }

    // Agregar un nuevo comentario
    public Comentario agregarComentario(Long productoId, Comentario comentario) {
        comentario.setProductoId(productoId);
        comentario.setFecha("2025-11-29");  // Aquí deberías setear la fecha actual si deseas
        comentarios.add(comentario);
        return comentario;
    }
}
