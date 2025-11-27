package com.levelup.levelupapi.repository;

import com.levelup.levelupapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByCodigo(String codigo);
}
