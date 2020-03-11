package com.politecnicomalaga.dao;
import com.politecnicomalaga.modelo.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

    private DBConn conn;

    public EmpleadoDAO() throws SQLException {
        conn = new DBConn();
    }

    public ArrayList<Empleado> obtenerLista (ResultSet result) throws SQLException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        while (result.next()) {
            listaEmpleados.add(new Empleado (result.getInt("id"), result.getString("nombre"), result.getInt("edad")));
        }
        return listaEmpleados;
    }

    public ArrayList<Empleado> buscarPorPatron (String nombre) throws SQLException {
        ResultSet result = conn.read("SELECT id, nombre, edad FROM Empleado WHERE nombre LIKE '%" + nombre + "%'");
        return obtenerLista(result);
    }

    public ArrayList<Empleado> getEmpleados() throws SQLException {
        ResultSet result = conn.read("SELECT id, nombre, edad FROM Empleado");
        return obtenerLista(result);
    }

    public Empleado buscarPorID (int id) throws SQLException {
        Empleado empleado = null;
        ResultSet result = conn.read("SELECT id, nombre, edad FROM Empleado WHERE id =" + id);
        while (result.next()) {
            empleado = new Empleado (result.getInt("id"), result.getString("nombre"), result.getInt("edad"));
        }
        return empleado;
    }

    private int insertar (String nombre, int edad) throws SQLException {
        return conn.create("INSERT INTO Empleado(nombre, edad) VALUES ('" + nombre + "','" + edad + "')");
    }

    public int crear (Empleado empleado) throws SQLException {
        return insertar(empleado.getNombre(), empleado.getEdad());
    }

    public void modificar (String idEmpleado, String nombreEmpleado, String edadEmpleado) throws SQLException {
        int idParseado = Integer.parseInt(idEmpleado);
        if (!nombreEmpleado.equals("")) conn.update("UPDATE Empleado SET nombre = '" + nombreEmpleado + "' WHERE id = " + idParseado);
        if (!edadEmpleado.equals("")) conn.update("UPDATE Empleado SET edad = " + Integer.parseInt(edadEmpleado) + " WHERE id = " + idParseado);
    }

    public int borrar (int[] idEmpleados) throws SQLException {
        String listaABorrar = "(";
        for (int i=0;i<idEmpleados.length;i++) {
            if (i != idEmpleados.length-1) {
                listaABorrar += idEmpleados[i] + ",";
            }
            else listaABorrar += idEmpleados[i];
        }
        listaABorrar += ")";
        return conn.delete("DELETE FROM Empleado WHERE id in " + listaABorrar);
    }
}
