package com.politecnicomalaga.strategy;

import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

public class MejorValoracionPrecio implements SelectorDeMejorProducto{

    @Override
    public Producto elegirMejoresProductos(LoteDeProductos loteDeProductos) {
        double mejorCalidadPrecio = Double.MIN_VALUE;
        int posicion = 0;
        for (int i=0; i<loteDeProductos.getTotalProductos(); i++) {
            if (loteDeProductos.getProductoEnPosicion(i).getValoracion()/loteDeProductos.getProductoEnPosicion(i).getPrecio() > mejorCalidadPrecio) {
                mejorCalidadPrecio = loteDeProductos.getProductoEnPosicion(i).getValoracion()/loteDeProductos.getProductoEnPosicion(i).getPrecio();
                posicion = i;
            }
        }
        return loteDeProductos.getProductoEnPosicion(posicion);
    }
}
