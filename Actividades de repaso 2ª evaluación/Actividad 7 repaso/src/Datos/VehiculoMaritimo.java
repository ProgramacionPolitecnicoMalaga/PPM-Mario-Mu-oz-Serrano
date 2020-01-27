package Datos;

public class VehiculoMaritimo extends Vehiculo {

    private String nombre;
    private double eslora;
    private double calado;
    private double manga;

    public VehiculoMaritimo (String fechaFabricacion, String fechaEntrada, String numeroBastidor, String nombre, String tipo, double eslora, double calado, double manga) {
        super(fechaFabricacion, fechaEntrada, numeroBastidor, tipo);
        this.nombre=nombre;
        this.eslora=eslora;
        this.calado=calado;
        this.manga=manga;
    }
}