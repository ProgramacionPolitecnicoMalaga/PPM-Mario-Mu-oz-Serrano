package com.politecnicomalaga.vista;
import javax.swing.*;
import java.awt.event.*;

public class DialogoValidar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldNombre;
    private JPasswordField passwordFieldContraseña;
    private DataTransfer datos;

    public DialogoValidar(DataTransfer datos) {
        this.datos = datos;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (!textFieldNombre.getText().equals("")&&passwordFieldContraseña.getPassword().length!=0) {
            datos.put("nombre", textFieldNombre.getText());
            datos.put("contraseña", new String(passwordFieldContraseña.getPassword()));
            datos.put("resultado", "correcto");
        }
        else datos.put("resultado", "incorrecto");
        dispose();
    }

    private void onCancel() {
        datos.put("resultado", "cancelado");
        dispose();
    }
}
