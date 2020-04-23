package com.politecnicomalaga.controlador;

import com.politecnicomalaga.dao.MensajesDAO;
import com.politecnicomalaga.modelo.Credencial;
import com.politecnicomalaga.modelo.Mensaje;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorMensajeria {

    private Propiedades propiedades;
    private MensajesDAO mensajesDAO;
    private ControladorCredenciales controladorCredenciales;
    private Credencial usuarioLogeado;

    public ControladorMensajeria() {
        controladorCredenciales = new ControladorCredenciales();
        try {
            propiedades = new Propiedades();
            mensajesDAO = new MensajesDAO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getListaRemitentes() {
        ArrayList<String> listaRemitentes = new ArrayList<>();
        for (Credencial credencial: controladorCredenciales.getListaCredenciales()) {
            listaRemitentes.add(credencial.getNombre());
        }
        return listaRemitentes;
    }

    public ArrayList<Mensaje> getListaMensajes() {
        ArrayList<Mensaje> listaMensajes = new ArrayList<>();
        try {
            listaMensajes = mensajesDAO.getMensajes(usuarioLogeado.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMensajes;
    }

    public boolean usuarioGuardado() {
        return propiedades.getPropiedad("usuario") != null;
    }

    public boolean comprobarCredenciales (String nombre, String password) {
        return controladorCredenciales.comprobarCredenciales(nombre, password);
    }

    public boolean existeUsuario(String nombre) {
        return controladorCredenciales.existeUsuario(nombre);
    }

    public Mensaje getMensaje(int posicion) {
        return mensajesDAO.getMensaje(posicion);
    }

    public String getNombreUsuarioLogeado() {
        return usuarioLogeado.getNombre();
    }

    public void enviarMensaje(String titulo, String cuerpo, String nombreDestinatario) {
        Mensaje mensaje = new Mensaje(titulo, cuerpo, controladorCredenciales.getCredencialPorNombre(nombreDestinatario).getId(), usuarioLogeado.getNombre());
        try {
            mensajesDAO.crear(mensaje);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void borrar(int[] posiciones) {
        try {
            mensajesDAO.borrar(posiciones);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void logearUsuario(String nombreUsuario) {
        try {
            propiedades.setPropiedad("usuario", nombreUsuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
        usuarioLogeado = controladorCredenciales.getCredencialPorNombre(nombreUsuario);
    }

    public void deslogearUsuario() {
        try {
            propiedades.borrar();
        } catch (IOException e) {
            e.printStackTrace();
        }
        usuarioLogeado = null;
    }

    public void logearUsuarioGuardado() {
        usuarioLogeado = controladorCredenciales.getCredencialPorNombre(propiedades.getPropiedad("usuario"));
    }
}
