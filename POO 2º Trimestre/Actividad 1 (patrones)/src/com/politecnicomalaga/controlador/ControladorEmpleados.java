package com.politecnicomalaga.controlador;
import com.politecnicomalaga.dao.EmpleadoDAO;
import com.politecnicomalaga.modelo.Empleado;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorEmpleados {

    EmpleadoDAO empleadoDAO;

    public ControladorEmpleados() {
        try {
            empleadoDAO = new EmpleadoDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        try {
            listaEmpleados = empleadoDAO.getEmpleados();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    public ArrayList<Empleado> getEmpleadosPorPatron(String patron) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        try {
            listaEmpleados = empleadoDAO.buscarPorPatron(patron);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    public Empleado getEmpleadoPorID(int id) {
        Empleado empleado = null;
        try {
            empleado = empleadoDAO.buscarPorID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }

    public void eliminar(int[] idEmpleados) {
        try {
            empleadoDAO.borrar(idEmpleados);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarEmpleado(String idEmpleado, String nombreEmpleado, String edadEmpleado) {
        System.out.println(edadEmpleado);
        try {
            empleadoDAO.modificar(idEmpleado, nombreEmpleado, edadEmpleado);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearEmpleado(String nombre, int edad) {
        try {
            empleadoDAO.crear(new Empleado(nombre, edad));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
