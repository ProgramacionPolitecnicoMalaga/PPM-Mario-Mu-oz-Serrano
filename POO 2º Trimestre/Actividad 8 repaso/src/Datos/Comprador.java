package Datos;

public class Comprador {

    private String nombre;
    private double precioCompra;
    private String fechaCompra;

    public Comprador(String nombre){
        this.nombre=nombre;
    }

    public void setPrecioCompra(double precioCompra){
        this.precioCompra=precioCompra;
    }

    public void setFechaCompra(String fechaCompra){
        this.fechaCompra=fechaCompra;
    }

    @Override
    public String toString() {
        return "\nComprador: " + nombre +
                "\nPrecio compra: " + precioCompra + "€" +
                "\nFecha compra: " + fechaCompra;
    }
}