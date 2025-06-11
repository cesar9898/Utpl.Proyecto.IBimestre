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

}
