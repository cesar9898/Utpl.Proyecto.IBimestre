package com.ordenesproduccion.apicopimanta.controladores;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    // Endpoint para ingresar datos desde la pantalla de órdenes de producción       
    @PostMapping("/ordenes-produccion/Crear-Ordenes")
    public ResponseEntity<OrdenesDto> crearOrden(@RequestBody OrdenesDto ordenesDto) {
        OrdenesDto CrearOrden = ordenService.guardarOrden(ordenesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(CrearOrden);

    }

    @GetMapping("/ordenes-produccion/formulario")
    public String mostrarFormulario() {
    return "formulario"; // nombre del archivo sin .html
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
    public Map<String, Object> actualizarOrden(@PathVariable String id, @RequestBody OrdenesDto ordenActualizada, OrdenesDto ordenesDto, String string) {
        Map<String, Object> respuesta = new HashMap<>();

        // Simulación de actualización de la orden
        respuesta.put("ordenId", id);
        respuesta.put("rasonSocial", ordenActualizada.getRazonSocial());
        respuesta.put("trabajo", ordenActualizada.getTipoDeTrabajo());
        respuesta.put("estadoFactura", ordenActualizada.getEstadoFactura());
        respuesta.put("estadoOrden", ordenActualizada.getEstadoOrden()); 
        respuesta.put(string, ordenesDto.getFechaEntrega());   
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

    // Obtener ordenes por razon social
    @GetMapping("/busqueda/razon-social/{razonSocial}")
    public List<Orden> getListaOrdenByRazonSocial(@PathVariable String razonSocial) {
        var ordenes = ordenService.BuscarPorRazonSocial(razonSocial);
        if (ordenes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        System.out.println("obteniendo ordenes por razon social: " + razonSocial);
        // Retornar ordenes por razon social encontrado
        return ordenes;
    }
    // Obtener ordenes por ruc
    @GetMapping("/busqueda/ruc/{ruc}")
    public List<Orden> getListaOrdenByRuc(@PathVariable String ruc) {
        var ordenes = ordenService.BuscarPorRuc(ruc);
        if (ordenes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        System.out.println("obteniendo ordenes por ruc: " + ruc);
        // Retornar ordenes por ruc encontrado
        return ordenes;
    }
    // Obtener ordenes por estado
    @GetMapping("/busqueda/estado/{estado}")
    public List<Orden> getListaOrdenByEstado(@PathVariable String estado) {
        var ordenes = ordenService.BuscarPorEstado(estado);
        if (ordenes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        System.out.println("obteniendo ordenes por estado: " + estado);
        // Retornar ordenes por estado encontrado
        return ordenes;
    }
    // Obtener ordenes por fecha de entrega
    @GetMapping("/busqueda/fecha-entrega/{fechaEntrega}")
    public List<Orden> getListaOrdenByFechaEntrega(@PathVariable String fechaEntrega) {
        var ordenes = ordenService.BuscarPorFechaEntrega(fechaEntrega);
        if (ordenes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        System.out.println("obteniendo ordenes por fecha de entrega: " + fechaEntrega);
        // Retornar ordenes por fecha de entrega encontrado
        return ordenes;     


    }

}
