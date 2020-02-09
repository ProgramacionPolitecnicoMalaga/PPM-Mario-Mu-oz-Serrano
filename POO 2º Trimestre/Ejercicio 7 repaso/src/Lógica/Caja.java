package Lógica;

import Modelo.Mesa;
import Modelo.Producto;

import java.util.Iterator;

public class Caja {

    private double recuento;

    public Caja(){

    }

    public double getRecuento() {
        return recuento;
    }


    public double cobrarMesa(Mesa mesa) {
        double total = getTotalMesa(mesa);
        recuento += total;
        return total;
    }

    public double getTotalMesa(Mesa mesa) {
        double total = 0;
        Iterator<Producto> it = mesa.getProductos().iterator();
        while (it.hasNext()) {
            total += it.next().getPrecio();
        }
        return total;
    }
}
