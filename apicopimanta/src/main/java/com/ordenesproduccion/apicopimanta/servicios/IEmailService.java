package com.ordenesproduccion.apicopimanta.servicios;

public interface IEmailService {
    public void enviarCorreo(String para, String asunto, String contenido);
}