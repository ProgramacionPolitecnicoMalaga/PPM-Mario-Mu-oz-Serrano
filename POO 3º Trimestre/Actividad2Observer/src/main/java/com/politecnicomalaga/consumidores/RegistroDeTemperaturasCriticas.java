package com.politecnicomalaga.consumidores;

import java.time.LocalTime;
import java.util.ArrayList;

public class RegistroDeTemperaturasCriticas implements ConsumidorDeTemperaturas {
    private ArrayList<LocalTime> temperaturasCriticas;
    private final static int UMBRAL_CRITICO = 120;

    public RegistroDeTemperaturasCriticas() {
        temperaturasCriticas = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        if (temperatura > UMBRAL_CRITICO)
            temperaturasCriticas.add(hora);
    }

    @Override
    public String toString() {
        String cadena = "Las horas a las que se alcanzaron temperaturas críticas fueron:\n";
        for (LocalTime localTime: temperaturasCriticas)
            cadena += localTime + "\n";
        return cadena;
    }
}
