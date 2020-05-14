package com.politecnicomalaga.servlet;

import com.politecnicomalaga.fibonacci.Fibonacci;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        name="fibonacci",
        urlPatterns = {"/fibonacci"}
)
public class FibonacciServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Fibonacci fibonacci = new Fibonacci();
        int enesimo = Integer.parseInt(req.getParameter("num"));
        int enesimoCalculado = fibonacci.calcularEnesimo(enesimo);
        req.setAttribute("enesimo", enesimoCalculado);
        RequestDispatcher vista = req.getRequestDispatcher("resultadoFib.jsp");
        vista.forward(req, resp);
    }

}
