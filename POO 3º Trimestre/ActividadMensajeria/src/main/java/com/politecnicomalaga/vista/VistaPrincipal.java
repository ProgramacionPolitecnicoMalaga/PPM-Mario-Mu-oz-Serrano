package com.politecnicomalaga.vista;

import com.politecnicomalaga.controlador.ControladorMensajeria;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipal implements Multipanel{
    private JPanel panelIntercambio;
    private JMenu menuAcciones;
    private JMenuItem itemVerMensajes;
    private JMenuItem itemEscribirMensajes;
    private JPanel panelMain;
    private JButton salirButton;
    private JLabel labelBienvenido;
    private ControladorMensajeria controladorMensajeria;
    private CardLayout layout;
    private VistaLogin vistaLogin;
    private VistaLecturaMensajes vistaLecturaMensajes;
    private VistaEnvioMensajes vistaEnvioMensajes;
    private JPanel pnlLogin;
    private JPanel pnlLecturaMensajes;
    private JPanel pnlEnvioMensajes;

    public VistaPrincipal() {
        controladorMensajeria = new ControladorMensajeria();
        vistaLogin = new VistaLogin(controladorMensajeria, this);
        vistaLecturaMensajes = new VistaLecturaMensajes(controladorMensajeria);
        vistaEnvioMensajes = new VistaEnvioMensajes(controladorMensajeria);
        cargarPaneles();

        if (controladorMensajeria.usuarioGuardado()) {
            controladorMensajeria.logearUsuarioGuardado();
            notificarCambio(Multipanel.VISTA_LECTURA);
        }

        itemVerMensajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificarCambio(Multipanel.VISTA_LECTURA);
            }
        });

        itemEscribirMensajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificarCambio(Multipanel.VISTA_ENVIO);
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorMensajeria.deslogearUsuario();
                labelBienvenido.setText("");
                notificarCambio(Multipanel.VISTA_LOGIN);
            }
        });
    }

    private void cargarPaneles() {
        pnlLogin = vistaLogin.getPanel();
        pnlLecturaMensajes = vistaLecturaMensajes.getPanel();
        pnlEnvioMensajes = vistaEnvioMensajes.getPanel();
        panelIntercambio.add(pnlLogin, "login");
        panelIntercambio.add(pnlLecturaMensajes, "lectura");
        panelIntercambio.add(pnlEnvioMensajes, "envio");
        layout = (CardLayout) panelIntercambio.getLayout();
    }

    public JPanel getpanelMain() {
        return panelMain;
    }

    public JButton getAceptarButton() {
        return vistaLogin.getAceptarButton();
    }

    @Override
    public void notificarCambio(int vista) {
        switch (vista) {
            case Multipanel.VISTA_LOGIN:
                layout.show(panelIntercambio, "login");
                break;
            case Multipanel.VISTA_LECTURA:
                layout.show(panelIntercambio, "lectura");
                labelBienvenido.setText("Bienvenid@ " + controladorMensajeria.getNombreUsuarioLogeado());
                break;
            case Multipanel.VISTA_ENVIO:
                layout.show(panelIntercambio, "envio");
                break;
        }
    }
}
