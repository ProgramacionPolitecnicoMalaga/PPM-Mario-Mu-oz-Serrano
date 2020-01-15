import java.util.Scanner;

public class Interfaz {

    private Scanner lectorTeclado = new Scanner(System.in);
    public static final int OP_INTRODUCIR_NUEVO_EMPLEADO = 1;
    public static final int OP_GENERAR_INFORME_EMPLEADOS = 2;
    public static final int OP_SALIR = 3;
    public static final int OP_INTRODUCIR_NUEVO_COMISIONADO = 1;
    public static final int OP_INTRODUCIR_NUEVO_POR_HORAS = 2;
    public static final int OP_INTRODUCIR_NUEVO_ASALARIADO = 3;

    public Interfaz() {

    }

        public int opcionesGestionEmpleados(){
            System.out.println("Menú principal.\n" +
                    "1. Introducir nuevo empleado.\n" +
                    "2. Generar informe de los empleados.\n" +
                    "3. Salir.\n"+
                    "Elija una opción: ");
            return lectorTeclado.nextInt();
        }

        public int elegirTipoEmpleado() {
            System.out.println("Elige el tipo de empleado a crear:\n" +
                    "1. Comisionado.\n" +
                    "2. Por horas.\n" +
                    "3. Asalariado.");
            return lectorTeclado.nextInt();
        }

        public String pedirNombre(){
            System.out.print("Indique nombre: ");
            return lectorTeclado.next();
        }

        public String pedirApellidos() {
            System.out.print("Indique apellidos:");
            return lectorTeclado.next();
        }

        public String pedirDNI() {
            System.out.print("Indique DNI:");
            return lectorTeclado.next();
        }

        public int pedirHorasTrabajadas(){
            System.out.print("Por favor, indique las horas trabajadas del empleado:");
            return lectorTeclado.nextInt();
        }

        public int pedirVentasRealizadas(){
            System.out.print("Indique las ventas realizadas:");
            return lectorTeclado.nextInt();
        }

        public void mensajeRegistroEmpleado(){
            System.out.println("\nEmpleado registrado.\n");
        }

        public void mensajeSalir(){
            System.out.println("\nHasta pronto!");
        }
    }