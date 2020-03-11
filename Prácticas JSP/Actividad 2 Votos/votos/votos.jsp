<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.ParseException" %>
<%
    String mensaje;
    String voto = request.getParameter("voto");
    String id = request.getParameter("id");
    String result = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?serverTimezone=Europe/Madrid&useUnicode=yes&characterEncoding=UTF-8";
    String usuario = "remoto";
    String clave = "malagaserade2Bproximamente";
    Connection oConni = null;
    try {
        Class.forName(driver);
        oConni = DriverManager.getConnection(url, usuario, clave);
        PreparedStatement stmtTOT = oConni.prepareStatement("SELECT SUM(VOTO) FROM VOTOS WHERE IDVOTADO = ?;");
        PreparedStatement stmtVOTAR = oConni.prepareStatement("INSERT INTO VOTOS (IDVOTANTE, IDVOTADO, IP, VOTO) VALUES (?, ?, null, ?);");
        stmtVOTAR.setInt(1, 86);
        stmtVOTAR.setInt(2, Integer.parseInt(id));
        stmtVOTAR.setInt(3, Integer.parseInt(voto));
        stmtVOTAR.executeUpdate();
        stmtTOT.setInt(1, Integer.parseInt(id));
        ResultSet rs = stmtTOT.executeQuery();
        result = String.valueOf(rs);
        if (rs.next()) {
            String total = rs.getString("SUM(VOTO)");
            result = "{\"total\" : \"" + total + "\"}";
        } else {
            result = "{\"mensaje\" : \"No hay dato para ese nombre\"}";
        }
    } catch (Exception ex) {
        mensaje = ex.toString();
    } finally {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
        try {
            oConni.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
