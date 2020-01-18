public class Gestor {

    private Interfaz interfaz = new Interfaz();
    private int opcionElegida;
    private int numeroEmpleadosIntroducidos = 0;
    private Empleado[] empleados = new Empleado[500];

    public Gestor() {

    }

    public void calcularSueldo(Empleado empleado) {
        empleado.calcularSueldo();
    }

    public void iniciarInterfaz() {
        do {
            opcionElegida = interfaz.opcionesGestionEmpleados();
            if (opcionElegida == Interfaz.OP_INTRODUCIR_NUEVO_EMPLEADO) {
                opcionElegida = interfaz.elegirTipoEmpleado();
                System.out.println(opcionElegida);
                crearEmpleado();
            }
            if (opcionElegida == Interfaz.OP_GENERAR_INFORME_EMPLEADOS) {
                for (int i = 0; i < numeroEmpleadosIntroducidos; i++) {
                    System.out.println(empleados[i]);
                }
            }
            if (opcionElegida == Interfaz.OP_SALIR) {
                interfaz.mensajeSalir();
            }
        } while (opcionElegida != Interfaz.OP_SALIR);
    }

    public void crearEmpleado() {
        Empleado empleado = null;
        String nombre = interfaz.pedirNombre();
        String apellidos = interfaz.pedirApellidos();
        String DNI = interfaz.pedirDNI();
        switch (opcionElegida) {
            case Interfaz.OP_INTRODUCIR_NUEVO_COMISIONADO:
            int ventasRealizadas = interfaz.pedirVentasRealizadas();
            empleado = new Comisionado(nombre, apellidos, DNI, ventasRealizadas);
            empleados[numeroEmpleadosIntroducidos] = empleado;
            break;
            case Interfaz.OP_INTRODUCIR_NUEVO_POR_HORAS:
            int horasTrabajadas = interfaz.pedirHorasTrabajadas();
            empleado = new PorHoras(nombre, apellidos, DNI, horasTrabajadas);
            empleados[numeroEmpleadosIntroducidos] = empleado;
            break;
            case Interfaz.OP_INTRODUCIR_NUEVO_ASALARIADO:
            empleado = new Asalariado(nombre, apellidos, DNI);
            empleados[numeroEmpleadosIntroducidos] = empleado;
            break;
        }
        if (empleado != null) calcularSueldo(empleado);
        interfaz.mensajeRegistroEmpleado();
        numeroEmpleadosIntroducidos++;
        opcionElegida = 0;
    }
}