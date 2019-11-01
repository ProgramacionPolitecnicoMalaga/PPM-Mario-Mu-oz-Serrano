public class OrdenarProductos {

    public OrdenarProductos(){
    }

    public String ordenarProductos(String[] linea){
        ListaProductos listas = new ListaProductos();
        listas.addIdProducto(linea[0]);
        listas.addNombre(linea[1]);
        listas.addCategoria(linea[2]);
        return ("ID Producto:" + listas.getIdProducto()[0] + "  Nombre:  " + listas.getNombre()[0] + "  Categoria:  " + listas.getCategoria()[0] + "\n");
    }

}
