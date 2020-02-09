package Factory;

import Modelo.Cliente;
import Modelo.Operacion;
import Modelo.Vehiculo;

public class OperacionCompra implements CreadorDeOperaciones {

    @Override
    public Operacion realizarOperacion(Cliente cliente, Vehiculo vehiculo, double precioTotal, String tipo) {
        Operacion operacion = new Operacion(cliente, vehiculo, precioTotal);
        operacion.setTipo(tipo);
        return(operacion);
    }
}
