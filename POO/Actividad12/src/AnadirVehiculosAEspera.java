public class AnadirVehiculosAEspera implements GestionarVehiculos {

    @Override
    public void gestionarVehiculo(Vehiculo vehiculo, Listas lista) {
        if (lista.getVehiculosIntroducidosEspera() < lista.getMaximoVehiculos()) {
            lista.getListaEspera()[lista.getVehiculosIntroducidosEspera()] = vehiculo;
        }
    }
}
