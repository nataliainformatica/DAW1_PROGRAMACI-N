package es.avellaneda.webapp;
import java.io.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;

@WebServlet("/procesarArchivo")
public class ProcesarArchivoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       System.out.println("******************************** ");

       String rutaArchivoXX = getServletContext().getRealPath("archivos");

        String rutaArchivo = rutaArchivoXX+ File.separator + "datos.txt";
        File archivo = new File(rutaArchivo);
        System.out.println("********** RUTA********************** ");
           System.out.println(rutaArchivoXX);
        File ruta = new File(rutaArchivo);
        if(ruta.exists()){
      
            System.out.println("********** existe********************** ");

        // Si el archivo no existe, lo creamos
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        System.out.println("********** existe archivo********************** ");
          // Escribimos en el archivo
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write("Nuevo dato escrito en el archivo.\n");
        }
        
        // Leemos el archivo
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }

        // Mostramos el contenido del archivo en la respuesta
        resp.setContentType("text/html");
        resp.getWriter().println("<h3>Contenido del archivo:</h3>");
        resp.getWriter().println("<pre>" + contenido.toString() + "</pre>");
    }
    System.out.println("******************************** ");
    System.out.println("**********no existe********************** ");

        }


      

}
