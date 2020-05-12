package com.politecnicomalaga.controlador;

import com.politecnicomalaga.modelo.*;
import com.politecnicomalaga.vista.VistaPrincipal;
import com.politecnicomalaga.vista.VistaPromedioTemperaturas;
import com.politecnicomalaga.vista.VistaTemperaturasCriticas;
import javax.swing.*;
import java.awt.*;

public class TemperaturasController {

    private VistaPrincipal vistaPrincipal;
    private VistaPromedioTemperaturas vistaPromedioTemperaturas;
    private VistaTemperaturasCriticas vistaTemperaturasCriticas;
    private SensorTemperatura sensorTemperatura;
    private JFrame frameVistaPrincipal;
    private JFrame frameVistaPromedio;
    private JFrame frameVistaCriticas;

    public TemperaturasController(SensorTemperatura sensorTemperatura) {
        this.sensorTemperatura = sensorTemperatura;
        vistaPrincipal = new VistaPrincipal(this);
        vistaPromedioTemperaturas = new VistaPromedioTemperaturas(this);
        vistaTemperaturasCriticas = new VistaTemperaturasCriticas(this);

        sensorTemperatura.registrarConsumidor(vistaPrincipal);
        sensorTemperatura.registrarConsumidor(vistaPromedioTemperaturas);
        sensorTemperatura.registrarConsumidor(vistaTemperaturasCriticas);

        frameVistaPrincipal = new JFrame("Vista principal");
        frameVistaPrincipal.setContentPane(vistaPrincipal.getPanelMain());
        frameVistaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameVistaPrincipal.setPreferredSize(new Dimension(500, 350));
        frameVistaPrincipal.pack();
        frameVistaPrincipal.setLocationRelativeTo(null);
        frameVistaPrincipal.setVisible(true);

        Point location = frameVistaPrincipal.getLocationOnScreen();
        frameVistaPromedio = new JFrame("Vista promedio de temperaturas");
        frameVistaPromedio.setContentPane(vistaPromedioTemperaturas.getPanelMain());
        frameVistaPromedio.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameVistaPromedio.setPreferredSize(new Dimension(500, 200));
        frameVistaPromedio.setLocationRelativeTo(frameVistaPrincipal);
        frameVistaPromedio.setLocation(location.x - frameVistaPrincipal.getWidth(), location.y);
        frameVistaPromedio.pack();
        frameVistaPromedio.setVisible(false);

        frameVistaCriticas = new JFrame("Vista registro de temperaturas críticas");
        frameVistaCriticas.setContentPane(vistaTemperaturasCriticas.getPanelMain());
        frameVistaCriticas.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameVistaCriticas.setPreferredSize(new Dimension(500, 350));
        frameVistaCriticas.setLocationRelativeTo(frameVistaPrincipal);
        frameVistaCriticas.setLocation(location.x + frameVistaPrincipal.getWidth(), location.y);
        frameVistaCriticas.pack();
        frameVistaCriticas.setVisible(false);
    }

    public void mostrarVistaPromedio() {
        frameVistaPromedio.setVisible(true);
    }

    public void mostrarVistaCriticas() {
        frameVistaCriticas.setVisible(true);
    }
}
