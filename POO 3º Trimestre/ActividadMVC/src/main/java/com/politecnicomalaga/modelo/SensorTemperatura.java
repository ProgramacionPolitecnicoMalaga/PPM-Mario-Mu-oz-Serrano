package com.politecnicomalaga.modelo;

import java.time.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class SensorTemperatura extends SensorTimerTask implements FuenteDeTemperaturas, InformeSensor{
    private int sensor;
    private Random aleatorio;
    private Instant inicio;
    private ArrayList<ConsumidorDeTemperaturas> consumidores;
    private TreeMap<LocalTime, Integer> registroDeTemperaturas;
    private TreeMap<LocalTime, Integer> temperaturasCriticas;
    private int promedioTemperaturas;
    private final static int UMBRAL_CRITICO = 150;

    public SensorTemperatura(){
        consumidores = new ArrayList<>();
        registroDeTemperaturas = new TreeMap<>();
        temperaturasCriticas = new TreeMap<>();
        aleatorio = new Random();
        inicio = Instant.now();
        promedioTemperaturas = 0;
    }

    public void nuevaLectura(){
        sensor = aleatorio.ints(40, 200).limit(1).findFirst().getAsInt();
        registroDeTemperaturas.put(LocalTime.now().withNano(0), sensor);
        if (sensor > UMBRAL_CRITICO)
            temperaturasCriticas.put(LocalTime.now().withNano(0), sensor);
        promedioTemperaturas = ((promedioTemperaturas*registroDeTemperaturas.size())+sensor)/(registroDeTemperaturas.size() + 1);
        informarAConsumidores();
    }

    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas) {
        consumidores.add(consumidorDeTemperaturas);
    }

    @Override
    public void informarAConsumidores() {
        for (ConsumidorDeTemperaturas consumidorDeTemperaturas: consumidores)
            consumidorDeTemperaturas.setNuevaTemperatura(this);
    }

    public int getPromedioTemperaturas() {
        return promedioTemperaturas;
    }

    public TreeMap<LocalTime, Integer> getTemperaturasPorHoras() {
        return registroDeTemperaturas;
    }

    public TreeMap<LocalTime, Integer> getTemperaturasCriticas() {
        return temperaturasCriticas;
    }
}