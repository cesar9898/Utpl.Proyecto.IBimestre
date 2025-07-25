package com.ordenesproduccion.apicopimanta.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordenesproduccion.apicopimanta.dtos.OrdenesDto;
import com.ordenesproduccion.apicopimanta.dtos.OrdenesDtoV2;
import com.ordenesproduccion.apicopimanta.entidades.Orden;
import com.ordenesproduccion.apicopimanta.repositorios.OrdenRepositorio;

@Service
public class OrdenService implements IOrdenService {
    @Autowired
    private OrdenRepositorio ordenRepositorio;

    public OrdenesDtoV2 guardarOrdenV2(OrdenesDtoV2 ordenesDtoV2) {
        Orden orden = new Orden();

        orden.setFechaInicio(ordenesDtoV2.getFechaInicio());
        orden.setFechaEntrega(ordenesDtoV2.getFechaEntrega());
        orden.setRazonSocial(ordenesDtoV2.getRazonSocial());
        orden.setRuc(ordenesDtoV2.getRuc());
        orden.setEmail(ordenesDtoV2.getEmail());
        orden.setTelefono(ordenesDtoV2.getTelefono());
        orden.setAcabado(ordenesDtoV2.getAcabado());
        orden.setTipoDeTrabajo(ordenesDtoV2.getTipoDeTrabajo());
        orden.setCantidad(ordenesDtoV2.getCantidad());
        orden.setEstadoFactura(ordenesDtoV2.getEstadoFactura());
        orden.setEstadoDeOrden(ordenesDtoV2.getEstadoOrden());
        orden.setAlto(ordenesDtoV2.getAlto());
        orden.setAncho(ordenesDtoV2.getAncho());
        orden.setTotal(ordenesDtoV2.getAlto() * ordenesDtoV2.getAncho() * 14);
        ordenRepositorio.save(orden);
        return ordenesDtoV2;
    }

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
        return ordenRepositorio.findByEstadoDeOrden(estado);
    }

    public List<Orden> BuscarPorFechaEntrega(String fechaEntrega) {
        return ordenRepositorio.findByFechaEntrega(fechaEntrega);
    }

    public List<Orden> BuscarPorTipoDeTrabajo(String tipoDeTrabajo) {
        return ordenRepositorio.findByTipoDeTrabajo(tipoDeTrabajo);
    }

    /* Listar todas las ordenes */
    public List<Orden> listarTodasLasOrdenes() {
        return ordenRepositorio.findAll();
    }

    public OrdenesDto guardarOrden(OrdenesDto ordenesDto) {
        Orden orden = new Orden();

        orden.setFechaInicio(ordenesDto.getFechaInicio());
        orden.setFechaEntrega(ordenesDto.getFechaEntrega());
        orden.setRazonSocial(ordenesDto.getRazonSocial());
        orden.setRuc(ordenesDto.getRuc());
        orden.setEmail(ordenesDto.getEmail());
        orden.setTelefono(ordenesDto.getTelefono());
        orden.setAcabado(ordenesDto.getAcabado());
        orden.setTipoDeTrabajo(ordenesDto.getTipoDeTrabajo());
        orden.setCantidad(ordenesDto.getCantidad());
        orden.setEstadoFactura(ordenesDto.getEstadoFactura());
        orden.setEstadoDeOrden(ordenesDto.getEstadoOrden());
        ordenRepositorio.save(orden);
        return ordenesDto;
    }

    public Orden buscarPorId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

}
