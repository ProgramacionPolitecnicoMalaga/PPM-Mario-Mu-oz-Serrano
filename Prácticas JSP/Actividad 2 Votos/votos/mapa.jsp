<%@ page import="com.google.gson.*" %>
<%@ page import="java.sql.*" %>
<%
    String result = "[";
    String json = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?serverTimezone=Europe/Madrid&useUnicode=yes&characterEncoding=UTF-8";
    String usuario = "remoto";
    String clave = "malagaserade2Bproximamente";
    Connection oConni = null;
    String grupo = "S21AW";
    try {
        Class.forName(driver);
        oConni = DriverManager.getConnection(url, usuario, clave);
        PreparedStatement stmtNOM = oConni.prepareStatement("SELECT ID, NICK, LAT, LON FROM USUARIOS WHERE GRUPO LIKE '%" + grupo + "%'");
        ResultSet rs = stmtNOM.executeQuery();
        while (rs.next()) {
            result += "{\"id\":\"" + rs.getString("ID") + "\", \"nick\":\"" + rs.getString("NICK") + "\", \"lat\":\"" + rs.getString("LAT") + "\", \"lon\":\"" + rs.getString("LON") + "\"},";
            //ResultSet rs2 = stmtNOM.executeQuery("SELECT SUM(VOTO) AS TOTAL_VOTOS FROM VOTOS WHERE IDVOTADO LIKE" + id + "GROUP BY IDVOTADO");
        }
        json = result.substring(0,result.length()-1);
        json += "]";
    } catch (Exception ignored) {
    }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
%>