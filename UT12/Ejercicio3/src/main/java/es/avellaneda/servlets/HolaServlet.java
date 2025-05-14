package es.avellaneda.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
/*
 * El @WebServlet("/...") define la ruta pública relativa al contexto de tu aplicación.
La anotación @WebServlet("/ruta") no tiene nada que ver con la ubicación del archivo Java en el proyecto.
 Lo que define es la URL pública que responderá el servlet.
La ubicación física del .java dentro de src/main/java no influye en la URL,
 pero sí es importante para que Maven/Tomcat compile y registre bien el servlet.
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import es.avellaneda.exceptions.NotRegisteredException;
import es.avellaneda.model.Usuario;
import es.avellaneda.model.UsuarioDAO;

@WebServlet("/holaServlet")
public class HolaServlet extends HttpServlet {
    private Connection conexion;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException{

        Usuario usuario;
        String nombre = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String msg = "";
        // buscar el usuario en la bbdd
        try {
            usuario = UsuarioDAO.obtenerUsuario(new Usuario(nombre, pass));
            // mostrar al usuario mensaje de usuario registrado
            msg = "USUARIO REGISTRADO";
        } catch (NotRegisteredException | SQLException e) {
            /// mostrar al usuario mensaje de usuario no registrado
            msg = "USUARIO NO REGISTRADO";
        }
        /*
         * response.setContentType("text/html;charset=UTF-8");
         * response.getWriter().println("<h1>" +msg + "</h1>");
         */

        request.setAttribute("mensaje", msg);
        request.setAttribute("nombre", nombre);
        RequestDispatcher dispatcher = request.getRequestDispatcher("saludo.jsp");
        dispatcher.forward(request, response);

    }

}
