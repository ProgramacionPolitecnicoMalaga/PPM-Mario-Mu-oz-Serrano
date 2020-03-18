<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>
<%@ page import="org.apache.commons.fileupload.FileItem" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@ page import="org.apache.commons.fileupload.FileUploadException" %>
<%@ page import="java.util.List" %>
<%@ page import="java.security.MessageDigest" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="javaxt.io.Image" %>
<%@ page import="java.io.*" %>

<%
    String nick = "";
    String correo = "";
    String nomApe = "";
    String password = "";
    String fechaNac = "";
    String result = "";
    String lon = "";
    String lat = "";
    Image imagen;
    double[] gps;
    InputStream inputImagen = null;
    List<FileItem> items = null;
    try {
        items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
    } catch (FileUploadException e) {
        e.printStackTrace();
    }
    if (items != null) {
        for (FileItem item : items) {
            if (item.isFormField()) {
                String fieldname = item.getFieldName();
                String fieldvalue = item.getString("UTF-8");
                switch (fieldname) {
                    case "txtNick":
                        nick = fieldvalue;
                        break;
                    case "txtEmail":
                        correo = fieldvalue;
                        break;
                    case "txtNomApe":
                        nomApe = fieldvalue;
                        break;
                    case "txtPasswd":
                        password = fieldvalue;
                        break;
                    case "fechaNac":
                        fechaNac = fieldvalue;
                        break;
                }

            } else {
                //Recibir imagen y extraer localización
                inputImagen = item.getInputStream();
                imagen = new Image(inputImagen);
                gps = imagen.getGPSCoordinate();
                lon = String.valueOf(gps[0]);
                lat = String.valueOf(gps[1]);
                }
            }
    }

    //Encriptar clave
    byte[] newPassword = null;
    try {
        newPassword = MessageDigest.getInstance("SHA").digest(password.getBytes(StandardCharsets.UTF_8));
    } catch (NoSuchAlgorithmException ignored) {

    }
    password = Base64.getEncoder().encodeToString(newPassword);

        //Conexión a la base de datos
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://vps456458.ovh.net:3306/LOGINS?useUnicode=yes&characterEncoding=UTF-8";
            String usuario = "remoto";
            String clave = "malagaserade2Bproximamente";
            Class.forName(driver);
            Connection conexion = DriverManager.getConnection(url, usuario, clave);
            PreparedStatement stmt = null;

            String grupo = "S21AW";

            stmt = conexion.prepareStatement("INSERT INTO USUARIOS (NICK, CORREO, CLAVE, NOMAPE, LAT, LON, FOTO, FECHA_NACIMIENTO, GRUPO) VALUES ('" + nick + "', '" + correo + "', '" + password + "', '" + nomApe + "', '" + lat + "', '" + lon + "', '" + inputImagen + "', '" + fechaNac + "', '" + grupo + "')");
            stmt.executeUpdate();

            result = "{\"status\":\"ok\"}";

        } catch (Exception ex) {

            result = "{\"status\":\"ko\",\"mensaje\" : \"" + ex.toString() + "\"}";
        }

        //Generación de la salida
        String json = new Gson().toJson(result);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    %>