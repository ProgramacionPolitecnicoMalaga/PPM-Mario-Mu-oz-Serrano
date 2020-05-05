package com.politecnicomalaga.strategy;

import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

public class MejorPrecio implements SelectorDeMejorProducto{
    @Override
    public Producto elegirMejoresProductos(LoteDeProductos loteDeProductos) {
        double mejorPrecio = Double.MAX_VALUE;
        int posicion = -1;
        for (int i=0; i<loteDeProductos.getTotalProductos(); i++) {
            if (loteDeProductos.getProductoEnPosicion(i).getPrecio() < mejorPrecio) {
                mejorPrecio = loteDeProductos.getProductoEnPosicion(i).getPrecio();
                posicion = i;
            }
        }
        return loteDeProductos.getProductoEnPosicion(posicion);
    }
}
