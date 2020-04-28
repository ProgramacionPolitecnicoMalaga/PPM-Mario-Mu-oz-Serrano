<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Cervezas</title>
    </head>
    <body>
    <%
        PrintWriter printer = response.getWriter();
        printer.print("La opción es " + request.getParameter("color"));
        List<String> cervezas = (List) request.getAttribute("lista_cervezas");
        for (String cerveza: cervezas){
            printer.print("<br>prueba " + cerveza);
        }
    %>
    </body>
</html>