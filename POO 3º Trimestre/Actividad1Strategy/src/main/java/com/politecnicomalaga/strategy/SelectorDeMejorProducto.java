package com.politecnicomalaga.strategy;

import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;

public interface SelectorDeMejorProducto {
    int CRITERIO_MEJOR_PRECIO = 1;
    int CRITERIO_MEJOR_VALORACION = 2;
    int CRITERIO_MEJOR_RELACION_VALORACION_PRECIO = 3;

    Producto elegirMejoresProductos (LoteDeProductos loteDeProductos);
}
