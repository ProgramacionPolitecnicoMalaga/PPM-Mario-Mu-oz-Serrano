package com.politecnicomalaga.modelo;

public interface FuenteDeTemperaturas {

    void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas);
    void informarAConsumidores();
}
