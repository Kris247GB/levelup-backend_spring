package com.levelup.levelupapi.repository;

import com.levelup.levelupapi.model.ComentarioComunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComentarioComunidadRepository extends JpaRepository<ComentarioComunidad, Long> {
    List<ComentarioComunidad> findByPostId(Long postId);
}
