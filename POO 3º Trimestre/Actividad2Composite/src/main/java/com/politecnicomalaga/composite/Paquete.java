package com.politecnicomalaga.composite;

import java.util.ArrayList;

public class Paquete implements Servicio {

    private String nombre;
    private double tasa;
    private ArrayList<Servicio> listaServicios;

    public Paquete(String nombre, double tasa) {
        this.nombre = nombre;
        this.tasa = tasa;
        listaServicios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addServicio(Servicio servicio) {
        listaServicios.add(servicio);
    }

    public void remove(Servicio servicio) {
        listaServicios.remove(servicio);
    }

    @Override
    public void asignarPrecio(double precio) {
        tasa = precio;
    }

    @Override
    public double obtenerPrecio() {
        double total = tasa;
        for (Servicio servicio: listaServicios) {
                total += servicio.obtenerPrecio();
        }
        return total;
    }

    @Override
    public int getTipo() {
        return 0;
    }

    public Servicio getServicioPorNombre(String nombre) {
        if (this.nombre.equals(nombre))
            return this;
        for (Servicio servicio : listaServicios) {
            if (servicio.getTipo() == Servicio.PAQUETE){
                Servicio paquete = ((Paquete) servicio).getServicioPorNombre(nombre);
                if (paquete!=null && ((Paquete) paquete).getNombre().equals(nombre))
                    return paquete;
            } else if (((Producto) servicio).getNombre().equals(nombre))
                return servicio;
        }
        return null;
    }

    @Override
    public String toString() {
        String resultado = nombre + " [";
        for (int i=0; i<listaServicios.size()-1; i++) {
            resultado += listaServicios.get(i).toString() + ",";
        }
        if (listaServicios.size()>0)
            resultado += listaServicios.get(listaServicios.size()-1);
        resultado += "]";
        return resultado;
    }
}
