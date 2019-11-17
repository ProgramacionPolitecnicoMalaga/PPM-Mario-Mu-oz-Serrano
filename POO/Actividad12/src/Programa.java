public class Programa {

    public static void main(String[] args) {
        Listas lista = new Listas();

        Vehiculo coche1 = new VehiculoTerrestre("19/04/1990", "11/05/2019", "43242454P", "Mazda 6" ,3.8, 3.0,5);
        Vehiculo coche2 = new VehiculoTerrestre("12/03/1995", "12/06/2019", "41233454L", "Toyota Auris" ,3.2, 2.7,4);
        Vehiculo coche3 = new VehiculoTerrestre("21/05/1996", "14/07/2019", "55568454M", "Toyota Corolla" ,3.7, 2.6,4);
        Vehiculo barco1 = new Barco("05/09/1991", "14/08/2019", "543654554T", "Barco1" ,6.5, 2.2,8);
        Vehiculo barco2 = new Barco("13/12/2016", "15/05/2019", "516369454R", "Barco2" ,7.2, 3.5,13);
        Vehiculo barco3 = new Barco("15/07/2013", "16/05/2019", "246545654S", "Barco3" ,8.9, 4.5,12);

        Comprador comprador1 = new CompradorPersonaFisica("Manuel","Dominguez","3423424N","C/blabla 23561","NIF");
        Comprador comprador2 = new CompradorPersonaFisica("Mario","Muñoz","25784845M","C/falsa 123","NIE");
        Comprador comprador3 = new CompradorPersonaJuridica("Persona Juridica 1","2313132G","SL");
        Comprador comprador4 = new CompradorPersonaJuridica("Persona Juridica 2","4357823L","SA");

        System.out.println("-----------------------------");
        System.out.println("Introducir nuevos vehículos en el depósito:");
        System.out.println("-----------------------------");
        lista.anadirVehiculoAEspera(coche1);
        lista.anadirVehiculoAEspera(coche2);
        lista.anadirVehiculoAEspera(coche3);
        lista.anadirVehiculoAEspera(barco1);
        lista.anadirVehiculoAEspera(barco2);
        lista.anadirVehiculoAEspera(barco3);
        lista.obtenerListaEspera();
        System.out.println("-----------------------------");
        System.out.println("Poner en subasta algunos vehículos:");
        System.out.println("-----------------------------");
        lista.anadirVehiculoASubasta(coche2);
        lista.anadirVehiculoASubasta(coche3);
        lista.anadirVehiculoASubasta(barco1);
        lista.anadirVehiculoASubasta(barco2);
        lista.obtenerListaSubasta();
        System.out.println("-----------------------------");
        System.out.println("Vender vehículos a compradores y listarlos: ");
        System.out.println("-----------------------------");
        lista.venderVehiculo(coche2, comprador1, 20.000, "19/04/2016");
        lista.venderVehiculo(coche3, comprador2, 25.000, "19/05/2013");
        lista.venderVehiculo(barco1, comprador3, 22.000, "19/06/2014");
        lista.venderVehiculo(barco2, comprador4, 21.000, "19/07/2011");
        lista.obtenerListaVendidos();
        System.out.println("Listado completo de vehículos: ");
        System.out.println("-----------------------------");
        lista.obtenerListadoCompletoVehiculos();
    }
}
