package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorMensajeria;
import com.politecnicomalaga.modelo.Mensaje;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VistaLecturaMensajes {
    private JPanel panelLecturaMensajes;
    private JList listRemitentes;
    private JEditorPane editorPaneMensaje;
    private JButton borrarButton;
    private ControladorMensajeria controladorMensajeria;

    public VistaLecturaMensajes(ControladorMensajeria controladorMensajeria) {
        this.controladorMensajeria = controladorMensajeria;
        editorPaneMensaje.setFont(new Font("Segoe UI", 0, 14));

        panelLecturaMensajes.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                cargarMensajes();
            }
        });

        panelLecturaMensajes.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent e) {
                editorPaneMensaje.setText("");
            }
        });

        listRemitentes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (listRemitentes.getSelectedValue()!=null) {
                    editorPaneMensaje.setText("");
                    Mensaje mensaje = controladorMensajeria.getMensaje(listRemitentes.getSelectedIndex());
                    editorPaneMensaje.setText("<h1 face=\"Arial\" color=\"#565656\">" + mensaje.getTitulo() + "</h1>\n<p face=\"#Arial\" color=\"#565656\">" + mensaje.getCuerpo() + "</p>");
                }
            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listRemitentes.getSelectedValue()!=null) {
                    int respuesta = JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Borrar mensaje/s seleccionados?");
                    if (respuesta == JOptionPane.OK_OPTION) {
                        controladorMensajeria.borrar(listRemitentes.getSelectedIndices());
                        editorPaneMensaje.setText("");
                        cargarMensajes();
                    }
                }
                else JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), "Seleccione uno o mas mensajes.");
            }
        });
    }

    public void cargarMensajes () {
        DefaultListModel<String> lstModel = new DefaultListModel<>();
        for (Mensaje mensaje : controladorMensajeria.getListaMensajes()) {
            lstModel.addElement(mensaje.getRemitente());
        }
        listRemitentes.setModel(lstModel);
    }

    public JPanel getPanel() {
        return panelLecturaMensajes;
    }
}
