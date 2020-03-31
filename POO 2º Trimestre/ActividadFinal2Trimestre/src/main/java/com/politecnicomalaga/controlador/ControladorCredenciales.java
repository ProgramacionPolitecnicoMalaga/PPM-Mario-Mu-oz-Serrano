package com.politecnicomalaga.controlador;
import com.politecnicomalaga.algoritmos.Encriptador;
import com.politecnicomalaga.algoritmos.EncriptadorFactory;
import com.politecnicomalaga.dao.CredencialesDAO;
import com.politecnicomalaga.modelo.Credencial;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCredenciales {

    private CredencialesDAO credencialesDAO;
    private Encriptador encriptador;

    public final static String ALGORITMO_SHA512 = "SHA-512";
    public final static String ALGORITMO_BCRYPT = "BCRYPT";

    public ControladorCredenciales() {
        try {
            credencialesDAO = new CredencialesDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCredencial(ArrayList<String> nombresCredenciales) {
        for (String nombreCredencial: nombresCredenciales) {
            Credencial credencial = getCredencialPorNombre(nombreCredencial);
            try {
                credencialesDAO.borrar(credencial);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void crearCredencial(String nombre, String password, String algoritmo) {
        try {
            Credencial credencial = encriptarContraseña(password, algoritmo);
            credencial.setNombre(nombre);
            credencialesDAO.crear(credencial);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Credencial encriptarContraseña(String password, String algoritmo) {
        encriptador = EncriptadorFactory.obtenerEncriptador(algoritmo);
        return encriptador.crearContraseñaEncriptada(password);
    }

    public boolean comprobarCredenciales(String nombre, String password) {
        Credencial credencial = getCredencialPorNombre(nombre);
        encriptador = EncriptadorFactory.obtenerEncriptador(credencial.getAlgoritmo());
        return encriptador.comprobarContraseñaEncriptada(password, credencial);
    }

    public ArrayList<Credencial> getListaCredenciales() {
        return credencialesDAO.getListaCredenciales();
    }

    public Credencial getCredencialPorNombre(String nombre) {
        return credencialesDAO.getCredencialPorNombre(nombre);
    }

    public boolean existeUsuario(String nombre) {
        return getCredencialPorNombre(nombre) != null;
    }
}
