package com.politecnicomalaga.dao;

import com.politecnicomalaga.modelo.Mensaje;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensajesDAO {

    private DBConn conn;
    private ArrayList<Mensaje> listaMensajes;

    public MensajesDAO() {
        listaMensajes = new ArrayList<>();
        conn = new DBConn();
    }

    public ArrayList<Mensaje> getMensajes(int idReceptor) throws SQLException {
        ResultSet result = this.conn.read("SELECT m.id, m.titulo, m.cuerpo, m.id_receptor, c.nombre as nombre_remitente FROM mensaje m join credencial c on m.id_remitente = c.id where id_receptor =" + idReceptor);
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        while(result.next()) {
            mensajes.add(new Mensaje(result.getInt("id"), result.getString("titulo"), result.getString("cuerpo"), result.getInt("id_receptor"), result.getString("nombre_remitente")));
        }
        listaMensajes = mensajes;
        return listaMensajes;
    }

    public Mensaje getMensaje(int posicion) {
        return listaMensajes.get(posicion);
    }

    public void crear(Mensaje mensaje) throws SQLException {
        conn.create("INSERT INTO mensaje (titulo, cuerpo, id_receptor, id_remitente) VALUES ('" + mensaje.getTitulo() + "','" + mensaje.getCuerpo() + "','" + mensaje.getIdReceptor() + "', (SELECT id FROM credencial WHERE nombre = '" + mensaje.getRemitente() + "'))");
    }

    public void borrar(int[] posiciones) throws SQLException {
        String listaABorrar = "(";
        for (int i=0;i<posiciones.length;i++) {
            if (i != posiciones.length-1) {
                listaABorrar += listaMensajes.get(posiciones[i]).getId() + ",";
            }
            else listaABorrar += listaMensajes.get(posiciones[i]).getId();
        }
        listaABorrar += ")";
        conn.delete("DELETE FROM mensaje WHERE id in " + listaABorrar);
    }
}
