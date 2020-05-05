package com.politecnicomalaga.sensor;

import com.politecnicomalaga.consumidores.ConsumidorDeTemperaturas;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SensorTemperatura extends SensorTimerTask implements FuenteDeTemperaturas{
    private int sensor;
    private Random aleatorio;
    private Instant inicio;
    private List<ConsumidorDeTemperaturas> consumidores;

    public SensorTemperatura(){
        aleatorio = new Random();
        inicio = Instant.now();
        consumidores = new ArrayList<>();
    }

    public void nuevaLectura(){
        sensor = aleatorio.ints(40, 200).limit(1).findFirst().getAsInt();
        Instant ahora = Instant.now();
        Duration period = Duration.between(inicio,ahora);
        informarAConsumidores();
        System.out.println("--------------------------------------------");
        System.out.println("Lectura de temperatura: " + sensor +  "ºC (" + period.getSeconds() + " segundos desde el inicio)\n");
        for (ConsumidorDeTemperaturas consumidorDeTemperaturas: consumidores) {
            System.out.println(consumidorDeTemperaturas);
        }
    }

    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas) {
        consumidores.add(consumidorDeTemperaturas);
    }

    @Override
    public void informarAConsumidores() {
        for (ConsumidorDeTemperaturas consumidorDeTemperaturas: consumidores)
            consumidorDeTemperaturas.setNuevaTemperatura(sensor, LocalTime.now().withNano(0));
    }
}