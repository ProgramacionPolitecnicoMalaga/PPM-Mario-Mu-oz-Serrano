package Modelo;

import java.util.ArrayList;

public class Cuenta {

    private static int numeroCuentaSiguiente = 1;
    private int numeroCuenta = 0;
    private int numeroMesa;
    private ArrayList<Producto> productos;
    private double total;

    public Cuenta(int numeroMesa, ArrayList<Producto> productos, double total) {
        this.numeroMesa = numeroMesa;
        this.productos = productos;
        this.total = total;
        numeroCuenta = numeroCuentaSiguiente;
        numeroCuentaSiguiente++;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    @Override
    public String toString() {
        return "\nNúmero de cuenta: " + numeroCuenta +
                "\nNúmero de mesa: " + numeroMesa +
                "\nProductos: " + productos +
                "\n\nTotal: " + total + "€";
    }
}
