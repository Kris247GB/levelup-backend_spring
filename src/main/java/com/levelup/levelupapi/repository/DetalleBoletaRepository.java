package com.levelup.levelupapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.levelup.levelupapi.model.DetalleBoleta;

public interface DetalleBoletaRepository extends JpaRepository<DetalleBoleta, Long> {
}
