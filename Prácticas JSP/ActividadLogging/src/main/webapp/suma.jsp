<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.logging.Level" %>
<%@ page import="com.politecnicomalaga.suma.Suma" %><%--
  Created by IntelliJ IDEA.
  User: mario
  Date: 29/04/2020
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Suma</title>
</head>
<body>
<%
    PrintWriter printer = response.getWriter();
    printer.print("El resultado de la suma " + request.getParameter("num1") + " + " + request.getParameter("num2") + " es: ");
    printer.print(request.getAttribute("resultado"));
    Logger.getLogger(Suma.class.getName()).log(Level.INFO, "Esta aplicación es de Mario Muñoz Serrano");
%>
</body>
</html>
