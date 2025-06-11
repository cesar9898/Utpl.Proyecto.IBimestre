package com.ordenesproduccion.apicopimanta.servicios;

import java.util.List;

import com.ordenesproduccion.apicopimanta.entidades.Orden;

public interface IOrdenService {

    public List<Orden> BuscarPorCorreo(String correo);
}
