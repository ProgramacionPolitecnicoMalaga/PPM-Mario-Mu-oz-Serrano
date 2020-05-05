package com.politecnicomalaga.consumidores;

import java.time.LocalTime;

public class PromedioDeTemperatura implements ConsumidorDeTemperaturas {
    private int promedioTemperaturas;
    private int numeroTemperaturas;

    public PromedioDeTemperatura(){
        promedioTemperaturas = 0;
        numeroTemperaturas = 0;
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        promedioTemperaturas = ((promedioTemperaturas*numeroTemperaturas)+temperatura)/(numeroTemperaturas + 1);
        numeroTemperaturas++;
    }

    @Override
    public String toString() {
        return "Promedio de temperaturas de hoy: " + promedioTemperaturas + "ºC\n";
    }
}
