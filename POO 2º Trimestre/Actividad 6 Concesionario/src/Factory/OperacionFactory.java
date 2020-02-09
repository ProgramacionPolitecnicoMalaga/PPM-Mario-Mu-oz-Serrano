package Factory;

import Modelo.Cliente;
import Modelo.Operacion;
import Modelo.Vehiculo;
import Negocio.GestorOperaciones;

public class OperacionFactory {

    public static Operacion realizarOperacion(Cliente cliente, Vehiculo vehiculo, double precioTotal, String tipo) {
        Operacion operacion = null;
        switch (tipo) {
            case GestorOperaciones.OPERACION_COMPRA:
                operacion = new OperacionCompra().realizarOperacion(cliente, vehiculo, precioTotal, tipo);
                break;
            case GestorOperaciones.OPERACION_VENTA:
                operacion = new OperacionVenta().realizarOperacion(cliente, vehiculo, precioTotal, tipo);
                break;
        }
        return operacion;
    }
}
