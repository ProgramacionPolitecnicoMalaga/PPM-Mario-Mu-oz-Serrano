package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicadorTest {

    private Multiplicador multiplicador;

    @Before
    public void setUp() {
        multiplicador = new Multiplicador();
    }

    @Test (expected = IllegalArgumentException.class)
    public void probarExcepción() {
        multiplicador.multiplicar(1000, 2);
    }

    @Test
    public void multiplicar() {
        int resultadoEsperado = 16;
        int resultadoObtenido = multiplicador.multiplicar(8, 2);
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}