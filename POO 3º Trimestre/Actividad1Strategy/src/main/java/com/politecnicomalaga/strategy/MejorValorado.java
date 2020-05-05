package com.politecnicomalaga.strategy;

import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

public class MejorValorado implements SelectorDeMejorProducto{
    @Override
    public Producto elegirMejoresProductos(LoteDeProductos loteDeProductos) {
            double mejorValoracion = Double.MIN_VALUE;
            int posicion = -1;
            for (int i=0; i<loteDeProductos.getTotalProductos(); i++) {
                if (loteDeProductos.getProductoEnPosicion(i).getValoracion() > mejorValoracion) {
                    mejorValoracion = loteDeProductos.getProductoEnPosicion(i).getValoracion();
                    posicion = i;
                }
            }
            return loteDeProductos.getProductoEnPosicion(posicion);
    }
}
