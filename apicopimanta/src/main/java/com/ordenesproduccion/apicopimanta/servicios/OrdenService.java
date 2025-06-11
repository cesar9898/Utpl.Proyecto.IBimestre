package com.ordenesproduccion.apicopimanta.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordenesproduccion.apicopimanta.entidades.Orden;
import com.ordenesproduccion.apicopimanta.repositorios.OrdenRepositorio;

@Service
public class OrdenService implements IOrdenService {
    @Autowired
    private OrdenRepositorio ordenRepositorio;

    @Override
    public List<Orden> BuscarPorCorreo(String correo) {
        return ordenRepositorio.findByEmail(correo);
    } 
    public List<Orden> BuscarPorRazonSocial(String razonSocial) {
        return ordenRepositorio.findByRazonSocial(razonSocial);
    }
    public List<Orden> BuscarPorRuc(String ruc) {
        return ordenRepositorio.findByRuc(ruc);
    }
    public List<Orden> BuscarPorEstado(String estado) {
        return ordenRepositorio.findByEstado(estado);
    }
    public List<Orden> BuscarPorFechaEntrega(String fechaEntrega) {
        return ordenRepositorio.findByFechaEntrega(fechaEntrega);
    }
    public List<Orden> BuscarPorTipoDeTrabajo(String tipoDeTrabajo) {
        return ordenRepositorio.findByTipoDeTrabajo(tipoDeTrabajo);

    }

}
