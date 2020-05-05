package com.politecnicomalaga;

import com.politecnicomalaga.factory.SelectorDeMejorProductoFactory;
import com.politecnicomalaga.modelo.LoteDeProductos;
import com.politecnicomalaga.modelo.Producto;
import com.politecnicomalaga.strategy.SelectorDeMejorProducto;
import java.util.Scanner;

public class App {
    private static Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    private static LoteDeProductos loteDeProductos;

    public static void main(String[] args) {
        añadirProductos();
        int opcion;
        System.out.println(loteDeProductos);
        do {
            System.out.println("-------------------------------------");
            System.out.println("Elige un criterio de valoración y te recomendaremos el mejor producto:");
            System.out.print("1. Mejor precio\n" +
                    "2. Mejor valorado\n" +
                    "3. Mejor relación valoración-precio\n" +
                    "0. Salir\n" +
                    "Opción: ");
            opcion = lectorTeclado.nextInt();
            System.out.println("------------------------------------");
            if (opcion!=0) {
                SelectorDeMejorProducto selectorDeMejorProducto = SelectorDeMejorProductoFactory.getSelectorDeMejorProducto(opcion);
                loteDeProductos.setSelectorDeMejorProducto(selectorDeMejorProducto);
                System.out.println("\nMejor producto: " + loteDeProductos.getSellersChoice() + "\n===================\n");
            }
        } while (opcion!=0);
    }

    public static void añadirProductos() {
        loteDeProductos = new LoteDeProductos();
        loteDeProductos.addProducto(new Producto("Producto 1",25, 3.5));
        loteDeProductos.addProducto(new Producto("Producto 2",20, 5));
        loteDeProductos.addProducto(new Producto("Producto 3",33, 2.5));
        loteDeProductos.addProducto(new Producto("Producto 4",40.5, 4));
        loteDeProductos.addProducto(new Producto("Producto 5",30.2, 1));
    }
}
