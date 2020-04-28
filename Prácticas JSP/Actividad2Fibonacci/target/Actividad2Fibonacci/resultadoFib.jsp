<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Fibonacci</title>
</head>
<body>
<%
    PrintWriter printer = response.getWriter();
    printer.print("El numero de la posición " + request.getParameter("num") + " es: ");
    printer.print(request.getAttribute("enesimo"));
%>
</body>
</html>