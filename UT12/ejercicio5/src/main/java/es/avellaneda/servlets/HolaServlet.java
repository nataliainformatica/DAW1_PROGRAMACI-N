package es.avellaneda.servlets;


import jakarta.servlet.http.*;




import jakarta.servlet.annotation.WebServlet;


import java.io.IOException;

@WebServlet("/entrada")
public class HolaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Hola desde el Servlet</h1>");
    }

       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Hola desde el Servlet</h1>");
    }
}
