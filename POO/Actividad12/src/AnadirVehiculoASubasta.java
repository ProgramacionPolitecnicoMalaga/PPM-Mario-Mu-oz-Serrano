public class AnadirVehiculoASubasta implements GestionarVehiculos {

    @Override
    public void gestionarVehiculo(Vehiculo vehiculo, Listas lista) {
        if (lista.getVehiculosIntroducidosSubasta() < lista.getMaximoVehiculos()) {
            lista.getListaSubasta()[lista.getVehiculosIntroducidosSubasta()] = vehiculo;
        }
    }
}
