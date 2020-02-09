package Factory;

import Modelo.Cliente;
import Modelo.Operacion;
import Modelo.Vehiculo;

public interface CreadorDeOperaciones {

    public Operacion realizarOperacion(Cliente cliente, Vehiculo vehiculo, double precioTotal, String tipo);

}
