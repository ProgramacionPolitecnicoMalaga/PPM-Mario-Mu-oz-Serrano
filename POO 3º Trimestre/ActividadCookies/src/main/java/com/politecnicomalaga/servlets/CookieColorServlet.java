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
        name = "color",
        urlPatterns = {"/color"}
)
public class CookieColorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cadenaJsonResultado = "";
        String cadenaJson = req.getReader().lines().collect(Collectors.joining());
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject json = (JSONObject) jsonParser.parse(cadenaJson);
            String colorElegido = (String) json.get("color");

            Cookie color = new Cookie("color", colorElegido);
            resp.addCookie(color);

            cadenaJsonResultado = "{\"status\":\"ok\",\"color\":\"" + colorElegido + "\"}";
        } catch (Exception e) {
            cadenaJsonResultado = "{\"status\":\"ko\"}";
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(cadenaJsonResultado);
    }

}
