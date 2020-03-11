package com.politecnicomalaga.vista;
import com.politecnicomalaga.controlador.ControladorEmpleados;
import com.politecnicomalaga.modelo.Empleado;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaEmpleados {
    private JTextField txtPatron;
    private JButton buscarButton;
    private JTable tblEmpleados;
    private JPanel panelMain;
    private JButton modificarButton;
    private JButton borrarButton;
    private JButton crearButton;
    private ControladorEmpleados controlador;
    private VistaEmpleados estaVentana;

    public VistaEmpleados(ControladorEmpleados controlador) {
        estaVentana = this;
        this.controlador = controlador;
        actualizarTabla();
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patron = txtPatron.getText();
                actualizar(controlador.getEmpleadosPorPatron(patron));
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Borrar empleado/s seleccionados?");
                if (respuesta == JOptionPane.OK_OPTION) {
                    int[] filasSeleccionadas = tblEmpleados.getSelectedRows();
                    int[] idSABorrar = new int[filasSeleccionadas.length];

                    for (int i = 0; i < idSABorrar.length; i++) {
                        idSABorrar[i] = (int) tblEmpleados.getValueAt(filasSeleccionadas[i], 0);
                    }
                    controlador.eliminar(idSABorrar);
                    actualizarTabla();
                }
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modal dialogo = new Modal(estaVentana, (Integer) tblEmpleados.getValueAt(tblEmpleados.getSelectedRow(), 0));
                dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) e.getSource()));
                dialogo.pack();
                dialogo.setVisible(true);
            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modal dialogo = new Modal(estaVentana, -1);
                dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) e.getSource()));
                dialogo.pack();
                dialogo.setVisible(true);
            }
        });
    }

    public void actualizarTabla() {
        actualizar(controlador.getEmpleados());
    }

    public void actualizar(ArrayList<Empleado> listaEmpleados) {
        DefaultTableModel model = (DefaultTableModel) tblEmpleados.getModel();
        model.setRowCount(0);
        for (Empleado empleado : listaEmpleados) {
            Object[] row = {empleado.getId(), empleado.getNombre(), empleado.getEdad()};
            model.addRow(row);
        }
    }

    private void createUIComponents() {
        tblEmpleados = new JTable();
        Object[] columnas = {"id", "nombre", "edad"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnas);
        tblEmpleados.setModel(tableModel);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public ControladorEmpleados getControlador() {
        return controlador;
    }
}
