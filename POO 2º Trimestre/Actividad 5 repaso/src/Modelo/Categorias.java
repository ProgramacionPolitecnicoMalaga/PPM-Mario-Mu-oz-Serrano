package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Categorias {

    private ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public Categorias() {
    }

    public ArrayList<Categoria> getCategorias() {
        return listaCategorias;
    }

    public void añadirCategoria(Categoria categoria) {
        listaCategorias.add(categoria);
    }

    public void listaCategorias(List list) {
        Iterator<Categoria> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println("======================");
        }
    }
}