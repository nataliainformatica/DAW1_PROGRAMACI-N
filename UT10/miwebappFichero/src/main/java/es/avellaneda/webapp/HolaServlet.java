package es.avellaneda.webapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;

//El parámetro "/hola" es la URL que lo activa.

@WebServlet("/hola")
public class HolaServlet extends HttpServlet {
  /*
   * setContentType(...): indica al navegador que va a recibir una página HTML en UTF-8.

    getWriter(): obtiene un flujo de salida para escribir directamente en la respuesta.

    out.println(...): escribe el HTML en la respuesta que verá el usuario en el navegador.
   */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

        /* 
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<h1>¡Hola desde el servlet con anotaciones!</h1>");
        */
        /*
         * RequestDispatcher es una interfaz que permite a un servlet redirigir o reenviar una petición a otro recurso dentro del mismo servidor (otro servlet, JSP o archivo HTML).
         El control del flujo pasa a otro recurso en el servidor sin que el navegador lo sepa. La URL no cambia.
         */
         RequestDispatcher dispatcher = req.getRequestDispatcher("/formulario.html");
         dispatcher.forward(req, resp);

    }
}
