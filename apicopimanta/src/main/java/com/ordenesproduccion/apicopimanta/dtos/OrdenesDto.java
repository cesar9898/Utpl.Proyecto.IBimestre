package com.ordenesproduccion.apicopimanta.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrdenesDto {

   
    private String fechaInicio;
    private String fechaEntrega;
    private String razonSocial;
    private String ruc;
    private String email;
    private String telefono;
    private String acabado;
    private String tipoDeTrabajo;
    private int cantidad;
    private String estadoFactura;
    private String estadoOrden;

}