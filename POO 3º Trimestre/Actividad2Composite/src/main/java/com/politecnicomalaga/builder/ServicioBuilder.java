package com.politecnicomalaga.builder;

import com.politecnicomalaga.composite.Paquete;
import com.politecnicomalaga.composite.Producto;
import com.politecnicomalaga.composite.Servicio;

public class ServicioBuilder {
    private ServicioBuilder builderPadre;
    private Paquete paquete;

    public ServicioBuilder(Paquete paquete){
        this.paquete = paquete;
        builderPadre = null;
    }

    public ServicioBuilder(Paquete paquete, ServicioBuilder builderPadre){
        this.paquete = paquete;
        this.builderPadre = builderPadre;
    }

    public ServicioBuilder iniciarPaquete(String nombreNuevoPaquete, double precio){
        Paquete nuevoPaquete = new Paquete(nombreNuevoPaquete, precio);
        this.paquete.addServicio(nuevoPaquete);
        return new ServicioBuilder(nuevoPaquete,this);
    }

    public ServicioBuilder getPadre(){
        return builderPadre;
    }

    public ServicioBuilder addProducto(String nombre, double precio){
        paquete.addServicio(new Producto(nombre, precio));
        return this;
    }

    public Servicio getResultado(){
        return paquete;
    }
}
