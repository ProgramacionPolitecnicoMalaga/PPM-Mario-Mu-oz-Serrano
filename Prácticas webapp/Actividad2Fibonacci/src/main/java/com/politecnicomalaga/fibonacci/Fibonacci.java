package com.politecnicomalaga.fibonacci;

public class Fibonacci {

    public int calcularEnesimo(int enesimo) {
        int x = 0;
        int n = 1;
        int y;
        for (int i=0; i<enesimo; i++) {
            y = x;
            x = y+n;
            n = y;
        }
        return n;
    }
}
