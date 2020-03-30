package com.politecnicomalaga.dao;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
    Dotenv dotenv = Dotenv.configure().load();

    private String url = "jdbc:mysql://" + dotenv.get("DB_HOST") + dotenv.get("DB_NAME");
    private String usuario = dotenv.get("DB_USER");
    private String password = dotenv.get("DB_PASSWORD");
    private Connection conn;

    public DBConn () {
        try {
            conn = DriverManager.getConnection(url, usuario, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet read(String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeQuery();
    }

    public int create(String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }

    public int delete(String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }
}
