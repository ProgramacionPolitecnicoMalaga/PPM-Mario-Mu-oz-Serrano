package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorMensajeria;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VistaEnvioMensajes {
    private JPanel panelEnvioMensajes;
    private JComboBox comboBoxDestinatarios;
    private JTextField textFieldTitulo;
    private JButton enviarButton;
    private JTextPane textPaneMensaje;
    private ControladorMensajeria controladorMensajeria;

    public VistaEnvioMensajes(ControladorMensajeria controladorMensajeria) {
        this.controladorMensajeria = new ControladorMensajeria();

        cargarFuentes();
        cargarDestinatarios();

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBoxDestinatarios.getSelectedIndex()!=0&&!textFieldTitulo.getText().equals("")&&!textPaneMensaje.getText().equals("")) {
                    controladorMensajeria.enviarMensaje(textFieldTitulo.getText(), textPaneMensaje.getText(), comboBoxDestinatarios.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "Mensaje enviado.");
                    textFieldTitulo.setText("");
                    textPaneMensaje.setText("");
                }
                else JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "Por favor, introduzca todos los datos.");
            }
        });

        panelEnvioMensajes.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                textFieldTitulo.setText("");
                textPaneMensaje.setText("");
                comboBoxDestinatarios.setSelectedIndex(0);
            }
        });
    }

    public void cargarFuentes() {
        textPaneMensaje.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        textPaneMensaje.setFont(new Font("Arial", Font.PLAIN, 16));
        textFieldTitulo.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        textFieldTitulo.setFont(new Font("Arial", Font.PLAIN, 16));
    }

    public void cargarDestinatarios() {
        comboBoxDestinatarios.addItem("Destinatarios");
        for (String remitente: controladorMensajeria.getListaRemitentes()) {
            comboBoxDestinatarios.addItem(remitente);
        }
    }

    public JPanel getPanel() {
        return panelEnvioMensajes;
    }

}
