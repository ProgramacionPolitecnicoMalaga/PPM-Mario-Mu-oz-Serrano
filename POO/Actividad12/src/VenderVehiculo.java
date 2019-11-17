public class VenderVehiculo implements GestionarVehiculos {

    @Override
    public void gestionarVehiculo(Vehiculo vehiculo, Listas lista) {
        if (lista.getVehiculosVendidos() < lista.getMaximoVehiculos()) {
            lista.getListaVendidos()[lista.getVehiculosVendidos()] = vehiculo;
        }
    }
}
