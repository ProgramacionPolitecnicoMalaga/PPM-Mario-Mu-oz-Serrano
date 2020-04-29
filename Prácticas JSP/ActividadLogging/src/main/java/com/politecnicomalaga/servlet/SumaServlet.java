package com.politecnicomalaga.servlet;

import com.politecnicomalaga.suma.Suma;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        name="suma",
        urlPatterns = {"/suma"}
)
public class SumaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Suma suma = new Suma();
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        //LoggingSuma.inicializar();
        Logger.getLogger(Suma.class.getName()).log(Level.INFO, "Los operandos recibidos son " + num1 + " y " + num2);
        int resultado = suma.sumar(num1, num2);
        Logger.getLogger(Suma.class.getName()).log(Level.INFO, "El resultado es " + resultado);
        req.setAttribute("resultado", resultado);
        RequestDispatcher vista = req.getRequestDispatcher("suma.jsp");
        vista.forward(req, resp);
    }
}
