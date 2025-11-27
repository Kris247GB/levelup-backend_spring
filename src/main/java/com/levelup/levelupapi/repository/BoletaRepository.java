package com.levelup.levelupapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.levelup.levelupapi.model.Boleta;

public interface BoletaRepository extends JpaRepository<Boleta, Long> {

    List<Boleta> findByEmailUsuario(String emailUsuario);

}
