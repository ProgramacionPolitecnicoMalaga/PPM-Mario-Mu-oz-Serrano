package com.politecnicomalaga.vista;
import com.politecnicomalaga.modelo.Item;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class ItemPanel extends JPanel implements ListCellRenderer<Item> {

    private JLabel lblAutor;
    private JLabel lblFecha;
    private JLabel lblTema;
    private JTextArea txtAreaTexto;
    private HashMap<Integer, Item> items = new HashMap<>();
    private int itemsIntroducidos = 0;

    public ItemPanel(){
        setLayout(new BorderLayout(10,10));

        lblAutor = new JLabel();
        lblFecha = new JLabel();
        lblTema = new JLabel();
        txtAreaTexto = new JTextArea();
        txtAreaTexto.setWrapStyleWord(true);
        txtAreaTexto.setLineWrap(true);

        Border margenAutorFecha = new EmptyBorder(10,10,0,10);
        Border margenTexto = new EmptyBorder(0,10,20,10);
        lblAutor.setBorder(margenAutorFecha);
        lblFecha.setBorder(margenAutorFecha);
        txtAreaTexto.setBorder(margenTexto);

        add(lblAutor, BorderLayout.WEST);
        add(lblFecha, BorderLayout.CENTER);
        add(lblTema, BorderLayout.NORTH);
        add(txtAreaTexto, BorderLayout.SOUTH);
    }

    public HashMap<Integer, Item> getItems() {
        return items;
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> jList, Item item, int i, boolean isSelected, boolean cellHasFocus) {

        lblAutor.setText(item.getAutor());
        lblFecha.setText(item.getFecha().toString());
        lblTema.setText(item.getTema());
        txtAreaTexto.setText(item.getTexto());
        txtAreaTexto.setSize(jList.getWidth(),Short.MAX_VALUE);
        items.put(itemsIntroducidos, item);
        itemsIntroducidos++;
        lblTema.setOpaque(true);

        if (isSelected){
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }

        switch (lblTema.getText()) {
            case "IT": lblTema.setBackground(Color.GREEN);
            break;
            case "Desarrollo": lblTema.setBackground(Color.CYAN);
            break;
            case "Mantenimiento": lblTema.setBackground(Color.ORANGE);
            break;
            case "General": lblTema.setBackground(Color.GRAY);
            break;
        }

        return this;

    }
}
