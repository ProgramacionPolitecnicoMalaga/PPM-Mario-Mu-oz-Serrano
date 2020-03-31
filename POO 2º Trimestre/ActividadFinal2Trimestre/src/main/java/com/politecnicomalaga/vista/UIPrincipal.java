package com.politecnicomalaga.vista;
import com.politecnicomalaga.controlador.ControladorCredenciales;
import com.politecnicomalaga.modelo.Credencial;
import com.politecnicomalaga.modelo.Validacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UIPrincipal {
    private JPanel panelMain;
    private JButton validarButton;
    private JButton borrarButton;
    private JList listValidacion;
    private JList listNombres;
    private JButton registrarButton;
    private ControladorCredenciales controlador;
    private DataTransfer datos;
    private DefaultListModel<Validacion> modeloValidacion;

    private final static int DIALOGO_REGISTRO_CORRECTO = 1;
    private final static int DIALOGO_USUARIO_REPETIDO = 2;
    private final static int DIALOGO_DATOS_INCORRECTOS = 3;
    private final static int DIALOGO_SELECCIONA_USUARIO = 4;

    public UIPrincipal(ControladorCredenciales controlador) {
        this.controlador = controlador;
        actualizarListaNombres();
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datos = new DataTransfer();
                lanzarDialogo(new DialogoRegistrar(datos), e);
                String resultado = (String) datos.get("resultado");
                if (resultado.equals("correcto")) {
                    if (!controlador.existeUsuario((String) datos.get("nombre"))) {
                        controlador.crearCredencial((String) datos.get("nombre"), (String) datos.get("contraseña"), (String) datos.get("algoritmo"));
                        mostrarMensajeDialogo(DIALOGO_REGISTRO_CORRECTO, e);
                        actualizarListaNombres();
                    }
                    else mostrarMensajeDialogo(DIALOGO_USUARIO_REPETIDO, e);
                }
                else if (resultado.equals("incorrecto")) mostrarMensajeDialogo(DIALOGO_DATOS_INCORRECTOS, e);
            }
        });
        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datos = new DataTransfer();
                lanzarDialogo(new DialogoValidar(datos), e);
                String resultado = (String) datos.get("resultado");
                if (resultado.equals("correcto")) {
                    datos.put("controlador", controlador);
                    Validacion validacion = DataTransferAValidacion.transformar(datos);
                    modeloValidacion.addElement(validacion);
                }
                else if (resultado.equals("incorrecto")) mostrarMensajeDialogo(DIALOGO_DATOS_INCORRECTOS, e);
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listNombres.getSelectedValue()!=null) {
                    int respuesta = mostrarConfirmacionBorrado(e);
                    if (respuesta == JOptionPane.OK_OPTION) {
                        ArrayList<String> listaNombres = (ArrayList<String>) listNombres.getSelectedValuesList();
                        controlador.eliminarCredencial(listaNombres);
                        actualizarListaNombres();
                    }
                }
                else mostrarMensajeDialogo(DIALOGO_SELECCIONA_USUARIO, e);
            }
        });
    }

    public void lanzarDialogo(JDialog dialogo, ActionEvent e) {
        dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) e.getSource()));
        dialogo.pack();
        dialogo.setVisible(true);
    }

    public int mostrarConfirmacionBorrado(ActionEvent e) {
        return JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Borrar usuario/s seleccionado/s?");
    }

    public void mostrarMensajeDialogo(int tipo, ActionEvent e) {
        switch (tipo) {
            case DIALOGO_REGISTRO_CORRECTO:
                mensajeDialogo("Usuario registrado con éxito.", e);
                break;
            case DIALOGO_USUARIO_REPETIDO:
                mensajeDialogo("El usuario ya existe, elige otro nombre.", e);
                break;
            case DIALOGO_DATOS_INCORRECTOS:
                mensajeDialogo("No has introducido todos los datos.", e);
                break;
            case DIALOGO_SELECCIONA_USUARIO:
                mensajeDialogo("Selecciona uno o más usuarios.", e);
                break;
        }
    }

    public void mensajeDialogo(String mensaje, ActionEvent e) {
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), mensaje);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void actualizarListaNombres() {
        actualizar(controlador.getListaCredenciales());
    }

    public void actualizar(ArrayList<Credencial> listaCredenciales) {
        DefaultListModel<String> lstModel = new DefaultListModel<>();
        for (Credencial credencial : listaCredenciales) {
            lstModel.addElement(credencial.getNombre());
        }
        listNombres.setModel(lstModel);
    }

    private void createUIComponents() {
        listValidacion = new JList();
        modeloValidacion = new DefaultListModel<>();
        listValidacion.setModel(modeloValidacion);
        listValidacion.setCellRenderer(new ValidacionRender());
    }
}
