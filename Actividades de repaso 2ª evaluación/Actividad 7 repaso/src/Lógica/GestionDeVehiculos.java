package Lógica;

import Datos.Vehiculo;
import Datos.Comprador;

import java.util.ArrayList;

public class GestionDeVehiculos {
    private ArrayList<Vehiculo> deposito = new ArrayList<Vehiculo>();
    private ArrayList<Vehiculo> listaSubasta = new ArrayList<Vehiculo>();
    private ArrayList<Vehiculo> listaVendidos = new ArrayList<Vehiculo>();

    public ArrayList<Vehiculo> getDeposito() {
        return deposito;
    }

    public ArrayList<Vehiculo> getListaSubasta() {
        return listaSubasta;
    }

    public ArrayList<Vehiculo> getListaVendidos() {
        return listaVendidos;
    }

    public void añadirVehiculoDeposito(Vehiculo vehiculo) {
        deposito.add(vehiculo);
    }

    public void añadirVehiculoSubasta(Vehiculo vehiculo) {
        listaSubasta.add(vehiculo);
        deposito.remove(vehiculo);
    }

    public void añadirVehiculoVendido(Vehiculo vehiculo) {
        listaVendidos.add(vehiculo);
    }

    public void venderVehiculo(Vehiculo vehiculo, Comprador comprador, double precio, String fecha) {
        añadirVehiculoVendido(vehiculo);
        listaSubasta.remove(vehiculo);
        comprador.setPrecioCompra(precio);
        comprador.setFechaCompra(fecha);
        vehiculo.setVendido(true);
        vehiculo.setComprador(comprador);
    }
}
