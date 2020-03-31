package com.politecnicomalaga.calculadora;

public class App {

    public static void main(String[] args) {
        Suma suma = new Suma();
        Resta resta = new Resta();
        Multiplicacion multiplicacion = new Multiplicacion();
        Division division = new Division();

        System.out.println(suma.sumar(12, 40));
        System.out.println(resta.restar(30, 15));
        System.out.println(multiplicacion.multiplicar(8, 4));
        System.out.println(division.dividir(100, 5));
    }
}
