import java.util.Scanner;

public class InterfazUsuario {

    private int opcionElegida;
    private Scanner lectorTeclado = new Scanner(System.in);
    private String unidad;
    private double cateto1;
    private double cateto2;
    private double hipotenusa;
    private double area;
    private Operador operador = new Operador();

    public InterfazUsuario() {

    }

    public void mostrarMenu() {
        System.out.println("¿Qué unidad desea utilizar?\n" +
                "1. mm\n" +
                "2. cm\n" +
                "3. m\n" +
                "Introduzca una opción:");
                opcionElegida = lectorTeclado.nextInt();
                cambiarUnidad();
                menuOpciones();
    }

    private void cambiarUnidad() {
        switch (opcionElegida) {
            case 1: unidad = "mm";
            case 2: unidad = "cm";
            case 3: unidad = "m";
            default: opcionUnidadNoValida();
        }
    }

    private void menuOpciones() {
        System.out.print("\n\n=============================" +
                "\n¿Qué operación desea realizar?\n" +
                "\n1. Calcular la hipotenusa de un triángulo a partir de sus catetos." +
                "\n2. Calcular un cateto de un triángulo a partir de el otro cateto y la hipotenusa" +
                "\n3. Calcular el área de un triángulo a partir de un cateto y la hipotenusa" +
                "\n4. Calcular el área de un triángulo a partir de dos catetos." +
                "\n5. Salir del programa." +
                "\nElige una opción:");
                opcionElegida = lectorTeclado.nextInt();
                segundaOpcionElegida();
    }

    private void segundaOpcionElegida() {
        switch (opcionElegida) {
            case 1: opcionOperacion1();
            case 2: opcionOperacion2();
            case 3: opcionOperacion3();
            case 4: opcionOperacion4();
            case 5: return;
            default: segundaOpcionNoValida();
        }
    }

    private void opcionUnidadNoValida() {
        System.out.println("Esa unidad no es válida. Se utilizarán mm.");
        unidad = "mm";
    }

    private void segundaOpcionNoValida() {
        System.out.println("Esa opción no existe. Eliga otra opción");
        menuOpciones();
    }

    private void opcionOperacion1() {
        mostrarTextoCateto1();
        cateto1 = lectorTeclado.nextDouble();
        mostrarTextoCateto2();
        cateto2 = lectorTeclado.nextDouble();
        hipotenusa = operador.operacionOpcion1(cateto1, cateto2);
        System.out.println("La longitud de la hipotenusa es " + hipotenusa + unidad);
    }

    private void opcionOperacion2() {
        mostrarTextoCateto1();
        cateto1 = lectorTeclado.nextDouble();
        mostrarTextoHipotenusa();
        hipotenusa = lectorTeclado.nextDouble();
        cateto2 = operador.operacionOpcion2(cateto1, hipotenusa);
        System.out.println("La longitud del segundo cateto es " + cateto2 + unidad);
    }

    private void opcionOperacion3() {
        mostrarTextoCateto1();
        cateto1 = lectorTeclado.nextDouble();
        mostrarTextoHipotenusa();
        hipotenusa = lectorTeclado.nextDouble();
        area = operador.operacionOpcion3(cateto1, hipotenusa);
        System.out.println("El área del triángulo es " + area + unidad);
    }

    private void opcionOperacion4() {
        mostrarTextoCateto1();
        cateto1 = lectorTeclado.nextDouble();
        mostrarTextoCateto2();
        cateto2 = lectorTeclado.nextDouble();
        area = operador.operacionOpcion4(cateto1, cateto2);
        System.out.println("El área del triángulo es " + area + unidad);
    }

    private void mostrarTextoCateto1() {
        System.out.print("Introduce la longitud del primer cateto: ");
    }

    private void mostrarTextoCateto2() {
        System.out.print("Introduce la longitud del segundo cateto: ");
    }

    private void mostrarTextoHipotenusa() {
        System.out.print("Introduce la longitud de la hipotenusa: ");
    }
}
