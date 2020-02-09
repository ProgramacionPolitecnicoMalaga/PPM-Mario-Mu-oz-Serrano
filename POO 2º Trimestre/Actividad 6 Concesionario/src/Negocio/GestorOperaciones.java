package Negocio;

import Factory.OperacionFactory;

import Modelo.Cliente;
import Modelo.Operacion;
import Modelo.Vehiculo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestorOperaciones {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Operacion> operaciones = new ArrayList<Operacion>();
    public final static String OPERACION_COMPRA = "Compra";
    public final static String OPERACION_VENTA = "Venta";

    public GestorOperaciones() {

    }

    public void introducirVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void introducirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void crearOperacion(Cliente cliente, Vehiculo vehiculo, double precioTotal, String tipo) {
        operaciones.add(OperacionFactory.realizarOperacion(cliente, vehiculo, precioTotal, tipo));
    }

    public double obtenerBalanceCliente(Cliente cliente) {
        double comprasCliente = 0;
        double ventasCliente = 0;
        Iterator<Operacion> it = operaciones.iterator();
        while (it.hasNext()) {
            Operacion operacion = it.next();
            if (operacion.getCliente()==cliente) {
                if (operacion.getTipo().equals(OPERACION_COMPRA)) {
                    comprasCliente += operacion.getPrecioTotal();
                }
                else ventasCliente += operacion.getPrecioTotal();
            }
        }
        return ventasCliente - comprasCliente;
    }

    public Cliente buscarCliente(String nif) {
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            Cliente cliente = it.next();
            if (cliente.getNIF().equals(nif)) {
                return cliente;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String matricula) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo vehiculo = it.next();
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }
}
