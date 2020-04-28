package com.politecnicomalaga;

import com.politecnicomalaga.builder.ServicioBuilder;
import com.politecnicomalaga.composite.Paquete;
import com.politecnicomalaga.composite.Servicio;

public class App {

    public static void main(String[] args) {
        Paquete paqueteRaiz = new Paquete("iLink1", Servicio.PRECIO_ILINK);
        ServicioBuilder builder = new ServicioBuilder(paqueteRaiz);
        builder.iniciarPaquete("iLink1.1", Servicio.PRECIO_ILINK)
            .iniciarPaquete("Rack1", Servicio.PRECIO_RACK)
                 .addProducto("Servidor1", Servicio.PRECIO_SERVIDOR)
                 .addProducto("Servidor2", Servicio.PRECIO_SERVIDOR)
            .getPadre()
            .iniciarPaquete("Rack2", Servicio.PRECIO_RACK)
                 .addProducto("Servidor3", Servicio.PRECIO_SERVIDOR)
            .getPadre()
        .getPadre()
        .iniciarPaquete("Cloud1", Servicio.PRECIO_CLOUD)
             .addProducto("VPS1", Servicio.PRECIO_VPS)
             .iniciarPaquete("Rack3", Servicio.PRECIO_RACK)
                .addProducto("VPS2", Servicio.PRECIO_VPS)
                .addProducto("VPS3", Servicio.PRECIO_VPS);

        Servicio servicioPrincipal = builder.getResultado();
        System.out.println("Paquete iLink1 construido:");
        System.out.println(servicioPrincipal.toString() + "\n");

        Servicio paqueteRack1 = ((Paquete) servicioPrincipal).getServicioPorNombre("Rack1");
        System.out.println("El precio del paquete Rack1 es de " + paqueteRack1.obtenerPrecio() + "€" + "\n");

        Servicio paqueteiLink11 = ((Paquete) servicioPrincipal).getServicioPorNombre("iLink1.1");
        System.out.println("El precio del paquete iLink1.1 es de " + paqueteiLink11.obtenerPrecio() + "€" + "\n");

        System.out.println("El precio del paquete iLink1 es de " + servicioPrincipal.obtenerPrecio() + "€" + "\n");
        
        Servicio paqueteCloud1 = ((Paquete) servicioPrincipal).getServicioPorNombre("Cloud1");
        System.out.println("El precio del paquete Cloud1 es de " + paqueteCloud1.obtenerPrecio() + "€");
    }
}
