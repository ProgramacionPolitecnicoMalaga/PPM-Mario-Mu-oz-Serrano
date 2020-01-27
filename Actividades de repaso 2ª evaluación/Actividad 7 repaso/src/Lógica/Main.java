package Lógica;

import Datos.*;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GestionDeVehiculos gestorDeVehiculos = new GestionDeVehiculos();

        Vehiculo coche1 = new VehiculoTerrestre("19/04/1990", "11/05/2019", "43242454P", "2435ACF" , "Coche",3.8, 3.0,5);
        Vehiculo camion1 = new VehiculoTerrestre("12/03/1995", "12/06/2019", "41233454L", "2345HZJ" ,"Camion",3.2, 4,10);
        Vehiculo barco1 = new VehiculoMaritimo("05/09/1991", "14/08/2019", "543654554T", "Barco" ,"Barco" ,6.5, 2.2,8);

        System.out.println("-----------------------------");
        System.out.println("Introducir nuevos vehículos en el depósito y listarlos.");
        System.out.println("-----------------------------");
        gestorDeVehiculos.añadirVehiculoDeposito(coche1);
        gestorDeVehiculos.añadirVehiculoDeposito(camion1);
        gestorDeVehiculos.añadirVehiculoDeposito(barco1);
        listaVehiculos(gestorDeVehiculos.getDeposito());

        System.out.println("-----------------------------");
        System.out.println("Poner en subasta algunos vehículos y listarlos.");
        System.out.println("-----------------------------");
        gestorDeVehiculos.añadirVehiculoSubasta(coche1);
        gestorDeVehiculos.añadirVehiculoSubasta(camion1);
        gestorDeVehiculos.añadirVehiculoSubasta(barco1);
        listaVehiculos(gestorDeVehiculos.getListaSubasta());

        System.out.println("-----------------------------");
        System.out.println("Registrar compradores autorizados.");
        System.out.println("-----------------------------");
        Comprador comprador1 = new PersonaFisica("Manuel","Dominguez","3423424N","C/blabla 23561","DNI");
        Comprador comprador2 = new PersonaFisica("Mario","Muñoz","25784845M","C/falsa 123","DNI");
        Comprador comprador3 = new PersonaJuridica("Persona Juridica 2","4357823L","S.A");

        System.out.println("-----------------------------");
        System.out.println("Vender vehículos a compradores y listarlos.");
        System.out.println("-----------------------------");
        gestorDeVehiculos.venderVehiculo(coche1, comprador1, 20000, "19/04/2016");
        gestorDeVehiculos.venderVehiculo(camion1, comprador2, 25000, "19/05/2013");
        gestorDeVehiculos.venderVehiculo(barco1, comprador3, 22000, "19/06/2014");
        listaVehiculos(gestorDeVehiculos.getDeposito());
        listaVehiculos(gestorDeVehiculos.getListaSubasta());
        listaVehiculos(gestorDeVehiculos.getListaVendidos());
    }

    public static void listaVehiculos(List list) {
        Iterator<Vehiculo> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println("======================");
        }
    }
}