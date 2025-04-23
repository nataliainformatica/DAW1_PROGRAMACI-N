package es.avellaneda.webapp;



import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;

@WebServlet("/procesar")
public class ProcesarFormularioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<h2>Formulario procesado</h2>");
        resp.getWriter().println("<p>Nombre: " + nombre + "</p>");
        resp.getWriter().println("<p>Email: " + email + "</p>");
    }
}
