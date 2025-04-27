package es.avellaneda.webapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


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
        // conexionSQL();
         System.out.println("*versión3*************************************");
         System.out.println("Context path: " + req.getContextPath());
         RequestDispatcher dispatcher = req.getRequestDispatcher("/formulario.html");
         dispatcher.forward(req, resp);
    }
    private void conexionSQL(){
   
      String url = "jdbc:mysql://localhost:3306/mi_base";
      String user = "root";
      String password = "clave123";
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection(url, user, password);
          Statement stmt = conn.createStatement();
          stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ejemplo (id INT PRIMARY KEY, nombre VARCHAR(255))");
          System.out.println("¡Conexión exitosa y tabla creada!");
          conn.close();
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    
}
