package com.politecnicomalaga.modelo;

public class Vehiculo {
    private String matricula;
    private String DNIPropietario;

    public Vehiculo(String matricula, String DNIPropietario) {
        this.matricula = matricula;
        this.DNIPropietario = DNIPropietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDNIPropietario() {
        return DNIPropietario;
    }

    public void setDNIPropietario(String DNIPropietario) {
        this.DNIPropietario = DNIPropietario;
    }
}