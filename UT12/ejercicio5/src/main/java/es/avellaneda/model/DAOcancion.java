package es.avellaneda.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.avellaneda.exceptions.NotRegisteredException;

public class DAOcancion {
    /*
     * id INTEGER PRIMARY KEY AUTOINCREMENT,
     * titulo TEXT UNIQUE NOT NULL,
     * cantante TEXT NOT NULL,
     * duracion INTEGER,
     * genero TEXT
     */
    public static boolean modificarCancion(Cancion cancion) {
        String sql = "UPDATE canciones SET  cantante= ?, duracion = ?, genero =? WHERE titulo =?";
        System.out.println(sql);

        int modificado = 0;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("Ejecutando SQL: " + sql);
            pstmt.setString(1, cancion.getCantante());
            pstmt.setInt(2, cancion.getDuracion());
            pstmt.setString(3, cancion.getGenero());
            pstmt.setString(4, cancion.getTitulo());
            System.out.println(pstmt.toString());
            modificado = pstmt.executeUpdate();
            if (modificado != 0) {
                System.out.println("Usuario insertado correctamente.");
                return true;
            } else {
                System.out.println("respuesta MODIFY. " + modificado);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXIÓN");
            e.printStackTrace();
        }
        return false;
    }

    public static int obtenerNumeroCanciones() throws SQLException{
         String sql = "SELECT COUNT(*) FROM canciones";
        System.out.println("Prepared statement" + sql);
        System.out.println("PROCESO DE LECTURA _v5");
        Cancion cancion = new Cancion();
         int resultado=0;

        try (Connection conn = DatabaseConnection.getConnection();
                Statement st = conn.createStatement()) {
             

            ResultSet rs = st.executeQuery(sql);
        
            // TÍTULO ES PK, POR LO TANTO SOLAMENTE DEBE EXISTIR 1 ó 0
            if (rs.next()) {
               resultado= rs.getInt(1);

            } 

            System.out.println("cancion obtenida correctamente.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            System.out.println("ERROR EN LA CONEXIÓN O CONSULTA");
            throw new SQLException();
        }
        return resultado;
    }
    public static Cancion obtenerCancionPorId(int id) throws NotRegisteredException, SQLException{
              String sql = "SELECT * FROM canciones WHERE id=?";
        System.out.println("Prepared statement" + sql);
        System.out.println("PROCESO DE LECTURA _v5");
        Cancion cancion = new Cancion();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            System.out.println("CONSULTA ENVIADOA A SQLITE" + pstmt.toString());
            // TÍTULO ES UNIQUE, POR LO TANTO SOLAMENTE DEBE EXISTIR 1 ó 0
            if (rs.next()) {
                cancion.setId(rs.getInt("id"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setCantante(rs.getString("cantante"));
                cancion.setDuracion(rs.getInt("duracion"));
                cancion.setGenero(rs.getString("genero"));

            } else
                throw new NotRegisteredException(id +  "cancion no registradA");

            System.out.println("cancion obtenida correctamente.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            System.out.println("ERROR EN LA CONEXIÓN O CONSULTA");
            throw new SQLException();
        }
        return cancion;
    }

    /*
     * id INTEGER PRIMARY KEY AUTOINCREMENT,
     * titulo TEXT UNIQUE NOT NULL,
     * cantante TEXT NOT NULL,
     * duracion INTEGER,
     * genero TEXT
     */
    public static Cancion obtenerCancionPorTitulo(String titulo) throws NotRegisteredException, SQLException {

        String sql = "SELECT * FROM canciones WHERE titulo=?";
        System.out.println("Prepared statement" + sql);
        System.out.println("PROCESO DE LECTURA _v5");
        Cancion cancion = new Cancion();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulo);

            ResultSet rs = pstmt.executeQuery();
            System.out.println("CONSULTA ENVIADOA A SQLITE" + pstmt.toString());
            // TÍTULO ES UNIQUE, POR LO TANTO SOLAMENTE DEBE EXISTIR 1 ó 0
            if (rs.next()) {
                cancion.setId(rs.getInt("id"));
                cancion.setTitulo(rs.getString("titulo"));
                cancion.setCantante(rs.getString("cantante"));
                cancion.setDuracion(rs.getInt("duracion"));
                cancion.setGenero(rs.getString("genero"));

            } else
                throw new NotRegisteredException(titulo +  "cancion no registradA");

            System.out.println("cancion obtenida correctamente.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

            System.out.println("ERROR EN LA CONEXIÓN O CONSULTA");
            throw new SQLException();
        }
        return cancion;
    }
}
