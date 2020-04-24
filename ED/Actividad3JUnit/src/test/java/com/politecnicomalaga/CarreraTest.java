package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class CarreraTest {

    private Carrera carrera;

    @Before
    public void setUp() {
        carrera = new Carrera();
    }

    @After
    public void tearDown() {
        carrera.cerrarListaParticipantes();
    }

    @Test
    public void listadoParticipantes_noContieneNingunParticipante_EsNull() {
        assertNull(carrera.getListadoParticipantes());
    }

    @Test
    public void listadoParticipantes_contieneAlgunParticipante_NoEsNull() {
        carrera.addParticipante("Mario");
        assertNotNull(carrera.getListadoParticipantes());
    }

    @Test
    public void addParticipante_permiteAñadir4ParticipantesDiferentes() {
        assertTrue(carrera.addParticipante("Mario"));
        assertTrue(carrera.addParticipante("Pepe"));
        assertTrue(carrera.addParticipante("Fran"));
        assertTrue(carrera.addParticipante("Jose"));
    }

    @Test
    public void insertarParticipanteRepetido() {
        // given
        carrera.addParticipante("Mario");
        carrera.addParticipante("Pepe");
        carrera.addParticipante("Fran");
        carrera.addParticipante("Jose");

        // when
        boolean resultado = carrera.addParticipante("Jose");

        // then
        assertFalse(resultado);
        assertEquals(4, carrera.getTotalParticipantes());
    }

    @Test
    public void testSetPosicionYGetParticipantePorPosicion() {
        // given
        String wick = "John Wick";
        carrera.addParticipante("Pepe");
        carrera.addParticipante(wick);

        // when
        carrera.setPosicion("John Wick", 1);

        // then
        assertEquals(wick, carrera.getParticipantePorPosicion(1));
    }

    @Test
    public void clonarListadoParticipantes() {
        // given
        List listadoParticipantes = carrera.getListadoParticipantes();
        List listadoParticipantesClonado = carrera.cloneCarrera();

        // then
        assertNotEquals(listadoParticipantes, listadoParticipantesClonado);
    }

    @Test
    public void comprobarSetPosicion() {
        // given
        carrera.addParticipante("Mario");
        carrera.addParticipante("Pepe");
        carrera.addParticipante("Fran");
        carrera.addParticipante("Jose");

        // when
        List listadoParticipantesInicial = carrera.getListadoParticipantes();

        // and
        carrera.setPosicion("Mario", 1);
        carrera.setPosicion("Fran", 3);
        carrera.setPosicion("Pepe", 2);

        // when
        List listadoParticipantesFinal = carrera.getListadoParticipantes();

        // then
        assertArrayEquals(listadoParticipantesInicial.toArray(), listadoParticipantesFinal.toArray());
    }
}