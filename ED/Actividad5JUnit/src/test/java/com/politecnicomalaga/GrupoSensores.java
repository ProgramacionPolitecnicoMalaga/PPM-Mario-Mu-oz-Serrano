package com.politecnicomalaga;

import org.mockito.ArgumentMatcher;

public class GrupoSensores implements ArgumentMatcher<Integer> {

    private Integer min;
    private Integer max;

    public GrupoSensores(int estado) {
        switch (estado) {
            case Sensor.NO_INICIADO:
                min=0;
                max=9;
                break;
            case Sensor.ESTADO_VACIO:
                min=10;
                max=19;
                break;
            case Sensor.ESTADO_CASI_VACIO:
                min=20;
                max=29;
                break;
            case Sensor.ESTADO_MITAD:
                min=30;
                max=39;
                break;
            case Sensor.ESTADO_CASI_LLENO:
                min=40;
                max=49;
                break;
            case Sensor.ESTADO_LLENO:
                min=50;
                max=59;
                break;
        }
    }

    @Override
    public boolean matches(Integer integer) {
        return (integer >= min) && (integer <= max);
    }
}
