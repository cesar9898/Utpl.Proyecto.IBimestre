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
import com.ordenesproduccion.apicopimanta.dtos.OrdenesDtoV2;
import com.ordenesproduccion.apicopimanta.entidades.Orden;
import com.ordenesproduccion.apicopimanta.servicios.EmailService;
import com.ordenesproduccion.apicopimanta.servicios.OrdenService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/ordenes-produccion")

public class OrdenesProduccionRestController {
    @Autowired
    private OrdenService ordenService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/ordenes")
    @Operation(summary = "listar todas las órdenes de producción")
    public List<Orden> listarTodasLasOrdenes() {
        List<Orden> ordenes = ordenService.listarTodasLasOrdenes();
        if (ordenes.isEmpty()) {
            return null; // O lanzar una excepción si no se encuentra
        }
        // Retornar ordenes por razon social encontrado
        return ordenes;
    }

    // Endpoint para ingresar datos desde la pantalla de órdenes de producción
    @Operation(summary = "ingresar datos de órdenes de producción")
    @PostMapping("/ordenes-produccion/crear-Ordenes/v1")
    public ResponseEntity<OrdenesDto> crearOrden(@RequestBody OrdenesDto ordenesDto) {
        OrdenesDto CrearOrden = ordenService.guardarOrden(ordenesDto);
        emailService.enviarCorreo(ordenesDto.getEmail(), "Nueva Orden Creada",
                "Se ha creado una nueva orden: " + CrearOrden);
        return ResponseEntity.status(HttpStatus.CREATED).body(CrearOrden);

    }

    // Endpoint para ingresar datos desde la pantalla de órdenes de producción
    @Operation(summary = "ingresar datos de órdenes de producción")
    @PostMapping("/ordenes-produccion/crear-Ordenes/v2")
    public ResponseEntity<OrdenesDtoV2> crearOrdenV2(@RequestBody OrdenesDtoV2 ordenesDtoV2) {
        OrdenesDtoV2 CrearOrden = ordenService.guardarOrdenV2(ordenesDtoV2);
        emailService.enviarCorreo(ordenesDtoV2.getEmail(), "Nueva Orden Creada",
                "Se ha creado una nueva orden: " + CrearOrden);
        return ResponseEntity.status(HttpStatus.CREATED).body(CrearOrden);

    }

    @GetMapping("/ordenes-produccion/formulario")
    public String mostrarFormulario() {
        return "formulario"; // nombre del archivo sin .html
    }

    // endpoint para enlistar los estados y su ID de las órdenes de producción

    @Operation(summary = "enlistar los estados y su ID de las órdenes de producción")
    @GetMapping("/ordenes/{id}/resumen")
    public ResponseEntity<Map<String, Object>> getEstadoYRazonSocialPorId(@PathVariable String id) {
        Orden orden = ordenService.buscarPorId(id);
        if (orden == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("razonSocial", orden.getRazonSocial());
        respuesta.put("estado", orden.getEstadoDeOrden());
        return ResponseEntity.ok(respuesta);
    }

    // Endpoint para actualizar datos de una orden de producción
    @Operation(summary = "actualizar datos de una orden de producción")
    @PutMapping("/ordenes/{id}")
    public Map<String, Object> actualizarOrden(@PathVariable String id, @RequestBody OrdenesDto ordenActualizada,
            OrdenesDto ordenesDto, String string) {
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

    // Obtener ordenes por razon social
    @Operation(summary = "obtener ordenes por razon social")
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
    @Operation(summary = "obtener ordenes por ruc")
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
    @Operation(summary = "obtener ordenes por estado")
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
    @Operation(summary = "obtener ordenes por fecha de entrega")
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
