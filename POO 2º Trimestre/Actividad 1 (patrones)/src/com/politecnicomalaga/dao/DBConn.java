package com.politecnicomalaga.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
        private final static String url = "jdbc:mysql://vps791421.ovh.net:3306/Empleados";
        private final static String usuario = "empleadosuser";
        private final static String password = "Perro20";
        private Connection conn;

        public DBConn () {
            try {
                conn = DriverManager.getConnection(url, usuario, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public Connection getConn() {
        return conn;
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

    public int update (String consulta) throws SQLException {
        return conn.prepareStatement(consulta).executeUpdate();
    }
}
