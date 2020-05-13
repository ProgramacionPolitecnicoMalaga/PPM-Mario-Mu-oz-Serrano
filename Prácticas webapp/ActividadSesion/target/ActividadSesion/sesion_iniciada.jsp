<%@ page import="com.politecnicomalaga.modelo.Persona" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
    <%
        ArrayList<Persona> listaPersonas = (ArrayList<Persona>) request.getAttribute("listaPersonas");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (Persona persona: listaPersonas)
        out.println("<p>Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad() + ", Fecha: " + persona.getFecha().format(formatter) + "</p>");
    %>
