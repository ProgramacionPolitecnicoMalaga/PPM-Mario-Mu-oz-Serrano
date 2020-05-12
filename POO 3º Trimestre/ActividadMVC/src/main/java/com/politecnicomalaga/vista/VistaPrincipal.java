package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.TemperaturasController;
import com.politecnicomalaga.modelo.ConsumidorDeTemperaturas;
import com.politecnicomalaga.modelo.InformeSensor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

public class VistaPrincipal implements ConsumidorDeTemperaturas{
    private JPanel panelMain;
    private JList listTemperaturas;
    private JButton críticasButton;
    private JButton promedioButton;
    private DefaultListModel<String> lstModel;
    private TemperaturasController temperaturasController;

    public VistaPrincipal(TemperaturasController temperaturasController) {
        this.temperaturasController = temperaturasController;

        promedioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temperaturasController.mostrarVistaPromedio();
            }
        });

        críticasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temperaturasController.mostrarVistaCriticas();
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    @Override
    public void setNuevaTemperatura(InformeSensor informeSensor) {
        lstModel = new DefaultListModel<>();
        Set<Map.Entry<LocalTime, Integer>> entries = informeSensor.getTemperaturasPorHoras().entrySet();
        entries.forEach( entry -> lstModel.addElement("A las " + entry.getKey() + " se registró una temperatura de " + entry.getValue() + "ºC"));
        listTemperaturas.setModel(lstModel);
    }
}
