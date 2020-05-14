package com.politecnicomalaga.servlets;
import com.politecnicomalaga.modelo.Persona;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
@WebServlet(
        name="sesion",
        urlPatterns = {"/persona_servlet"}
)
public class PersonaServlet extends HttpServlet {
    private RequestDispatcher dispatcher = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        ArrayList<Persona> listaPersonas = (ArrayList<Persona>) sesion.getAttribute("listaPersonas");
        if (listaPersonas == null){
            dispatcher = req.getRequestDispatcher("sin_sesion.jsp");
        } else {
            req.setAttribute("listaPersonas", listaPersonas);
            dispatcher = req.getRequestDispatcher("sesion_iniciada.jsp");
        }
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesion = req.getSession();
        ArrayList<Persona> listaPersonas = (ArrayList<Persona>) sesion.getAttribute("listaPersonas");

        if (listaPersonas == null) listaPersonas = new ArrayList<>();
        String json = req.getReader().lines().collect(Collectors.joining());
        JSONParser parser = new JSONParser();
        try{
            JSONObject jsonRecibido = (JSONObject) parser.parse(json);
            String nombre = (String) jsonRecibido.get("nombre");
            int edad = Integer.parseInt((String) jsonRecibido.get("edad"));
            listaPersonas.add(new Persona(nombre,edad));
        } catch(Exception e){
            listaPersonas.add(new Persona("Nombre desconocido",0));
        }
        sesion.setAttribute("listaPersonas", listaPersonas);
        req.setAttribute("listaPersonas", listaPersonas);
        dispatcher = req.getRequestDispatcher("sesion_iniciada.jsp");
        dispatcher.forward(req,resp);
    }
}