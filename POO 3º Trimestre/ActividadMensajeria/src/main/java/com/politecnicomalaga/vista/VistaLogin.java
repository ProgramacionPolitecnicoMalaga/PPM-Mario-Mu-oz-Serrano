package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorMensajeria;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaLogin {
    private JPanel panelMain;
    private JTextField textFieldNombre;
    private JButton aceptarButton;
    private JPasswordField passwordFieldContraseña;
    private ControladorMensajeria controladorMensajeria;
    private Multipanel multipanel;

    public VistaLogin(ControladorMensajeria controladorMensajeria, VistaPrincipal vistaPrincipal) {
        this.controladorMensajeria = controladorMensajeria;
        this.multipanel = vistaPrincipal;

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textFieldNombre.getText().equals("") && passwordFieldContraseña.getPassword().length!=0) {
                    String usuario = textFieldNombre.getText();
                    String contraseña = new String(passwordFieldContraseña.getPassword());
                    if (controladorMensajeria.existeUsuario(usuario)) {
                        if (controladorMensajeria.comprobarCredenciales(usuario, contraseña)) {
                            controladorMensajeria.logearUsuario(usuario);
                            multipanel.notificarCambio(Multipanel.VISTA_LECTURA);
                        }
                        else mostrarMensajeDialogo(e, "Contraseña incorrecta.");
                    }
                    else mostrarMensajeDialogo(e, "No existe el usuario.");
                }
                else mostrarMensajeDialogo(e, "Has introducido datos incompletos.");
            }
        });
    }

    public void mostrarMensajeDialogo(ActionEvent e, String mensaje) {
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component)e.getSource()), mensaje);
    }

    public JPanel getPanel() {
        return panelMain;
    }
}
