package com.politecnicomalaga.vista;

import com.politecnicomalaga.adapter.PersonaTableModel;
import com.politecnicomalaga.modelo.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VistaTabla {
    private JPanel panelMain;
    private JButton borrarButton;
    private JButton printButton;
    private JButton insertarButton;
    private JTable tblPersonas;

    private ArrayList<Persona> personas;

    public VistaTabla(ArrayList<Persona> personas) {
        this.personas = personas;
        PersonaTableModel personaTableModel = new PersonaTableModel(personas);
        tblPersonas.setModel(personaTableModel);

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tblPersonas.getSelectedRow()!=-1) {
                    if (borradoConfirmado()) {
                        personaTableModel.removeRow(tblPersonas.getSelectedRow());
                    }
                }
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("---------------------------------");
                System.out.println("El estado actual de la lista es:\n");
                for (Persona persona: personas) System.out.println(persona);
                System.out.println("---------------------------------");
            }
        });

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personaTableModel.addRow();
            }
        });

        tblPersonas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE){
                    if (borradoConfirmado()){
                        tblPersonas.getCellEditor().stopCellEditing();
                        personaTableModel.removeRow(tblPersonas.getSelectedRow());
                    }
                }
            }
        });
    }

    public boolean borradoConfirmado() {
        int confirmaBorrar = JOptionPane.showConfirmDialog(panelMain, "¿Desea borrar la fila?", "Borrado", JOptionPane.WARNING_MESSAGE);
        return confirmaBorrar == JOptionPane.OK_OPTION;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
