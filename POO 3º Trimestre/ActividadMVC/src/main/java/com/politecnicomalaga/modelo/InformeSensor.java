package com.politecnicomalaga.modelo;

import java.time.LocalTime;
import java.util.TreeMap;

public interface InformeSensor {

    int getPromedioTemperaturas();

    TreeMap<LocalTime, Integer> getTemperaturasPorHoras();

    TreeMap<LocalTime, Integer> getTemperaturasCriticas();
}
