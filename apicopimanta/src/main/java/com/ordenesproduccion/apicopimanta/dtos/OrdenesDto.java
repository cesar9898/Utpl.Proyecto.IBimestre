package com.ordenesproduccion.apicopimanta.dtos;

public class OrdenesDto {
    
    private String cliente;
    private String trabajo;
    private int cantidad;
    private String estado;
    private String ordenId;

    public OrdenesDto() {
    }

    public OrdenesDto(String cliente, String trabajo, int cantidad, String estado, String ordenId  ) {
        this.cliente = cliente;
        this.trabajo = trabajo;
        this.cantidad = cantidad;
        this.estado = estado;
        this.ordenId = ordenId;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrdenId() {
        return ordenId;
    }
}
