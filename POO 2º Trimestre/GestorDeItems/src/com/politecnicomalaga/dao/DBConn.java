package com.politecnicomalaga.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
    private final static String url = "jdbc:mysql://vps791322.ovh.net:3306/Items";
    private final static String usuario = "practicas";
    private final static String password = "antorcha";
    private Connection conn;

    public DBConn () {
        try {
            conn = DriverManager.getConnection(url, usuario, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet read (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeQuery();
    }

    public int create (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }

    public int delete (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }

}