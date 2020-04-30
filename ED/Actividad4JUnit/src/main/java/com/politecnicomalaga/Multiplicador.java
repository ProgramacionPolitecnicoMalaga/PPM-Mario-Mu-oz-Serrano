package com.politecnicomalaga;

public class Multiplicador {

    public int multiplicar(int x, int y) {
        if (x > 999) {
            throw new IllegalArgumentException("X debe ser menor que 1000");
        }
        return x * y;
    }
}
