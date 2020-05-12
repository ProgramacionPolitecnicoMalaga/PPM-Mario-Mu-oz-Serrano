package com.politecnicomalaga.servlets;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(
        name = "color_elegido",
        urlPatterns = {"/color_elegido"}
)
public class ColorElegidoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cadenaJsonResultado = "";
        String color = null;

        Cookie[] cookies = req.getCookies();
        if (cookies !=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("color")) color = cookie.getValue();
            }
            cadenaJsonResultado = "{\"status\":\"ok\",\"color\":\"" + color + "\"}";

        } else cadenaJsonResultado = "{\"status\":\"ko\"}";

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(cadenaJsonResultado);
    }

}