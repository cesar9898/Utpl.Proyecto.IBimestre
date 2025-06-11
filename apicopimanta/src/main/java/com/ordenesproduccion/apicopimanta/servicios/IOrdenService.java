package com.ordenesproduccion.apicopimanta.servicios;

import java.util.List;

import com.ordenesproduccion.apicopimanta.entidades.Orden;

public interface IOrdenService {

    public List<Orden> BuscarPorCorreo(String correo);
    public List<Orden> BuscarPorRazonSocial(String razonSocial);
    public List<Orden> BuscarPorRuc(String ruc);
    public List<Orden> BuscarPorEstado(String estado);
    public List<Orden> BuscarPorFechaEntrega(String fechaEntrega);
    public List<Orden> BuscarPorTipoDeTrabajo(String tipoDeTrabajo);
    



}
