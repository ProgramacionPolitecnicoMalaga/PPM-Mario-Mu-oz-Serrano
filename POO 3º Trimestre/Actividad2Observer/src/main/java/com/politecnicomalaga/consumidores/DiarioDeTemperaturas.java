package com.politecnicomalaga.consumidores;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DiarioDeTemperaturas implements ConsumidorDeTemperaturas {

    private TreeMap<LocalTime, Integer> temperaturasPorHoras;

    public DiarioDeTemperaturas() {
        temperaturasPorHoras = new TreeMap<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        temperaturasPorHoras.put(hora, temperatura);
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder("Diario de temperaturas de hoy:\n");
        Set<Map.Entry<LocalTime, Integer>> entries = temperaturasPorHoras.entrySet();
        entries.forEach( entry -> cadena.append("A las ").append(entry.getKey())
                .append(" se registró una temperatura de ")
                .append(entry.getValue()).append("ºC\n"));
        return cadena.toString();
        }
}
