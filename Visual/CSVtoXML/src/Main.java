public class Main {

    public static void main(String[] args) {

        long cronometro;

        System.out.println("Generar archivo aerolineas.xml:");
        EscrituraAerolineasXML generadorAerolineas = new EscrituraAerolineasXML();
        System.out.print("El conversor con cadena completó la tarea en ");
        cronometro = System.nanoTime();
        generadorAerolineas.generarAerolineasCadena();
        System.out.println((System.nanoTime() - cronometro)/1000000 + " milisegundos");
        System.out.print("El conversor con nodos completó la tarea en ");
        cronometro = System.nanoTime();
        generadorAerolineas.generarAerolineasNodos();
        System.out.println((System.nanoTime() - cronometro)/1000000 + " milisegundos");

        System.out.println("---------------------------------");
        System.out.println("---------------------------------");

        System.out.println("Generar archivo aeropuertos.xml:");
        EscrituraAeropuertosXML generadorAeropuertos = new EscrituraAeropuertosXML();
        System.out.print("El conversor con cadena completó la tarea en ");
        cronometro = System.nanoTime();
        generadorAeropuertos.generarAeropuertosCadena();
        System.out.println((System.nanoTime() - cronometro)/1000000 + " milisegundos");
        System.out.print("El conversor con nodos completó la tarea en ");
        generadorAeropuertos.generarAeropuertosNodos();
        System.out.println((System.nanoTime() - cronometro)/1000000 + " milisegundos");
    }
}
