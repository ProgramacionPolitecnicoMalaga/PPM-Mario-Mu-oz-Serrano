package UserInterface;

import Negocio.GestorOperaciones;

import Modelo.Cliente;
import Modelo.Vehiculo;

public class ControladorVista {

    private Vista vista;
    private GestorOperaciones gestorOperaciones = new GestorOperaciones();
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double precio;

    private final static int INTRODUCIR_VEHICULO = 1;
    private final static int INTRODUCIR_CLIENTE = 2;
    private final static int REALIZAR_VENTA = 3;
    private final static int REALIZAR_COMPRA = 4;
    private final static int OBTENER_BALANCE = 5;
    private final static int TERMINAR = 0;

    public void inicializarVista() {
        vista = new Vista();
        int opcion;
        opcion = vista.mostrarMenu();
        while (opcion != TERMINAR) {
            switch (opcion) {
                case INTRODUCIR_VEHICULO:
                    String matricula = vista.obtenerMatricula();
                    String modelo = vista.obtenerModelo();
                    String marca = vista.obtenerMarca();
                    String color = vista.obtenerColor();
                    String combustion = vista.obtenerCombustion();
                    String estado = vista.obtenerEstado();
                    int añoFabricacion = vista.obtenerAñoFabricacion();
                    double precioRecomendado = vista.obtenerPrecio();
                    gestorOperaciones.introducirVehiculo(new Vehiculo(matricula, modelo, marca, color, combustion, estado, añoFabricacion, precioRecomendado));
                    break;
                case INTRODUCIR_CLIENTE:
                    String nombre = vista.obtenerNombre();
                    String apellidos = vista.obtenerApellidos();
                    String NIF = vista.obtenerNIF();
                    String cuentaBancaria = vista.obtenerCuentaBancaria();
                    gestorOperaciones.introducirCliente(new Cliente(nombre, apellidos, NIF, cuentaBancaria));
                    break;
                case REALIZAR_VENTA:
                    solicitarDatosOperacion();
                    gestorOperaciones.crearOperacion(cliente, vehiculo, precio, GestorOperaciones.OPERACION_VENTA);
                    break;
                case REALIZAR_COMPRA:
                    solicitarDatosOperacion();
                    gestorOperaciones.crearOperacion(cliente, vehiculo, precio, GestorOperaciones.OPERACION_COMPRA);
                    break;
                case OBTENER_BALANCE:
                    cliente = gestorOperaciones.buscarCliente(vista.obtenerNIF());
                    vista.imprimirBalance(gestorOperaciones.obtenerBalanceCliente(cliente));
                    break;
            }
            opcion = vista.mostrarMenu();
        }
    }

    public void solicitarDatosOperacion() {
        cliente = gestorOperaciones.buscarCliente(vista.obtenerNIF());
        vehiculo = gestorOperaciones.buscarVehiculo(vista.obtenerMatricula());
        precio = vista.obtenerPrecio();
    }
}