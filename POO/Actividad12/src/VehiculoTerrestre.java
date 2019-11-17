public class VehiculoTerrestre extends Vehiculo {

    private String matricula;
    private double ancho;
    private double altura;
    private double longitud;
    private boolean vendido=false;

    public VehiculoTerrestre (String fechaFabricacion, String fechaEntrada, String numeroBastidor, String matricula, double ancho, double altura, double longitud) {
        super(fechaFabricacion, fechaEntrada, numeroBastidor);
        this.matricula=matricula;
        this.ancho=ancho;
        this.altura=altura;
        this.longitud=longitud;
    }

    public String getMatricula(){
        return matricula;
    }

    @Override
    public String toString() {
        return "VehiculoTerrestre{" +
                "matricula=" + matricula + '\'' +
                ", ancho=" + ancho +
                ", altura=" + altura +
                ", longitud=" + longitud +
                '}';
    }

    public void setVendido(){
        vendido=true;
    }
}
