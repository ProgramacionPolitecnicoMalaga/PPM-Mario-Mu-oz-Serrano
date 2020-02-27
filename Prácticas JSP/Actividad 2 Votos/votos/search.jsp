<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>

<%
    String result = "[";
    String cadenaABuscar = request.getParameter("term");

    try {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?useUnicode=yes&characterEncoding=UTF-8";
        String usuario = "remoto";
        String clave = "malagaserade2Bproximamente";
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        Statement stmt = conexion.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT ID, NOMAPE FROM USUARIOS WHERE NOMAPE LIKE '%" + cadenaABuscar + "%'");
            while (rs.next()) {
                result += "{\"id\":\"" + rs.getString("ID") + "\", \"value\":\"" + rs.getString("NOMAPE") + "\"},";
            }

    } catch (Exception ignored) {

    }
    String json = result.substring(0,result.length()-1);
    json += "]";

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
%>