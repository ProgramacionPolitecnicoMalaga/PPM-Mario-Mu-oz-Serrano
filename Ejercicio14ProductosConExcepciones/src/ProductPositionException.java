public class ProductPositionException extends ArrayIndexOutOfBoundsException {

    public ProductPositionException(String message, int cantidadPosiciones) {
        super(message);
        System.out.println(message + "La posicion máxima es " + cantidadPosiciones);
    }
}