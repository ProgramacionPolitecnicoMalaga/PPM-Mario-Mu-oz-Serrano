<%@ page language="java" %>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.sql.*" %>
<%
    String nom = request.getParameter("term");
    String mensaje;
    ArrayList<Map> usuarios = new ArrayList<>();
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?serverTimezone=Europe/Madrid&useUnicode=yes&characterEncoding=UTF-8";
    String usuario = "remoto";
    String clave = "malagaserade2Bproximamente";
    Connection oConni = null;
    try {
        Class.forName(driver);
        oConni = DriverManager.getConnection(url, usuario, clave);
        PreparedStatement stmtNOM = oConni.prepareStatement("SELECT NOMAPE, ID FROM USUARIOS WHERE NOMAPE LIKE ?");
        stmtNOM.setString(1, nom+"%");
        ResultSet rs = stmtNOM.executeQuery();
        while (rs.next()) {
            Map<String, String> datosUsuario = new HashMap<>();
            String NOMAPE = rs.getString("NOMAPE");
            String id = rs.getString("ID");
            datosUsuario.put("value", NOMAPE);
            datosUsuario.put("id", id);
            usuarios.add(datosUsuario);
        }
    } catch (Exception ex) {
        mensaje = ex.toString();
    } finally {
        String json = new Gson().toJson(usuarios);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        try {
            oConni.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>