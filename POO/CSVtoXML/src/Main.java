public class Main {

    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        System.out.print("El conversor con cadena String tardó en completar la tarea ");
        long inicioConversorCadena = System.nanoTime();
        conversor.convertirConCadena();
        System.out.println((System.nanoTime() - inicioConversorCadena)/1000000 + " milisegundos");
        System.out.println("---------------------------------");
        System.out.print("El conversor con nodos Dom tardó en completar la tarea ");
        long inicioConversorConNodos = System.nanoTime();
        conversor.convertirConNodos();
        System.out.println((System.nanoTime() - inicioConversorConNodos)/1000000 + " milisegundos");
    }
}
