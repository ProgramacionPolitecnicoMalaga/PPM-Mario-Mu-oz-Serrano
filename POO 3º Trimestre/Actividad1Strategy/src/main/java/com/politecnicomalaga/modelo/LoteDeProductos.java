package com.politecnicomalaga.modelo;

import com.politecnicomalaga.strategy.SelectorDeMejorProducto;
import java.util.ArrayList;

public class LoteDeProductos {
    private ArrayList<Producto> productos;
    private SelectorDeMejorProducto selectorDeMejorProducto;

    public LoteDeProductos(){
        productos = new ArrayList<>();
    }

    public int getTotalProductos(){
        return productos.size();
    }

    public Producto getProductoEnPosicion(int i){
        return productos.get(i);
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public void setSelectorDeMejorProducto(SelectorDeMejorProducto selectorDeMejorProducto){
        this.selectorDeMejorProducto = selectorDeMejorProducto;
    }

    public Producto getSellersChoice() {
        return selectorDeMejorProducto.elegirMejoresProductos(this);
    }

    @Override
    public String toString() {
        return "Productos del lote: " + productos;
    }
}
