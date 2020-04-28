package com.politecnicomalaga.adapter;

import com.politecnicomalaga.modelo.Persona;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PersonaTableModel extends AbstractTableModel {

    private final static int COLUMNA_NOMBRE = 0;
    private final static int COLUMNA_APELLIDO = 1;
    private final static int COLUMNA_EDAD = 2;

    private ArrayList<Persona> personas;
    private final static String[] nombreColumnas = {"Nombre","Apellido","Edad"};

    public PersonaTableModel(ArrayList<Persona> personas){
        this.personas = personas;
    }

    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        switch(columna){
            case COLUMNA_NOMBRE:
                return personas.get(fila).getNombre();
            case COLUMNA_APELLIDO:
                return personas.get(fila).getApellido();
            case COLUMNA_EDAD:
                return personas.get(fila).getEdad();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case COLUMNA_NOMBRE:
            case COLUMNA_APELLIDO:
                return String.class;
            case COLUMNA_EDAD:
                return Integer.class;
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case COLUMNA_NOMBRE:
                personas.get(rowIndex).setNombre((String) aValue);
                break;
            case COLUMNA_APELLIDO:
                personas.get(rowIndex).setApellido((String) aValue);
                break;
            case COLUMNA_EDAD:
                personas.get(rowIndex).setEdad((int) aValue);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void removeRow(int row){
        personas.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void addRow(){
        personas.add(new Persona("","",0));
        fireTableDataChanged();
    }
}
