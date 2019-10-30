public class ConsumidorCola {
    private static Cola cola;
    private static final int TAM_COLA = 5;

    public static void main(String[] args) throws ElementoNoExistenteException {
        cola = new Cola(TAM_COLA);
        try {
            cola.sacar();
            System.out.println(cola);
            cola.sacar();
            System.out.println(cola);
        } catch (ElementoNoExistenteException e) {

        }
    }
}