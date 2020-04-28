package com.politecnicomalaga;

import com.politecnicomalaga.builder.ServicioBuilder;
import com.politecnicomalaga.composite.Paquete;
import com.politecnicomalaga.composite.Servicio;

public class App {

    public static void main(String[] args) {
        ServicioBuilder builder = new ServicioBuilder("iLink1", Servicio.PRECIO_ILINK);
        builder.iniciarPaquete("iLink1.1", Servicio.PRECIO_ILINK)
            .iniciarPaquete("Rack1", Servicio.PRECIO_RACK)
                 .addProducto("Servidor1", Servicio.PRECIO_SERVIDOR)
                 .addProducto("Servidor2", Servicio.PRECIO_SERVIDOR)
            .finalizarPaquete()
            .iniciarPaquete("Rack2", Servicio.PRECIO_RACK)
                 .addProducto("Servidor3", Servicio.PRECIO_SERVIDOR)
            .finalizarPaquete()
        .finalizarPaquete()
        .iniciarPaquete("Cloud1", Servicio.PRECIO_CLOUD)
             .addProducto("VPS1", Servicio.PRECIO_VPS)
             .iniciarPaquete("Rack3", Servicio.PRECIO_RACK)
                .addProducto("VPS2", Servicio.PRECIO_VPS)
                .addProducto("VPS3", Servicio.PRECIO_VPS)
             .finalizarPaquete()
        .finalizarPaquete()
        .finalizarPaquete();

        Servicio servicio = builder.getResultado();
        System.out.println("Paquete iLink1 construido:");
        System.out.println(servicio.toString() + "\n");

        System.out.println("Calcular precio de Rack1:");
        Servicio paqueteRack1 = ((Paquete) servicio).getServicioPorNombre("Rack1");
        System.out.println("El precio del paquete es de " + paqueteRack1.obtenerPrecio() + "€");

        System.out.println("Calcular precio de iLink1.1:");
        Servicio paqueteiLink11 = ((Paquete) servicio).getServicioPorNombre("iLink1.1");
        System.out.println("El precio del paquete es de " + paqueteiLink11.obtenerPrecio() + "€");

        System.out.println("Calcular precio de iLink1:");
        Servicio paqueteiLink1 = ((Paquete) servicio).getServicioPorNombre("iLink1");
        System.out.println("El precio del paquete es de " + paqueteiLink1.obtenerPrecio() + "€");

        System.out.println("Calcular precio de Cloud1:");
        Servicio paqueteCloud1 = ((Paquete) servicio).getServicioPorNombre("Cloud1");
        System.out.println("El precio del paquete es de " + paqueteCloud1.obtenerPrecio() + "€");
    }
}
