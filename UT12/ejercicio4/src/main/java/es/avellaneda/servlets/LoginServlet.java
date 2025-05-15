package es.avellaneda.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

/**
 * HttpServlet es una clase abstracta de Jakarta EE (antes Java EE) que facilita la creación de aplicaciones web Java mediante el protocolo HTTP.

Pertenece al paquete: jakarta.servlet.http.HttpServlet

Detecta automáticamente el tipo de petición HTTP.

Llama al método correspondiente (doGet, doPost, etc.).

Te da objetos HttpServletRequest y HttpServletResponse, que contienen:

Información de la petición: parámetros, cabeceras, ruta, cookies...

Métodos para generar la respuesta: escribir HTML, cambiar código de estado, reenviar o redirigir.
 */

import jakarta.servlet.annotation.WebServlet;
/*
 * El @WebServlet("/...") define la ruta pública relativa al contexto de tu aplicación.
La anotación @WebServlet("/ruta") no tiene nada que ver con la ubicación del archivo Java en el proyecto.
 Lo que define es la URL pública que responderá el servlet.
La ubicación física del .java dentro de src/main/java no influye en la URL,
 pero sí es importante para que Maven/Tomcat compile y registre bien el servlet.
 */

import java.io.IOException;

import es.avellaneda.model.DAOusuario;
import es.avellaneda.model.Usuario;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("entrada a la app");

        String nombre = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        Usuario usuario = new Usuario(nombre, pass);
        String msj;
        try {
            usuario = DAOusuario.usuarioRegistrado(usuario);

            // ahora haríamos el forward a la página jsp
            // si el usuario está registrado nos mostrará un mensaje ,
            // por ejemplo con el id que tiene el usuario (en la tabla) usando jsp
            if (usuario != null) {
                msj = usuario.getNombre() + " BIENVENIDO , ESTÁS REGISTRADO ";
            } else {
                msj =  " BIENVENIDO , NO ESTÁS REGISTRADO ";
            }

            request.setAttribute("mensaje", msj);
            RequestDispatcher  dispatcher = request.getRequestDispatcher("saludo.jsp");
            dispatcher.forward(request, response);

        } catch (

        Exception e) {
            // trataríamos la excepción
            e.printStackTrace();
        }

        /*
         * response.setContentType("text/html;charset=UTF-8");
         * response.getWriter().println("<h1>Hola desde el Servlet</h1>");
         */
    }
}
