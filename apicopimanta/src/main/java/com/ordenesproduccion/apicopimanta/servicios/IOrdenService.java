package com.ordenesproduccion.apicopimanta.servicios;

import java.util.List;

import com.ordenesproduccion.apicopimanta.dtos.OrdenesDto;
import com.ordenesproduccion.apicopimanta.dtos.OrdenesDtoV2;
import com.ordenesproduccion.apicopimanta.entidades.Orden;

public interface IOrdenService {

    public List<Orden> BuscarPorCorreo(String correo);
    public List<Orden> BuscarPorRazonSocial(String razonSocial);
    public List<Orden> BuscarPorRuc(String ruc);
    public List<Orden> BuscarPorEstado(String estado);
    public List<Orden> BuscarPorFechaEntrega(String fechaEntrega);
    public List<Orden> BuscarPorTipoDeTrabajo(String tipoDeTrabajo);
    public OrdenesDto guardarOrden(OrdenesDto ordenesDto); 

    public OrdenesDtoV2 guardarOrdenV2(OrdenesDtoV2 ordenesDtoV2); 

}
