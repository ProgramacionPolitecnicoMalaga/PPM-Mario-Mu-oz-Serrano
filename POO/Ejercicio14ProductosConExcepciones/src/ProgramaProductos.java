public class ProgramaProductos {

    public static void main(String[] args) {

        LoteDeProductos lote = new LoteDeProductos(5);

        Producto producto1 = new Producto("Escoba", 20, 3);

            producto1=null;

         try {
             lote.addProducto(producto1);
         } catch (NullProductException ignored) {
             }

            lote.getProductoEnPosicion(50);

    }

}
