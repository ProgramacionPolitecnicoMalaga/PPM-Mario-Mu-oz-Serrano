package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionMedidasTest {

    private ConversionMedidas conversionMedidas;
    private double resultadoEsperado;
    private double resultadoObtenido;

    @Before
    public void setUp() {
        conversionMedidas = new ConversionMedidas();
    }

    public void obtenerResultados(double esperado, double obtenido) {
        resultadoEsperado = esperado;
        resultadoObtenido = obtenido;
    }

    @Test
    public void inchACm() {
        obtenerResultados(2.54, conversionMedidas.inchACm(1));
        assertEquals(resultadoEsperado, resultadoObtenido, 0);

        obtenerResultados(30.48, conversionMedidas.inchACm(12));
        assertEquals(resultadoEsperado, resultadoObtenido, 0);
    }

    @Test
    public void cmAInch() {
        obtenerResultados(4.724409448818897, conversionMedidas.cmAInch(12));
        assertEquals(resultadoEsperado, resultadoObtenido, 0);

        obtenerResultados(0, conversionMedidas.cmAInch(0));
        assertEquals(resultadoEsperado, resultadoObtenido, 0);

        obtenerResultados(0.19685039370078738, conversionMedidas.cmAInch(0.5));
        assertEquals(resultadoEsperado, resultadoObtenido, 0);
    }
}