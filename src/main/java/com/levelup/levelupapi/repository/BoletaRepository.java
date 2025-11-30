package com.levelup.levelupapi.repository;

import com.levelup.levelupapi.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoletaRepository extends JpaRepository<Boleta, Long> {

    List<Boleta> findByEmailUsuario(String email);  //Métodoo para obtener las boletas por email del usuario
}
