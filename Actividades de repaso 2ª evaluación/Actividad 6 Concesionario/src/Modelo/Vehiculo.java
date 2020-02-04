package Modelo;

public class Vehiculo {
    private String matricula, modelo, marca, color, combustion, estado;
    private int añoFabricacion;
    private double precioRecomendado;

    public Vehiculo(String matricula, String modelo, String marca, String color, String combustion, String estado, int añoFabricacion, double precioRecomendado) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.combustion = combustion;
        this.estado = estado;
        this.añoFabricacion = añoFabricacion;
        this.precioRecomendado = precioRecomendado;
    }

    public String getMatricula() {
        return matricula;
    }
}
