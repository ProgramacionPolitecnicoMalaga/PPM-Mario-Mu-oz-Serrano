package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.TemperaturasController;
import com.politecnicomalaga.modelo.ConsumidorDeTemperaturas;
import com.politecnicomalaga.modelo.InformeSensor;
import javax.swing.*;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

public class VistaTemperaturasCriticas implements ConsumidorDeTemperaturas {
    private JPanel panelMain;
    private JList listCriticas;
    private DefaultListModel<String> lstModel;
    private TemperaturasController temperaturasController;

    public VistaTemperaturasCriticas(TemperaturasController temperaturasController) {
        this.temperaturasController = temperaturasController;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public void setNuevaTemperatura(InformeSensor informeSensor) {
        lstModel = new DefaultListModel<>();
        Set<Map.Entry<LocalTime, Integer>> entries = informeSensor.getTemperaturasCriticas().entrySet();
        entries.forEach( entry -> lstModel.addElement("A las " + entry.getKey() + " se registró una temperatura crítica de " + entry.getValue() + "ºC"));
        listCriticas.setModel(lstModel);
    }
}
