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
import java.io.PrintWriter;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;

import es.avellaneda.exceptions.NotRegisteredException;
import es.avellaneda.model.DAOpokemon;
import es.avellaneda.model.Pokemon;

@WebServlet("/GetPokemonServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Obtenemos el map de parámetros
        Map<String, String[]> parametros = request.getParameterMap();

        // Recuperamos valores esperados del formulario
        String nombre = obtenerParametro(parametros, "nombrePokemon");
        String accion = obtenerParametro(parametros, "action"); // aunque el botón tiene value, se puede usar
        Pokemon pokemon;
        try {
            pokemon = DAOpokemon.getPokemonByName(nombre);
            request.setAttribute("nombre", pokemon.getNombre());
            request.setAttribute("imagenUrl", pokemon.getImagen());
            System.out.println(pokemon.getImagen());
          

            RequestDispatcher dispatcher = request.getRequestDispatcher("pokemon.jsp");
            dispatcher.forward(request, response);

        } catch (NotRegisteredException e) {
            request.setAttribute("mensaje", nombre);
              RequestDispatcher dispatcher = request.getRequestDispatcher("respuesta.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private String obtenerParametro(Map<String, String[]> map, String clave) {
        if (map.containsKey(clave)) {
            String[] valores = map.get(clave);
            if (valores != null && valores.length > 0) {
                return valores[0];
            }
        }
        return null;
    }

}
