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
        // given hay cuatro participantes en la lista
        carrera.addParticipante("Mario");
        carrera.addParticipante("Pepe");
        carrera.addParticipante("Fran");
        carrera.addParticipante("Jose");

        // when se intenta insertar un participante repetido
        boolean resultado = carrera.addParticipante("Jose");

        // then el método addParticipante() devuelve false y el número de participantes sigue siendo 4
        assertFalse(resultado);
        assertEquals(4, carrera.getTotalParticipantes());
    }

    @Test
    public void testSetPosicionYGetParticipantePorPosicion() {
        // given el objeto wick se encuentra en segundo lugar
        String wick = "John Wick";
        carrera.addParticipante("Pepe");
        carrera.addParticipante(wick);

        // when se cambia la posicion del objeto wick a la posición 1
        carrera.setPosicion("John Wick", 1);

        // then el objeto obtenido mediante la llamada getParticipantePorPosicion(1) es el mismo que wick
        assertEquals(wick, carrera.getParticipantePorPosicion(1));
    }

    @Test
    public void clonarListadoParticipantes() {
        // given listas obtenidas por getListadoParticipantes() y por cloneCarrera()
        List listadoParticipantes = carrera.getListadoParticipantes();
        List listadoParticipantesClonado = carrera.cloneCarrera();

        // then los objetos no son los mismos
        assertNotEquals(listadoParticipantes, listadoParticipantesClonado);
    }

    @Test
    public void comprobarSetPosicion() {
        // given una carrera con 4 participantes
        carrera.addParticipante("Mario");
        carrera.addParticipante("Pepe");
        carrera.addParticipante("Fran");
        carrera.addParticipante("Jose");

        //when se obtiene la lista al principio de la carrera
        List listadoParticipantesInicial = carrera.getListadoParticipantes();

        //and se cambian varios participantes de posición
        carrera.setPosicion("Mario", 1);
        carrera.setPosicion("Fran", 3);
        carrera.setPosicion("Pepe", 2);

        //when se obtiene la lista después de cambiar las posiciones
        List listadoParticipantesFinal = carrera.getListadoParticipantes();

        // then las listas contienen los mismos elementos
        assertArrayEquals(listadoParticipantesInicial.toArray(), listadoParticipantesFinal.toArray());
    }
}