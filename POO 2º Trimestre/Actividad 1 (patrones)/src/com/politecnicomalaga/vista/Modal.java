package com.politecnicomalaga.vista;

import com.politecnicomalaga.modelo.Empleado;

import javax.swing.*;
import java.awt.event.*;

public class Modal extends JDialog {
    private JPanel panelMain;
    private JButton buttonAceptar;
    private JButton buttonCancelar;
    private JTextField textFieldID;
    private JTextField textFieldEdad;
    private JTextField textFieldNombre;
    private VistaEmpleados vistaPrincipal;

    public Modal(VistaEmpleados vistaPrincipal, int idEmpleado) {
        this.vistaPrincipal = vistaPrincipal;
        setContentPane(panelMain);
        setModal(true);
        getRootPane().setDefaultButton(buttonAceptar);
        if (idEmpleado!=-1) {
            Empleado empleado = vistaPrincipal.getControlador().getEmpleadoPorID(idEmpleado);
            textFieldID.setText(String.valueOf(empleado.getId()));
            textFieldNombre.setText(empleado.getNombre());
            textFieldEdad.setText(String.valueOf(empleado.getEdad()));
        }
        buttonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        panelMain.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (!textFieldID.getText().equals("")) {
            vistaPrincipal.getControlador().modificarEmpleado(textFieldID.getText(), textFieldNombre.getText(), textFieldEdad.getText());
        } else {
            vistaPrincipal.getControlador().crearEmpleado(textFieldNombre.getText(), Integer.parseInt(textFieldEdad.getText()));
        }
        vistaPrincipal.actualizarTabla();
        dispose();
    }

    private void onCancel() {
        dispose();
    }
}
