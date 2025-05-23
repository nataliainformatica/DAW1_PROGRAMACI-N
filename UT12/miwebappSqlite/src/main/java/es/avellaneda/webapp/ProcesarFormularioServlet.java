package es.avellaneda.webapp;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.SQLException;

import es.avellaneda.model.Contacto;
import es.avellaneda.model.ContactoDAO;

public class ProcesarFormularioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String email = req.getParameter("email");
        String mensaje = req.getParameter("mensaje");

        Contacto contacto = new Contacto(nombre, email, mensaje);


        PrintWriter out = resp.getWriter();
        try {
          System.out.println("PROCESAR FORMULARIO--");

          // consultar contacto
          consultarContacto(contacto);


          resp.setContentType("text/html");
          /// cambiaremos la respuesta al usuario
          out.println("<h2>Datos recibidos</h2>");
          out.println("<h3>Contacto creado correctamente</h3>");
          out.println("<p><strong>Nombre:</strong> " + nombre + "</p>");
          out.println("<p><strong>Email:</strong> " + email + "</p>");
          out.println("<p><strong>Mensaje:</strong> " + mensaje + "</p>");
        } catch (Exception e) {
          out.println("<h2>Datos recibidos</h2>");
          
          out.println("<h3>No se ha podido guardar el contacto </h3>");
          
        } 
      
    }

    private void consultarContacto(Contacto contacto) throws ClassNotFoundException, SQLException{
      System.out.println("LLAMADA A CONSULTAR CONTACTO-v3");
  
      
        ContactoDAO contactoDAO = new ContactoDAO( );
              if(!contactoDAO.consultarContacto(contacto))){
                throw new SQLException("ERROR DE SQL");
              }
       
  
    }
}
