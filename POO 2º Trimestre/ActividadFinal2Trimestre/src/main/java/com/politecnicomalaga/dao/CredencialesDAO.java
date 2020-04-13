package com.politecnicomalaga.dao;
import com.politecnicomalaga.modelo.Credencial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CredencialesDAO {
    private DBConn conn;
    private ArrayList<Credencial> listaCredenciales;

    public CredencialesDAO() throws SQLException {
        conn = new DBConn();
        listaCredenciales = getCredencialesDB();
    }

    public ArrayList<Credencial> getListaCredenciales() {
        return listaCredenciales;
    }

    public Credencial getCredencialPorNombre(String nombre) {
        for (Credencial credencial: listaCredenciales) {
            if (credencial.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                return credencial;
            }
        }
        return null;
    }

    public ArrayList<Credencial> getCredencialesDB() throws SQLException {
        ResultSet result = conn.read("SELECT nombre, hash, algoritmo, salt FROM credencial");
        ArrayList<Credencial> listaCredenciales = new ArrayList<>();
        while (result.next()) {
            listaCredenciales.add(new Credencial (result.getString("nombre"), result.getString("hash"), result.getString("algoritmo"), result.getString("salt")));
        }
        return listaCredenciales;
    }

    public void crear(Credencial credencial) throws SQLException {
        conn.create("INSERT INTO credencial(nombre, hash, algoritmo, salt) VALUES ('" + credencial.getNombre() + "','" + credencial.getHash() + "','" + credencial.getAlgoritmo() + "','" + credencial.getSalt() + "')");
        listaCredenciales.add(credencial);
    }

    public void borrar(Credencial credencial) throws SQLException {
        conn.delete("DELETE FROM credencial WHERE nombre = '" + credencial.getNombre() + "'");
        listaCredenciales.remove(credencial);
    }
}
