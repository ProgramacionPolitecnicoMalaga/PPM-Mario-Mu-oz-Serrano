package com.politecnicomalaga.dao;
import com.politecnicomalaga.modelo.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ItemDAO {

    private DBConn conn;

    public ItemDAO() {
        conn = new DBConn();
    }

    public ArrayList<Item> obtenerLista (ResultSet result) throws SQLException {
        ArrayList<Item> listaEmpleados = new ArrayList<>();
        while (result.next()) {
            listaEmpleados.add(new Item (result.getInt("id"), result.getString("autor"), result.getString("tema"), result.getDate("fecha").toLocalDate(), result.getString("texto")));
        }
        return listaEmpleados;
    }

    public ArrayList<Item> getItems() throws SQLException {
        ResultSet result = conn.read("SELECT id, autor, tema, fecha, texto FROM item");
        return obtenerLista(result);
    }

    private int insertar (String autor, String tema, LocalDate fecha, String texto) throws SQLException {
        return conn.create("INSERT INTO item(autor, tema, fecha, texto) VALUES ('" + autor + "','" + tema + "','" + fecha + "','" + texto + "')");
    }

    public int crear (Item item) throws SQLException {
        return insertar(item.getAutor(), item.getTema(), item.getFecha(), item.getTexto());
    }

    public int borrar (int idItem) throws SQLException {
        return conn.delete("DELETE FROM item WHERE id = " + idItem);
    }
}