package es.avellaneda.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    private static final String URL_PREFIX = "jdbc:sqlite:";
    public static Connection getConnection() throws SQLException {
              try {
            // Cargar el driver  -deprecado, en conexiones a otros servidores no es necesario
            Class.forName("org.sqlite.JDBC");

            // Obtener la ruta de la base de datos
            String ruta = DatabaseConnection.class.getClassLoader()
                            .getResource("canciones.db")
                            .toURI()
                            .getPath();

           // Construir la URL completa
            String url = URL_PREFIX + ruta;
            System.out.println("URL de conexión: " + url);
            // Establecer la conexión usando la URL correcta

            // para conectar en sqlite - "jdbc:sqlite:"+"rutaBBDD"; 
            return DriverManager.getConnection(url);

        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver SQLite no encontrado");
            throw new SQLException("Error no se encuentra el conector", e);
        } catch (Exception e) { 
            System.out.println("Error general: " + e.getMessage());
            throw new SQLException("Error al conectar a la base de datos", e);
        }
    }}