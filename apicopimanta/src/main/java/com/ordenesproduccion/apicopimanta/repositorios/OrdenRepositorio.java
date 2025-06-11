package com.ordenesproduccion.apicopimanta.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ordenesproduccion.apicopimanta.entidades.Orden;



@Repository
public interface OrdenRepositorio extends JpaRepository<Orden, Integer> {
      public List<Orden> findByEmail(String email);
}