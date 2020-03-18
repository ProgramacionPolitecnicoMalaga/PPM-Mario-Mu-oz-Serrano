package com.politecnicomalaga.vista;
import com.politecnicomalaga.modelo.Item;
import com.politecnicomalaga.controlador.ControladorItems;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class VentanaPrincipal {
    private JPanel pnlMain;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private JList lstItems;
    private ControladorItems controladorItems;
    private ItemPanel itemPanel;
    private VentanaPrincipal estaVentana;

    public VentanaPrincipal(){
        estaVentana = this;
        controladorItems = new ControladorItems();
        actualizarPanel();

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Borrar item seleccionado?");
                if (respuesta == JOptionPane.OK_OPTION) {
                    Item item = itemPanel.getItems().get(lstItems.getSelectedIndex());
                    controladorItems.eliminarItem(item.getId());
                    actualizarPanel();
                }
            }
        });
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modal dialogo = new Modal(estaVentana);
                dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) e.getSource()));
                dialogo.pack();
                dialogo.setVisible(true);
            }
        });
    }

    public void actualizarPanel() {
        actualizar(controladorItems.getItems());
        }

    public void actualizar(ArrayList<Item> listaItems) {
        itemPanel = new ItemPanel();
        DefaultListModel<Item> lstModel = new DefaultListModel<>();
        for (Item item : listaItems) {
            lstModel.addElement(item);
            }

        lstItems.setModel(lstModel);
        lstItems.setCellRenderer(itemPanel);
        lstItems.setFixedCellWidth(pnlMain.getWidth());
        lstItems.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Estiramos la celda a 1000 px de altura
                lstItems.setFixedCellHeight(1000);
                // Asignamos el valor -1 para que se recalcule la altura
                lstItems.setFixedCellHeight(-1);
            }
        });
    }

    public Container getPanel() {
        return pnlMain;
    }

    public ControladorItems getControladorItems() {
        return controladorItems;
    }
}
