package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.TemperaturasController;
import com.politecnicomalaga.modelo.ConsumidorDeTemperaturas;
import com.politecnicomalaga.modelo.InformeSensor;
import javax.swing.*;

public class VistaPromedioTemperaturas implements ConsumidorDeTemperaturas {
    private JPanel panelMain;
    private JLabel labelPromedio;
    private TemperaturasController temperaturasController;

    public VistaPromedioTemperaturas(TemperaturasController temperaturasController) {
        this.temperaturasController = temperaturasController;
        labelPromedio.setText("");
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public void setNuevaTemperatura(InformeSensor informeSensor) {
        labelPromedio.setText("El promedio de temperaturas es de " + informeSensor.getPromedioTemperaturas() + "ºC");
    }
}
