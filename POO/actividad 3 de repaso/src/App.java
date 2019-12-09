public class App {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Productos productos = new Productos();

        //Leer desde un documento XML el inventario de componentes:
        inventario.leerXMLExistencias("/src/inventario.xml");

        //Leer desde un documento XML los requisitos de los productos:
        productos.leerXMLExistencias("/src/productos.xml");

        /*Monitorizar la fabricación de productos, para que cada vez
        que se fabrica un nuevo producto se actualice el inventario
        de componentes.*/
        Producto producto = productos.getProducto("P33");
        inventario.fabricarProducto(producto);

        //Mostrar el inventario por pantalla.
        inventario.mostrarInventario();

        //Generar XML con el inventario.
        inventario.componerXMLExistencias();
    }

}
