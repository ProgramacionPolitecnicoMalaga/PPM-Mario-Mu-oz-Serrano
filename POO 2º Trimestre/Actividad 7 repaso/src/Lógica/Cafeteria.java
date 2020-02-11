package Lógica;

import Modelo.Cuenta;
import Modelo.Mesa;
import Modelo.Producto;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Cafeteria {
    private TreeMap<Integer, Mesa> mesas;
    private TreeMap<String, Producto> carta;
    private TreeMap<Integer, Cuenta> cuentas;
    private Caja caja;

    public Cafeteria(){
        mesas = new TreeMap<>();
        carta = new TreeMap<>();
        cuentas = new TreeMap<>();
        caja = new Caja();
    }

    public void addMesa(int numeroMesa){
        mesas.put(numeroMesa,new Mesa(numeroMesa));
    }

    public Producto getProducto(String nombreProducto) {
        return carta.get(nombreProducto);
    }

    public Mesa getMesa(int numeroMesa) {
        return mesas.get(numeroMesa);
    }

    public void addProducto(String nombreProducto, double precio){
        Producto producto = new Producto(nombreProducto,precio);
        carta.put(nombreProducto,producto);
    }

    public void addProductoAMesa(int numeroMesa, String nombreProducto){
        Mesa mesa = mesas.get(numeroMesa);
        Producto producto = carta.get(nombreProducto);
        if ((mesa != null) && (producto != null))
            mesa.addProducto(producto);
            mesa.setCerrada(false);
    }

    public ArrayList<Mesa> getMesasAbiertas(){
        ArrayList<Mesa> mesasAbiertas = new ArrayList<>();
        for (Map.Entry<Integer, Mesa> entry: mesas.entrySet()){
            if (!entry.getValue().isCerrada())
                mesasAbiertas.add(entry.getValue());
        }
        return mesasAbiertas;
    }

    public ArrayList<Mesa> getMesasCerradas() {
        ArrayList<Mesa> mesasCerradas = new ArrayList<>();
        for (Map.Entry<Integer, Mesa> entry: mesas.entrySet()){
            if (entry.getValue().isCerrada())
                mesasCerradas.add(entry.getValue());
        }
        return mesasCerradas;
    }

    public double getRecuentoCaja() {
        return caja.getRecuento();
    }

    public double getTotalMesa(int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa);
        return caja.getTotalMesa(mesa);
    }

    public Cuenta cerrarMesa(int numeroMesa) {
        Mesa mesa = mesas.get(numeroMesa);
        double total = caja.cobrarMesa(mesa);
        Cuenta cuenta = new Cuenta(numeroMesa, mesa.getProductos(), total);
        cuentas.put(cuenta.getNumeroCuenta(), cuenta);
        mesa.setProductos(new ArrayList<>());
        mesa.setCerrada(true);
        return cuenta;
    }

    public Cuenta getCuenta(int numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }
}
