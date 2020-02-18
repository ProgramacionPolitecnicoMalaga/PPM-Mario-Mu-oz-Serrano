<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Curso</title>
</head>
<body>
<h1>Respuesta del servidor</h1>
<form action="formulario.html" method="POST">
    <input type="submit" value="Volver al formulario" />
</form>
<%
    String nombre = request.getParameter("txtNombre");
    String apellidos = request.getParameter("txtApellidos");
    String edad = request.getParameter("setEdad");
    String sexo = request.getParameter("setSexo");
    String txtarea = request.getParameter("txtObservaciones");

    out.println("<br>Nombre: " + nombre);
    out.println("<br>Apellidos: " + apellidos);
    out.println("<br>Edad: " + edad);
    out.println("<br>Sexo: " + sexo);
    out.println("<br>Observaciones: " + txtarea);
%>
</body>
</html>