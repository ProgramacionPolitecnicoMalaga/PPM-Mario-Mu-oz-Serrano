package Modelo;

import java.util.ArrayList;

public class Mesa {
    private int numeroMesa;
    private boolean cerrada;
    private ArrayList<Producto> productos;

    public Mesa(int numeroMesa){
        productos = new ArrayList<>();
        this.numeroMesa = numeroMesa;
        cerrada = true;
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public boolean isCerrada() {
        return cerrada;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "\nMesa Nº : " + numeroMesa +
                "\nCerrada: " + cerrada + "\n";
    }
}
