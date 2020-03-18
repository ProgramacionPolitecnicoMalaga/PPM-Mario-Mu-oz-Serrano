package com.politecnicomalaga.vista;
import com.politecnicomalaga.controlador.ControladorItems;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;

public class Modal extends JDialog {
    private JPanel pnlMain;
    private JButton buttonAceptar;
    private JButton buttonCancelar;
    private JTextField textFieldAutor;
    private JTextField textFieldTexto;
    private JComboBox comboBoxTema;
    private JTextField textFieldDia;
    private JTextField textFieldMes;
    private JTextField textFieldAño;
    private VentanaPrincipal ventanaPrincipal;

    public Modal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        setContentPane(pnlMain);
        setModal(true);
        getRootPane().setDefaultButton(buttonAceptar);
        añadirTemas();

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

        pnlMain.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        int año = Integer.parseInt(textFieldAño.getText());
        int mes = Integer.parseInt(textFieldMes.getText());
        int dia = Integer.parseInt(textFieldDia.getText());
        String tema = ControladorItems.getTema(comboBoxTema.getSelectedIndex());
        ventanaPrincipal.getControladorItems().crearItem(textFieldAutor.getText(), tema, LocalDate.of(año, mes, dia), textFieldTexto.getText());
        ventanaPrincipal.actualizarPanel();
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void añadirTemas() {
        comboBoxTema.addItem("Selecciona tema");
        comboBoxTema.addItem(ControladorItems.getTema(ControladorItems.TEMA_IT));
        comboBoxTema.addItem(ControladorItems.getTema(ControladorItems.TEMA_DESARROLLO));
        comboBoxTema.addItem(ControladorItems.getTema(ControladorItems.TEMA_MANTENIMIENTO));
        comboBoxTema.addItem(ControladorItems.getTema(ControladorItems.TEMA_GENERAL));
    }
}
