package com.ordenesproduccion.apicopimanta.controladores;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordenesproduccion.apicopimanta.dtos.OrdenesDto;
import com.ordenesproduccion.apicopimanta.entidades.Orden;
import com.ordenesproduccion.apicopimanta.servicios.OrdenService;

@RestController
@RequestMapping("/api/ordenes-produccion")
public class OrdenesProduccionRestController {
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/ordenes")
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
        trabajo1.put("cantidad", 1000);
        trabajo1.put("color", "Full color");

        Map<String, Object> trabajo2 = new HashMap<>();
        trabajo2.put("tipo", "Flayers promocionales");
        trabajo2.put("cantidad", 5000);
        trabajo2.put("color", "full color");

        trabajos.add(trabajo1);
        trabajos.add(trabajo2);

        // Orden de producción
        respuesta.put("ordenId", "456");
        respuesta.put("cliente", cliente);
        respuesta.put("trabajos", trabajos);
        respuesta.put("estado", "Creada");
        respuesta.put("fechaCreacion", new Date(0));

        return respuesta;
    }
    // endpoint para enlistar los estados y su ID de las órdenes de producción

    @GetMapping("/estados")
    public List<Map<String, Object>> obtenerEstados() {
        List<Map<String, Object>> estados = new ArrayList<>();

        Map<String, Object> estado1 = new HashMap<>();
        estado1.put("id", 1);
        estado1.put("nombre", "Pendiente");

        Map<String, Object> estado2 = new HashMap<>();
        estado2.put("id", 2);
        estado2.put("nombre", "En proceso");

        Map<String, Object> estado3 = new HashMap<>();
        estado3.put("id", 3);
        estado3.put("nombre", "Completada");

        estados.add(estado1);
        estados.add(estado2);
        estados.add(estado3);

        return estados;

    }

    // Endpoint para actualizar datos de una orden de producción
    @PutMapping("/ordenes/{id}")
    public Map<String, Object> actualizarOrden(@PathVariable String id, @RequestBody OrdenesDto ordenActualizada) {
        Map<String, Object> respuesta = new HashMap<>();

        // Simulación de actualización de la orden
        respuesta.put("ordenId", id);
        respuesta.put("cliente", ordenActualizada.getCliente());
        respuesta.put("trabajo", ordenActualizada.getTrabajo());
        respuesta.put("cantidad", ordenActualizada.getCantidad());
        respuesta.put("estado", ordenActualizada.getEstado());
        respuesta.put("fechaActualizacion", new Date(0));

        return respuesta;
    }

    // Obtener ordenes por correo
    @GetMapping("/busqueda/{correo}")
    public List<Orden> getListaOrdenByCorreo(@PathVariable String correo) {
        var ordenes = ordenService.BuscarPorCorreo(correo);
        if (ordenes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        System.out.println("obteniendo ordenes por correo: " + correo);
        // Retornar ordenes por email encontrado
        return ordenes;
    }

}
