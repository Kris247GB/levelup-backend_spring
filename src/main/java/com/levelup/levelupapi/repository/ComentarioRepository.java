package com.levelup.levelupapi.repository;

import com.levelup.levelupapi.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByProductoId(Long productoId);
}
