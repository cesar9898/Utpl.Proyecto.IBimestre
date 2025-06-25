package com.ordenesproduccion.apicopimanta.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ordenesproduccion.apicopimanta.entidades.Orden;



@Repository
public interface OrdenRepositorio extends JpaRepository<Orden, Integer> {
      public List<Orden> findByEmail(String email);
      public List<Orden> findByRazonSocial(String razonSocial);
      public List<Orden> findByRuc(String ruc);
      public List<Orden> findByEstadoDeOrden(String estado);
      public List<Orden> findByFechaEntrega(String fechaEntrega);
      public List<Orden> findByTipoDeTrabajo(String tipoDeTrabajo);
      public List<Orden> findByTipoDeTrabajoAndEstadoDeOrden(String tipoDeTrabajo, String estadoDeOrden);
}