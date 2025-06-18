package com.ordenesproduccion.apicopimanta.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordenesproduccion.apicopimanta.dtos.OrdenesDto;
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
    public OrdenesDto guardarOrden(OrdenesDto ordenesDto) {
        Orden orden = new Orden();
        orden.setOrdenid(Integer.parseInt(ordenesDto.getOrdenId()));
        orden.setFechaInicio(ordenesDto.getFechaInicio());
        orden.setFechaEntrega(ordenesDto.getFechaEntrega());
        orden.setRazonSocial(ordenesDto.getRazonSocial());
        orden.setRuc(ordenesDto.getRuc());
        orden.setEmail(ordenesDto.getEmail());
        orden.setTelefono(ordenesDto.getTelefono());
        orden.setAcabado(ordenesDto.getAcabado());
        orden.setTipoDeTrabajo(ordenesDto.getTipoDeTrabajo());
        orden.setCantidad(String.valueOf(ordenesDto.getCantidad()));
        orden.setEstadoFactura(ordenesDto.getEstadoFactura());
        orden.setEstadoDeOrden(ordenesDto.getEstadoOrden());
        ordenRepositorio.save(orden);
        return ordenesDto;
    }

}
