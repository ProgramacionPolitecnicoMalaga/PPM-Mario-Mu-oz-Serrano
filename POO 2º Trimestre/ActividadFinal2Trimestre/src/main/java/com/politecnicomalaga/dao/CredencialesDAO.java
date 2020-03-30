package com.politecnicomalaga.dao;
import com.politecnicomalaga.modelo.Credencial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CredencialesDAO {
    private DBConn conn;

    public CredencialesDAO() {
        conn = new DBConn();
    }

    public ArrayList<Credencial> obtenerLista (ResultSet result) throws SQLException {
        ArrayList<Credencial> listaCredenciales = new ArrayList<>();
        while (result.next()) {
            listaCredenciales.add(new Credencial (result.getInt("id"), result.getString("nombre"), result.getString("hash"), result.getString("algoritmo"), result.getString("salt")));
        }
        return listaCredenciales;
    }

    public ArrayList<Credencial> getItems() throws SQLException {
        ResultSet result = conn.read("SELECT id, nombre, hash, algoritmo, salt FROM credencial");
        return obtenerLista(result);
    }

    private int insertar (String nombre, String hash, String algoritmo, String salt) throws SQLException {
        return conn.create("INSERT INTO credencial(nombre, hash, algoritmo, salt) VALUES ('" + nombre + "','" + hash + "','" + algoritmo + "','" + salt + "')");
    }

    public int crear (Credencial credencial) throws SQLException {
        return insertar(credencial.getNombre(), credencial.getHash(), credencial.getAlgoritmo(), credencial.getSalt());
    }

    public int borrar (int idCredencial) throws SQLException {
        return conn.delete("DELETE FROM credencial WHERE id = " + idCredencial);
    }
}
