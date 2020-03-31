package com.politecnicomalaga.calculadora;
import org.apache.commons.math3.analysis.function.Divide;

public class Division {

    public double dividir(double a, double b) {
        Divide divide = new Divide();
        return divide.value(a, b);
    }
}
