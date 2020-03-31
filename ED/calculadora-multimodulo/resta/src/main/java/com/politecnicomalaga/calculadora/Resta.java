package com.politecnicomalaga.calculadora;
import org.apache.commons.math3.analysis.function.Subtract;

public class Resta {

    public double restar(double a, double b) {
        Subtract subtract = new Subtract();
        return subtract.value(a, b);
    }
}
