package com.ordenesproduccion.apicopimanta.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class OrdenesProduccionRestController {
   
@RestController
@RequestMapping ("/api/ordenes-produccion")
public class OrdenesProduccionRestController {
    @GETMapping("/ordenes")
    public String obtenerOrdenes() {
        return "Lista de órdenes de producción";
    }

    // Aquí puedes definir los métodos para manejar las solicitudes HTTP
    // por ejemplo, @GetMapping, @PostMapping, etc.

    // Ejemplo de un método GET
    // @GetMapping
    // public List<OrdenProduccion> obtenerTodasLasOrdenes() {
    //     return ordenProduccionService.obtenerTodasLasOrdenes();
    // }

    // Ejemplo de un método POST
    // @PostMapping
    // public OrdenProduccion crearOrden(@RequestBody OrdenProduccion orden) {
    //     return ordenProduccionService.crearOrden(orden);
    // }


}
