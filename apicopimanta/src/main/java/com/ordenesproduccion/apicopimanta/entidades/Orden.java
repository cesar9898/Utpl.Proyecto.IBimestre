package com.ordenesproduccion.apicopimanta.entidades;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
@Table(name = "ordenes")
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class Orden  implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String fecha_inicio;
  
  private String razon_social;
  
  private String ruc;

  private String email;  

  private String telefono;

  private String tipo_de_trabajo;

  private String cantidad;

  private String acabado;

  private double precio_total;

  private String estado_factura;

  private String estado;

  private String fecha_entrega;
  

 
}