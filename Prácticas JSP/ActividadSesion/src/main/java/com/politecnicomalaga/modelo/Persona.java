package com.politecnicomalaga.modelo;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private int edad;
    private LocalDate fecha;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        fecha = LocalDate.now();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
