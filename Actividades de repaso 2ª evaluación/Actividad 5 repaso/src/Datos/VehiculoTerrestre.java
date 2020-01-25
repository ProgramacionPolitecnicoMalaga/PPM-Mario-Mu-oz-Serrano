package Datos;

public class VehiculoTerrestre extends Vehiculo {

    private String matricula;
    private double ancho;
    private double altura;
    private double longitud;

    public VehiculoTerrestre (String fechaFabricacion, String fechaEntrada, String numeroBastidor, String matricula, String tipo, double ancho, double altura, double longitud) {
        super(fechaFabricacion, fechaEntrada, numeroBastidor, tipo);
        this.matricula=matricula;
        this.ancho=ancho;
        this.altura=altura;
        this.longitud=longitud;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMatricula: " + matricula;
    }
}