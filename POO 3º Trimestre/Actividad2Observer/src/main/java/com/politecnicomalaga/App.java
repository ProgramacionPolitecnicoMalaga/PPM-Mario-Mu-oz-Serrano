package com.politecnicomalaga;

import com.politecnicomalaga.consumidores.DiarioDeTemperaturas;
import com.politecnicomalaga.consumidores.PromedioDeTemperatura;
import com.politecnicomalaga.consumidores.RegistroDeTemperaturasCriticas;
import com.politecnicomalaga.sensor.SensorTemperatura;
import java.util.Timer;

public class App {
    public static void main(String[] args) {
        SensorTemperatura sensor = new SensorTemperatura();
        DiarioDeTemperaturas diarioDeTemperaturas = new DiarioDeTemperaturas();
        PromedioDeTemperatura promedioDeTemperatura = new PromedioDeTemperatura();
        RegistroDeTemperaturasCriticas registroDeTemperaturasCriticas = new RegistroDeTemperaturasCriticas();
        sensor.registrarConsumidor(diarioDeTemperaturas);
        sensor.registrarConsumidor(promedioDeTemperatura);
        sensor.registrarConsumidor(registroDeTemperaturasCriticas);
        Timer temporizador = new Timer();
        temporizador.schedule(sensor,0,5000);
    }
}