package com.politecnicomalaga.composite;

public class Producto implements Servicio{

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void asignarPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public int getTipo() {
        return Servicio.PRODUCTO;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
