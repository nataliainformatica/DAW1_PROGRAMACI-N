package es.avellaneda.servlets;

import jakarta.servlet.http.*;
import es.avellaneda.exceptions.NotRegisteredException;
import es.avellaneda.model.Cancion;
import es.avellaneda.model.DAOcancion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>AHORA A COMENZAR EL TRABAJO</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Parámetros
     
        String  titulo;
        Cancion cancion;

        titulo = request.getParameter("titulo");

        // buscar la canción en la bbdd
        try {
            if((cancion = DAOcancion.obtenerCancionPorTitulo(titulo)) != null){

            request.setAttribute("titulo", cancion.getTitulo());
            request.setAttribute("cantante", cancion.getCantante());
            request.setAttribute("duracion", cancion.getDuracion());
            request.setAttribute("genero", cancion.getGenero());

            RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
            dispatcher.forward(request, response);
            }else
                throw new NotRegisteredException(titulo+ "No registrado");

        } catch (NotRegisteredException ex) {
            System.out.println("No registrada");

            request.setAttribute("mensaje", ex.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {

        }

    }
}
