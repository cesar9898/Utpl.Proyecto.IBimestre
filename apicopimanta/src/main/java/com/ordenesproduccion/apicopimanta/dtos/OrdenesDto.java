package com.ordenesproduccion.apicopimanta.dtos;

public class OrdenesDto {

    private String ordenId;
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

    public OrdenesDto() {
    }

    public OrdenesDto(String ordenId, String fechaInicio, String fechaEntrega, String razonSocial, String ruc,
            String email, String telefono, String acabado, String tipoDeTrabajo, int cantidad, String estadoFactura,
            String estadoOrden) {
        this.ordenId = ordenId;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.razonSocial = razonSocial;
        this.ruc = ruc;
        this.email = email;
        this.telefono = telefono;
        this.acabado = acabado;

        this.tipoDeTrabajo = tipoDeTrabajo;
        this.cantidad = cantidad;
        this.estadoFactura = estadoFactura;
        this.estadoOrden = estadoOrden;

    }

    public String getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(String ordenId) {
        this.ordenId = ordenId;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {

        this.fechaEntrega = fechaEntrega;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        this.telefono = telefono;
    }

    public String getAcabado() {
        return acabado;
    }

    public void setAcabado(String acabado) {
        this.acabado = acabado;
    }

    public String getTipoDeTrabajo() {

        return tipoDeTrabajo;
    }

    public void setTipoDeTrabajo(String tipoDeTrabajo) {

        this.tipoDeTrabajo = tipoDeTrabajo;

    }

    public int getCantidad() {

        return cantidad;

    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadoFactura() {

        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {

        this.estadoFactura = estadoFactura;
    }

    public String getEstadoOrden() {

        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

}
