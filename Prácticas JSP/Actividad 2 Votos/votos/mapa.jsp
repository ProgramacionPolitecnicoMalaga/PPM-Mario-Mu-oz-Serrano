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
        PreparedStatement stmtNOM = oConni.prepareStatement("SELECT U.ID, U.NICK, U.LAT, U.LON, IFNULL(SUM(V.VOTO), 0) TOTAL FROM USUARIOS U LEFT JOIN VOTOS V ON U.ID = V.IDVOTADO WHERE U.GRUPO LIKE '%" + grupo + "%' GROUP BY U.ID");
        ResultSet rs = stmtNOM.executeQuery();
        while (rs.next()) {
            result += "{\"id\":\"" + rs.getString("ID") + "\", \"nick\":\"" + rs.getString("NICK") + "\", \"lat\":\"" + rs.getString("LAT") + "\", \"lon\":\"" + rs.getString("LON") + "\", \"total\":\"" + rs.getString("TOTAL") + "\"},";
        }
        json = result.substring(0,result.length()-1);
        json += "]";
    } catch (Exception ignored) {
    }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
%>