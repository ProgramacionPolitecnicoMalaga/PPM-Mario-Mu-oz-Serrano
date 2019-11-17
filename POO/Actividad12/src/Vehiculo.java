public abstract class Vehiculo {

    private String fechaFabricacion;
    private String fechaEntrada;
    private String numeroBastidor;

    public Vehiculo(String fechaFabricacion, String fechaEntrada, String numeroBastidor){
        this.fechaFabricacion=fechaFabricacion;
        this.fechaEntrada=fechaEntrada;
        this.numeroBastidor=numeroBastidor;
    }

    public String getNumeroBastidor(){
        return numeroBastidor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "fechaFabricacion='" + fechaFabricacion + '\'' +
                ", fechaEntrada='" + fechaEntrada + '\'' +
                ", numeroBastidor='" + numeroBastidor + '\'' +
                '}';
    }
}
