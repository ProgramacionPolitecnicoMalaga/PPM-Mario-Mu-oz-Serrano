package com.politecnicomalaga.modelo;

public class Persona {
    private String nombre;
    private String DNI;

    public Persona(String nombre, String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public boolean equals(Object o) {
        Persona comparada = (Persona) o;
        return (nombre.equals(comparada.getNombre()) && DNI.equals(comparada.getDNI()));
    }
}