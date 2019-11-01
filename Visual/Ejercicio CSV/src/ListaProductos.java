public class ListaProductos {
    private String[] idProducto = new String[80];
    private String[] nombre = new String[80];
    private String[] categoria = new String[80];

    public ListaProductos(){

    }

    public String[] getCategoria() {
        return categoria;
    }

    public String[] getIdProducto() {
        return idProducto;
    }

    public String[] getNombre() {
        return nombre;
    }


    public void addIdProducto(String producto){
        idProducto[0] = producto;
        }

    public void addNombre(String producto){
        nombre[0] = producto;
        }

    public void addCategoria(String producto){
        categoria[0] = producto;
    }

}
