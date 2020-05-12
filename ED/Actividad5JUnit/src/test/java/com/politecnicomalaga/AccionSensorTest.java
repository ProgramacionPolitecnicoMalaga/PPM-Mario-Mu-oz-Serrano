package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.*;

public class AccionSensorTest {

    private MatrizSensores matrizSensores;

    @Before
    public void setUp() {
        matrizSensores = mock(MatrizSensores.class);
        GrupoSensores grupoSensoresNoIniciados = new GrupoSensores(Sensor.NO_INICIADO);
        GrupoSensores grupoSensoresVacios = new GrupoSensores(Sensor.ESTADO_VACIO);
        GrupoSensores grupoSensoresCasiVacios = new GrupoSensores(Sensor.ESTADO_CASI_VACIO);
        GrupoSensores gruposSensoresMitad = new GrupoSensores(Sensor.ESTADO_MITAD);
        GrupoSensores grupoSensoresCasiLlenos = new GrupoSensores(Sensor.ESTADO_CASI_LLENO);
        GrupoSensores grupoSensoresLlenos = new GrupoSensores(Sensor.ESTADO_LLENO);

        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresVacios))).thenReturn(Sensor.ESTADO_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresCasiVacios))).thenReturn(Sensor.ESTADO_CASI_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(gruposSensoresMitad))).thenReturn(Sensor.ESTADO_MITAD);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresCasiLlenos))).thenReturn(Sensor.ESTADO_CASI_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(grupoSensoresLlenos))).thenReturn(Sensor.ESTADO_LLENO);
        doThrow(IllegalStateException.class).when(matrizSensores).getEstadoSensor(intThat(grupoSensoresNoIniciados));
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaBaja() {
        // given
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_BAJA);

        // Si getEstadoSensor genera una excepción, devuelve la acción ACCION_REVISION
        // when
        int resultadoEsperado = AccionSensor.ACCION_REVISION;
        int resultadoObtenido = accionSensor.evaluar(7);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_VACIO devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(12);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTAD_CASI_VACIO, devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(25);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // En cualquier otro caso, devuelve la acción ACCION_INNECESARIA
        // when
        resultadoEsperado = AccionSensor.ACCION_INNECESARIA;
        resultadoObtenido = accionSensor.evaluar(35);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaMedia() {
        // given
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_MEDIA);

        // Si getEstadoSensor genera una excepción, devuelve la acción ACCION_REVISION
        // when
        int resultadoEsperado = AccionSensor.ACCION_REVISION;
        int resultadoObtenido = accionSensor.evaluar(5);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_VACIO devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(15);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_CASI_VACIO, devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(24);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_MEDIO, devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(38);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // En cualquier otro caso, devuelve la acción ACCION_INNECESARIA
        // when
        resultadoEsperado = AccionSensor.ACCION_INNECESARIA;
        resultadoObtenido = accionSensor.evaluar(58);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaAlta() {
        // given
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_ALTA);

        // Si getEstadoSensor genera una excepción, devuelve la acción ACCION_REVISION
        // when
        int resultadoEsperado = AccionSensor.ACCION_REVISION;
        int resultadoObtenido = accionSensor.evaluar(1);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_VACIO devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(18);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_CASI_VACIO, devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(22);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_MEDIO, devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(37);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // Si getEstadoSensor devuelve ESTADO_CASI_LLENO, devuelve la acción ACCION_REPOSICION
        // when
        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(44);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);

        // En cualquier otro caso, devuelve la acción ACCION_INNECESARIA
        // when
        resultadoEsperado = AccionSensor.ACCION_INNECESARIA;
        resultadoObtenido = accionSensor.evaluar(50);

        // then
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}