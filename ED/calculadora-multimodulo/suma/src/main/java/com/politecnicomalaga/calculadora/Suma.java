package com.politecnicomalaga.calculadora;
import org.apache.commons.math3.stat.descriptive.summary.Sum;

public class Suma {

    public double sumar(double a, double b) {
        Sum sum = new Sum();
        return sum.evaluate(new double[] {a, b});
    }
}
