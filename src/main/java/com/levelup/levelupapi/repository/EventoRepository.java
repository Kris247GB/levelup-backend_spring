package com.levelup.levelupapi.repository;

import com.levelup.levelupapi.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
