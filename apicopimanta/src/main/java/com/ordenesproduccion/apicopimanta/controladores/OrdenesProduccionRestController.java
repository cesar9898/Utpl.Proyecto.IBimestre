package com.ordenesproduccion.apicopimanta.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/ordenes-produccion")
public class OrdenesProduccionRestController {
    @GETMapping("/ordenes")
    public String obtenerOrdenes() {
        return "Lista de órdenes de producción";
    } 
    // Endpoint para crear una nueva orden de producción con datos ficticios
    @PostMapping("/ordenes")
    public Map<String, Object> crearOrden() {
        Map<String, Object> respuesta = new HashMap<>();

        // Datos de cliente
        Map<String, String> cliente = new HashMap<>();
        cliente.put("nombre", "Juan Pérez");
        cliente.put("email", "juan.perez@ejemplo.com");
        cliente.put("telefono", "0999999999");

        // Trabajos de impresión
        List<Map<String, Object>> trabajos = new ArrayList<>();
        Map<String, Object> trabajo1 = new HashMap<>();
        trabajo1.put("tipo", "Tarjetas de presentación");
        trabajo1.put("cantidad", 500);
        trabajo1.put("color", "Full color");

        Map<String, Object> trabajo2 = new HashMap<>();
        trabajo2.put("tipo", "Folletos");
        trabajo2.put("cantidad", 1000);
        trabajo2.put("color", "Blanco y negro");

        trabajos.add(trabajo1);
        trabajos.add(trabajo2);

        // Orden de producción 
        respuesta.put("cliente", cliente);
        respuesta.put("trabajos", trabajos);
        respuesta.put("estado", "Creada");
        respuesta.put("fechaCreacion", new Date());

        return respuesta;
    }


}
