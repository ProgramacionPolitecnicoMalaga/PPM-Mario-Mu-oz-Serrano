public class NullProductException extends NullPointerException {

    public NullProductException(String message) {
        super(message);
        System.out.println(message + "Introduce un producto válido por favor");
    }
}