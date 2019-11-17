public class Listas {

    private Vehiculo[] listaEspera = new Vehiculo[maximoVehiculos];
    private Vehiculo[] listaSubasta = new Vehiculo[maximoVehiculos];
    private Vehiculo[] listaVendidos = new Vehiculo[maximoVehiculos];
    private Comprador[] listaCompradores = new Comprador[maximoVehiculos];
    private int vehiculosIntroducidosEspera = 0;
    private int vehiculosIntroducidosSubasta = 0;
    private int vehiculosVendidos = 0;
    private static final int maximoVehiculos = 100;
    private GestionarVehiculos gestorVehiculos;
    private boolean coincidencia = false;

    public Listas(){

    }

    public int getMaximoVehiculos(){
        return maximoVehiculos;
    }

    public Vehiculo[] getListaEspera(){
        return listaEspera;
    }

    public int getVehiculosIntroducidosEspera(){
        return vehiculosIntroducidosEspera;
    }

    public Vehiculo[] getListaSubasta(){
        return listaSubasta;
    }

    public int getVehiculosIntroducidosSubasta(){
        return vehiculosIntroducidosSubasta;
    }

    public Vehiculo[] getListaVendidos(){
        return listaVendidos;
    }

    public int getVehiculosVendidos() {
        return vehiculosVendidos;
    }


    public void obtenerListaEspera(){
        for (int i=0;i<vehiculosIntroducidosEspera;i++) {
            System.out.println(listaEspera[i]);
        }
    }

    public void obtenerListaSubasta(){
        for (int i=0;i<vehiculosIntroducidosSubasta;i++) {
            System.out.println(listaSubasta[i]);
        }
    }

    public void obtenerListaVendidos(){
        for (int i = 0; i< vehiculosVendidos; i++) {
            System.out.println("Vehículo vendido:");
            System.out.println(listaVendidos[i]);
            System.out.println("Comprado por:");
            System.out.println(listaCompradores[i]);
            System.out.println("Precio venta:");
            System.out.println(listaCompradores[i].getFechaCompra());
            System.out.println("Fecha venta:");
            System.out.println(listaCompradores[i].getFechaCompra());
            System.out.println("-----------------------------");
        }
    }

    public void obtenerListadoCompletoVehiculos(){
        if (vehiculosIntroducidosEspera>0){
            System.out.println("Listado de vehículos en espera:");
            obtenerListaEspera();
        }
        if (vehiculosIntroducidosSubasta>0) {
            System.out.println("Listado de vehículos en subasta:");
            obtenerListaSubasta();
        }
        if (vehiculosVendidos>0) {
            System.out.println("Listado de vehículos vendidos:");
            for (int i = 0; i < vehiculosVendidos; i++) {
                System.out.println(listaVendidos[i]);
            }
        }
    }

    public void anadirVehiculoAEspera(Vehiculo vehiculo){
        gestorVehiculos = new AnadirVehiculosAEspera();
        gestorVehiculos.gestionarVehiculo(vehiculo,this);
        vehiculosIntroducidosEspera++;
    }

    public void anadirVehiculoASubasta(Vehiculo vehiculo) {
        gestorVehiculos = new AnadirVehiculoASubasta();
        gestorVehiculos.gestionarVehiculo(vehiculo, this);
        vehiculosIntroducidosSubasta++;
        borrarVehiculoEnEspera(vehiculo);
    }

    public void venderVehiculo(Vehiculo vehiculo, Comprador comprador, double precio, String fecha) {
        gestorVehiculos = new VenderVehiculo();
        gestorVehiculos.gestionarVehiculo(vehiculo, this);

        if (vehiculosVendidos < maximoVehiculos) {
            listaCompradores[vehiculosVendidos] = comprador;
        }
        comprador.setPrecioCompra(precio);
        comprador.setFechaCompra(fecha);
        vehiculosVendidos++;
        borrarVehiculoEnSubasta(vehiculo);
    }

    public void borrarVehiculoEnEspera(Vehiculo vehiculo) {
        for (int i = 0; i < vehiculosIntroducidosEspera; i++) {
            if (coincidencia){
                listaEspera[i] = listaEspera[i+1];
            }
            if (vehiculo.getNumeroBastidor().equals(listaEspera[i].getNumeroBastidor())) {
                listaEspera[i] = listaEspera[i+1];
                coincidencia = true;
                vehiculosIntroducidosEspera--;
            }
        }
        coincidencia = false;
    }

    public void borrarVehiculoEnSubasta(Vehiculo vehiculo) {
        for (int i = 0; i < vehiculosIntroducidosSubasta; i++) {
            if (coincidencia){
                listaSubasta[i] = listaSubasta[i+1];
            }
            if (vehiculo.getNumeroBastidor().equals(listaSubasta[i].getNumeroBastidor())) {
                listaSubasta[i] = listaSubasta[i+1];
                coincidencia = true;
                vehiculosIntroducidosSubasta--;
            }
        }
        coincidencia = false;
    }
}
