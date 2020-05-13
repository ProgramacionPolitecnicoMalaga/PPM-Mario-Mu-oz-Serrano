<%@ page import="java.sql.*" %>
<%@ page import="com.google.gson.*" %>

<%
    //Recepción de parámetros
    String accion = request.getParameter("accion");
    String str = request.getParameter("str");
    String name = request.getParameter("name");
    String lastName = request.getParameter("lastName");
    String date = request.getParameter("date");
    String idEmpleado = request.getParameter("idEmpleado");
    int idParseado = 0;
    if (idEmpleado!=null) idParseado = Integer.parseInt(idEmpleado);

    String result = "";
    Integer items = 0;
    String html = "<table class='table'>" +
            "  <thead>" +
            "    <tr>" +
            "      <th scope='col'>Accion</th>" +
            "      <th scope='col'>#</th>" +
            "      <th scope='col'>Nombre</th>" +
            "      <th scope='col'>Apellidos</th>" +
            "      <th scope='col'>Fecha nacimiento</th>" +
            "    </tr>" +
            "  </thead><tbody>";

    //Conexión a la base de datos
    try {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://vps456458.ovh.net:3306/INMOLOSA?useUnicode=yes&characterEncoding=UTF-8";
        String usuario = "remoto";
        String clave = "malagaserade2Bproximamente";
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url, usuario, clave);
        Statement stmt = conexion.createStatement();

        switch (accion) {
            case "add":
                if (!name.equals("")&&!lastName.equals("")&&!date.equals("")) {
                    stmt.execute("INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, FECHA_NACIMIENTO) VALUES ('" + name + "', '" + lastName + "', '" + date + "')");
                }
                break;
            case "update":
                if (!name.equals("")) stmt.execute("UPDATE EMPLEADOS SET NOMBRE = '" + name + "' WHERE ID_EMPLEADO = " + idParseado);
                if (!lastName.equals("")) stmt.execute("UPDATE EMPLEADOS SET APELLIDOS = '" + lastName + "' WHERE ID_EMPLEADO = " + idParseado);
                if (!date.equals("")) stmt.execute("UPDATE EMPLEADOS SET FECHA_NACIMIENTO = '" + date + "' WHERE ID_EMPLEADO = " + idParseado);
                break;
            case "delete":
                stmt.execute("DELETE FROM EMPLEADOS WHERE ID_EMPLEADO = " + idParseado);
                break;
            case "read":
                ResultSet rs = stmt.executeQuery("SELECT ID_EMPLEADO,NOMBRE,APELLIDOS,FECHA_NACIMIENTO FROM EMPLEADOS WHERE NOMBRE LIKE '%" + str + "%'");
                while (rs.next()) {
                    items++;
                    html += "<tr id='" + rs.getString("ID_EMPLEADO") + "'><td><a href='javascript:Update(" + rs.getString("ID_EMPLEADO") + ")'><img src='icons/update.svg'></a>";
                    html += "<a href='javascript:Delete(" + rs.getString("ID_EMPLEADO") + ")' id='buttonDelete" + rs.getString("ID_EMPLEADO") + "'><img src='icons/delete.svg'></a></td>";
                    html += "<td>" + rs.getString("ID_EMPLEADO") + "</td>";
                    html += "<td>" + rs.getString("NOMBRE") + "</td>";
                    html += "<td>" + rs.getString("APELLIDOS") + "</td>";
                    html += "<td>" + rs.getString("FECHA_NACIMIENTO") + "</td></tr>";
                }
                break;
        }

        html += "</tboby></table>";
        result = "{\"status\":\"ok\",\"html\" : \"" + html + "\",\"items\":" + items + "}";

    } catch (Exception ex) {
        result = "{\"status\":\"ko\",\"mensaje\" : \"" + ex.toString() + "\"}";
    }

    //Generación de la salida
    String json = new Gson().toJson(result);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
%>