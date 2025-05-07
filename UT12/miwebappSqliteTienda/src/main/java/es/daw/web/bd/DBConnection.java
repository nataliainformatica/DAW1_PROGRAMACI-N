package es.daw.web.bd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * PATRÓN SINGLETON Este patrón de diseño se encarga de que una clase
 * determinada unicamente pueda tener un único objeto.
 * El patrón Singleton, o patrón de instancia única,
 * es un patrón de diseño encargado de restringir la
 * creación de objetos de una clase (o el valor de un tipo) a un único objeto.
 * Genera una única instancia en la ejecución del programa y proporciona un
 * acceso global a la misma.
 *
 * DBConnection: esta es la clase que me va a permitir conectar a la B.D
 *
 * @author melola
 */
public class DBConnection {
    private static final String URL_PREFIX = "jdbc:sqlite:";
    private static Connection con = null;

    private DBConnection() {
    } // De esta forma nadie puede hacer un new de DBConnection con constructor vacío
      // por defecto

    /**
     * Método para obtener la conexión
     * 
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        if (con == null) {

            try {
                Class.forName("org.sqlite.JDBC");
                // Obtener la ruta de la base de datos
                String ruta = DBConnection.class.getClassLoader()
                        .getResource("tienda.db")
                        .toURI()
                        .getPath();
                        System.out.println("MODIFICADO..");
                // Construir la URL completa
                String url = URL_PREFIX + ruta;
                return DriverManager.getConnection(url);
            }   catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                throw new SQLException("No se ha encontrado el driver de conexión");
            } catch (URISyntaxException e) {
                
                e.printStackTrace();
                throw new SQLException("No se ha encontrado el driver de conexión");
            }
        }
        return con;
    }

    /**
     * Método para cerrar la conexión
     * 
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
