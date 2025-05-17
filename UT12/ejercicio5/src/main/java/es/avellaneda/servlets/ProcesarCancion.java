package es.avellaneda.servlets;

import java.io.*;
import java.sql.SQLException;
import java.util.Random;

import es.avellaneda.exceptions.NotRegisteredException;
import es.avellaneda.model.Cancion;
import es.avellaneda.model.DAOcancion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/procesarCancion")
public class ProcesarCancion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Parámetros

        String accion;
        Cancion cancion;

        accion = request.getParameter("accion");
        switch (accion) {
            case "modificar":
                // con los atributos del formulario, modificar la cancion
                // CONSTRUCTOR: public Cancion(String titulo, String cantante, int duracion,
                // String genero) {
                int duracion;
                // este try-catch no sería necesario, ya que en el formulario hemos añadido la
                // opción de number en el input text
                try {
                    duracion = Integer.valueOf(request.getParameter("duracion"));
                } catch (Exception ex) {
                    duracion = 0;
                }

                cancion = new Cancion(request.getParameter("titulo"), request.getParameter("cantante"), duracion,
                        request.getParameter("genero"));

                boolean modificado = DAOcancion.modificarCancion(cancion);
                if (modificado) {
                    request.setAttribute("mensaje", "MODIFICADO CORRECTAMENTE");
                    request.setAttribute("titulo", cancion.getTitulo());
                    request.setAttribute("cantante", cancion.getCantante());
                    request.setAttribute("duracion", cancion.getDuracion());
                    request.setAttribute("genero", cancion.getGenero());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("mensaje", "ERROR EN LA MODIFICACIÓN");
                    request.setAttribute("titulo", cancion.getTitulo());
                    request.setAttribute("cantante", cancion.getCantante());
                    request.setAttribute("duracion", cancion.getDuracion());
                    request.setAttribute("genero", cancion.getGenero());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
                    dispatcher.forward(request, response);

                }

                break;
            case "siguiente":
                // FALTA crefactorizar para sacar el código a funciones

                try {
                    int resultado = DAOcancion.obtenerNumeroCanciones();
                    int id;
                    Random rd = new Random();
                    id = rd.nextInt(resultado);
                    // puede salir el 0 que no existe en la bbdd, pero lo dejo para comprobar que funciona CANCIÓN NO REGISTRADA
                    if ((cancion = DAOcancion.obtenerCancionPorId(id)) != null) {
                        // MOSTRAR LA CANCIÓN EN EL FORMULARIO
                        request.setAttribute("titulo", cancion.getTitulo());
                        request.setAttribute("cantante", cancion.getCantante());
                        request.setAttribute("duracion", cancion.getDuracion());
                        request.setAttribute("genero", cancion.getGenero());

                        RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
                        dispatcher.forward(request, response);
                    }
                } catch (SQLException e) {

                    e.printStackTrace();
                } catch (NotRegisteredException ex) {
                    request.setAttribute("mensaje", ex.getMessage());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
                    dispatcher.forward(request, response);
                }

                break;

            default:
                System.out.println("OPCIONES NÓ VALIDAS");
                break;
        }

    }
}
