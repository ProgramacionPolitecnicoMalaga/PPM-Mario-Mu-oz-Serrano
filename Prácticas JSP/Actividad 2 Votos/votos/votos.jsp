<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.ParseException" %>
<%
    String voto = request.getParameter("voto");
    int votoParseado = Integer.parseInt(voto);
    String id = request.getParameter("id");
    int idVotadoParseado = Integer.parseInt(id);
    String result = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?serverTimezone=Europe/Madrid&useUnicode=yes&characterEncoding=UTF-8";
    String usuario = "remoto";
    String clave = "malagaserade2Bproximamente";
    Connection oConni = null;
    try {
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        Statement stmt = conexion.createStatement();
        stmt.executeUpdate("INSERT INTO VOTOS (IDVOTANTE, IDVOTADO, VOTO) VALUES (" + 462 + "," + idVotadoParseado + "," + votoParseado + ")");
        ResultSet rs = stmt.executeQuery("SELECT IFNULL(SUM(VOTO), 0) TOTAL FROM VOTOS WHERE IDVOTADO =" + idVotadoParseado);

        while (rs.next()) {
            String total = rs.getString("TOTAL");
            result = "{\"total\" : \"" + total + "\"}";
        }
    } catch (Exception ignored) {
    }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
%>
