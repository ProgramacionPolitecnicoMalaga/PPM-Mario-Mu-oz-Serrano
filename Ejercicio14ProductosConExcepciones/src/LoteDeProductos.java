public class LoteDeProductos {

    private Producto[] productos;
    private int numeroProductosAlmacenados;

    public LoteDeProductos(int cantidad){
        productos = new Producto[cantidad];
        numeroProductosAlmacenados = 0;
    }

    public int getTotalProductos(){
        return productos.length;
    }

    Producto getProductoEnPosicion(int i) throws ProductPositionException{

        if ((i >= 0) && (i <= numeroProductosAlmacenados)) {
            return productos[i];
        }

        else {
            throw new ProductPositionException("La posición no es valida. ", numeroProductosAlmacenados);
        }
    }

    public void addProducto(Producto producto) throws NullProductException{

        if (producto == null) {
            throw new NullProductException("El producto no es válido. ");
        }

        else if (numeroProductosAlmacenados < productos.length){
            productos[numeroProductosAlmacenados] = producto;
            numeroProductosAlmacenados++;
        }
    }

    public Producto[] getListaProductos(){
        return productos;
    }

}
