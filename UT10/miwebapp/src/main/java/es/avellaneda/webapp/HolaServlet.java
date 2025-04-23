package es.avellaneda.webapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


/**
 * HttpServlet es una clase abstracta de Jakarta EE (antes Java EE) que facilita la creación de aplicaciones web Java mediante el protocolo HTTP.

Pertenece al paquete: jakarta.servlet.http.HttpServlet

Detecta automáticamente el tipo de petición HTTP.

Llama al método correspondiente (doGet, doPost, etc.).

Te da objetos HttpServletRequest y HttpServletResponse, que contienen:

Información de la petición: parámetros, cabeceras, ruta, cookies...

Métodos para generar la respuesta: escribir HTML, cambiar código de estado, reenviar o redirigir.
 */

public class HolaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
        resp.setContentType("text/html");
         // Redirigir al formulario.html
         System.out.println("**************************************");
         System.out.println("Context path: " + req.getContextPath());
         RequestDispatcher dispatcher = req.getRequestDispatcher("/formulario.html");
         dispatcher.forward(req, resp);
    }
    
}
