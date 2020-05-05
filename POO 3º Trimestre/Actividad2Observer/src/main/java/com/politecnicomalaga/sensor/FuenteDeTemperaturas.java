package com.politecnicomalaga.sensor;

import com.politecnicomalaga.consumidores.ConsumidorDeTemperaturas;

public interface FuenteDeTemperaturas {

    void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas);
    void informarAConsumidores();
}
