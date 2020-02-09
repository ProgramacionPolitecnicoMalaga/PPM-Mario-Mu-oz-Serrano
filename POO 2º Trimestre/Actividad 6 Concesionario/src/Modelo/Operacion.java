package Modelo;

public class Operacion {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private String tipo;
    private double precioTotal;

    public Operacion(Cliente cliente, Vehiculo vehiculo, double precioTotal) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.precioTotal = precioTotal;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public String getTipo() {
        return tipo;
    }
}
