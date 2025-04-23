package es.avellaneda.webapp;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class ProcesarFormularioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String mensaje = req.getParameter("mensaje");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Datos recibidos</h2>");
        out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Mensaje:</strong> " + mensaje + "</p>");
    }
}
