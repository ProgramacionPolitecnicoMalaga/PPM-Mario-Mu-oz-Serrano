package UserInterface;

import Factory.OperacionVenta;

import java.util.Scanner;

public class Vista extends OperacionVenta{

    private Scanner lectorTeclado;

    public Vista() {
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu() {
        System.out.println("Opciones:\n" +
                "1. Introducir un nuevo vehículo.\n" +
                "2. Introducir un nuevo cliente.\n" +
                "3. Realizar una venta.\n" +
                "4. Realizar una compra.\n" +
                "5. Obtener el balance total de un cliente en el concesionario.\n" +
                "0. Salir.\n" +
                "Opción: ");
        return lectorTeclado.nextInt();
    }

    public void imprimirBalance(double balance) {
        System.out.println("El balance total del cliente con respecto al concesionario es de " + balance + "€\n");
    }

    public String obtenerMatricula() {
        System.out.println("Introduce la matrícula del vehículo: ");
        return lectorTeclado.next();
    }

    public String obtenerModelo() {
        System.out.println("Introduce el modelo del vehículo: ");
        return lectorTeclado.next();
    }

    public String obtenerMarca() {
        System.out.println("Introduce la marca del vehículo: ");
        return lectorTeclado.next();
    }

    public String obtenerColor() {
        System.out.println("Introduce el color del vehículo: ");
        return lectorTeclado.next();
    }

    public String obtenerCombustion() {
        System.out.println("Introduce el tipo de combustión del vehículo: ");
        return lectorTeclado.next();
    }

    public String obtenerEstado() {
        System.out.println("Introduce el estado del vehículo: ");
        return lectorTeclado.next();
    }

    public int obtenerAñoFabricacion() {
        System.out.println("Introduce el año del vehículo: ");
        return lectorTeclado.nextInt();
    }

    public double obtenerPrecio() {
        System.out.println("Introduce el precio del vehículo: ");
        return lectorTeclado.nextDouble();
    }

    public String obtenerNombre() {
        System.out.println("Introduce el nombre del cliente: ");
        return lectorTeclado.next();
    }

    public String obtenerApellidos() {
        System.out.println("Introduce los apellidos del cliente: ");
        return lectorTeclado.next();
    }

    public String obtenerNIF() {
        System.out.println("Introduce el NIF del cliente: ");
        return lectorTeclado.next();
    }

    public String obtenerCuentaBancaria() {
        System.out.println("Introduce la cuenta bancaria del cliente: ");
        return lectorTeclado.next();
    }
}