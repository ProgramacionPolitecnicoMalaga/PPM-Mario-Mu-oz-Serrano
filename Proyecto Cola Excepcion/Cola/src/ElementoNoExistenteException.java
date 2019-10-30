public class ElementoNoExistenteException extends Exception{

    public ElementoNoExistenteException(String message) {
        super(message);
        System.out.println("No es posible realizar la acción");
    }
}
