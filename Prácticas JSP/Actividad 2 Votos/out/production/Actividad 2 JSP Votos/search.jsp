<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>

<%
    String result = "[";

    try {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?useUnicode=yes&characterEncoding=UTF-8";
        String usuario = "remoto";
        String clave = "malagaserade2Bproximamente";
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        Statement stmt = conexion.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT ID,NOMAPE FROM USUARIOS");

            String id = rs.getString("ID");
            String nombre = rs.getString("NOMAPE");
            result += "{\"id\" : \"" + id + "\",\"value\": \"" + nombre + "\"}";

        //result = "[{\"id\" : \"hola\",\"value\": \"hola\"}, {\"id\" : \"paco\",\"value\": \"sevilla\"}]";
         //result = result + "{\"status\":\"ok\"}";

    } catch (Exception ex) {
        //result = "{\"status\":\"ko\",\"mensaje\" : \"" + ex.toString() + "\"}";
    }
    result += "]";

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(result);
%>