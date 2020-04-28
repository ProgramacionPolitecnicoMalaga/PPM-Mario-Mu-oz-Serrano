package com.politecnicomalaga;

import com.politecnicomalaga.modelo.ExpertoCerveza;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SugerenciaCervezaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExpertoCerveza experto = new ExpertoCerveza();
        List<String> recomendaciones = experto.getMarcas(req.getParameter("color"));
        req.setAttribute("lista_cervezas", recomendaciones);
        RequestDispatcher view = req.getRequestDispatcher("resultCerveza.jsp");
        view.forward(req, resp);
    }
}