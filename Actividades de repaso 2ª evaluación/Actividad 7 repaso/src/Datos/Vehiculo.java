package Datos;

import java.util.Objects;

public abstract class Vehiculo {

    private String fechaFabricacion;
    private String fechaEntrada;
    private String numeroBastidor;
    private String tipo;
    private boolean vendido=false;
    private Comprador comprador;

    public Vehiculo(String fechaFabricacion, String fechaEntrada, String numeroBastidor, String tipo){
        this.fechaFabricacion=fechaFabricacion;
        this.fechaEntrada=fechaEntrada;
        this.numeroBastidor=numeroBastidor;
        this.tipo=tipo;
    }

    public String getVendido() {
        if (vendido) return "Sí";
        else return "\n";
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    @Override
    public boolean equals(Object o) {
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(numeroBastidor, vehiculo.numeroBastidor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroBastidor);
    }

    @Override
    public String toString() {
        return "Tipo de vehículo: " + tipo +
                "\nFecha de fabricación: " + fechaFabricacion +
                "\nFecha de entrada: " + fechaEntrada +
                "\nNumero de bastidor: " + numeroBastidor +
                "\nVendido: " + getVendido() + comprador;
    }
}