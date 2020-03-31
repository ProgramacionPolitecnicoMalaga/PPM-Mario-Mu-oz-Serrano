package com.politecnicomalaga.calculadora;
import org.apache.commons.math3.analysis.function.Multiply;

public class Multiplicacion {

    public double multiplicar(double a, double b) {
        Multiply multiply = new Multiply();
        return multiply.value(a, b);
    }
}
