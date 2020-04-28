package com.politecnicomalaga.composite;

public interface Servicio {

    double PRECIO_ILINK = 30;
    double PRECIO_RACK = 20;
    double PRECIO_SERVIDOR = 25;
    double PRECIO_CLOUD = 15;
    double PRECIO_VPS = 20;

    int PAQUETE = 0;
    int PRODUCTO = 1;

    void asignarPrecio(double precio);
    double obtenerPrecio();
    int getTipo();
}
