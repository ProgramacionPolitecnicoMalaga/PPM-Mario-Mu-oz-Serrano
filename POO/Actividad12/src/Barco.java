public class Barco extends Vehiculo {

    private String nombre;
    private double eslora;
    private double calado;
    private double manga;
    private boolean vendido=false;

    public Barco (String fechaFabricacion, String fechaEntrada, String numeroBastidor, String nombre, double eslora, double calado, double manga) {
        super(fechaFabricacion, fechaEntrada, numeroBastidor);
        this.nombre=nombre;
        this.eslora=eslora;
        this.calado=calado;
        this.manga=manga;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "Barco{" +
                "nombre=" + nombre + '\'' +
                ", eslora=" + eslora +
                ", calado=" + calado +
                ", manga=" + manga +
                '}';
    }
    public void setVendido(){
        vendido=true;
    }
}
