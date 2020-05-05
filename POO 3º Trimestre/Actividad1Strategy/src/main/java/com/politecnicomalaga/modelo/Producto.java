package com.politecnicomalaga.modelo;

public class Producto {
    private String nombre;
    private double precio;
    private double valoracion;

    public Producto(String nombre, double precio, double valoracion){
        this.nombre=nombre;
        this.precio=precio;
        this.valoracion=valoracion;
    }

    public double getPrecio(){
        return precio;
    }

    public double getValoracion(){
        return valoracion;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "\n===================" +
                "\nNombre: " + nombre +
                "\nPrecio: " + precio +
                "\nValoración: " + valoracion;
    }
}
