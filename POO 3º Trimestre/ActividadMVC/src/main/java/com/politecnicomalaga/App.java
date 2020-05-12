package com.politecnicomalaga;

import com.politecnicomalaga.controlador.TemperaturasController;
import com.politecnicomalaga.modelo.SensorTemperatura;
import java.util.Timer;

public class App {

    public static void main(String[] args) {
        SensorTemperatura sensorTemperatura = new SensorTemperatura();
        TemperaturasController temperaturasController = new TemperaturasController(sensorTemperatura);
        Timer temporizador = new Timer();
        temporizador.schedule(sensorTemperatura,0,5000);
    }
}