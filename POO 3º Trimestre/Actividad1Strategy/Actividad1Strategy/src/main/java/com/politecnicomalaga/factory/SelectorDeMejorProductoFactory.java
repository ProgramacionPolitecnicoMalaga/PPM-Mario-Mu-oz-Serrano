package com.politecnicomalaga.factory;

import com.politecnicomalaga.strategy.MejorPrecio;
import com.politecnicomalaga.strategy.MejorValoracionPrecio;
import com.politecnicomalaga.strategy.MejorValorado;
import com.politecnicomalaga.strategy.SelectorDeMejorProducto;

public class SelectorDeMejorProductoFactory {

        public static SelectorDeMejorProducto getSelectorDeMejorProducto(int criterio) {
            switch (criterio) {
                case SelectorDeMejorProducto.CRITERIO_MEJOR_PRECIO:
                    return new MejorPrecio();
                case SelectorDeMejorProducto.CRITERIO_MEJOR_VALORACION:
                    return new MejorValorado();
                case SelectorDeMejorProducto.CRITERIO_MEJOR_RELACION_VALORACION_PRECIO:
                    return new MejorValoracionPrecio();
                default:
                    return new MejorPrecio();
            }
        }
}
