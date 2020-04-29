package com.politecnicomalaga.suma;

import java.util.logging.*;

public class Suma {

    public int sumar(int num1, int num2) {
        Logger.getLogger(Suma.class.getName()).log(Level.INFO, "a = " + num1 + "; b = " + num2);
        return num1 + num2;
    }
}
