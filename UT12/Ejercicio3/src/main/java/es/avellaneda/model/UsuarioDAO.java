package es.avellaneda.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.avellaneda.exceptions.NotRegisteredException;

public class UsuarioDAO {

    public static boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO emp(empname,email) VALUES(?, ?)";
        System.out.println(sql);
        System.out.println("PROCESO DE INSERCIÓN");
        int insertado = 0;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("Ejecutando SQL: " + sql);
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getPass());
            System.out.println(pstmt.toString());
            insertado = pstmt.executeUpdate();
            if (insertado != 0) {
                System.out.println("Usuario insertado correctamente.");
                return true;
            } else {
                System.out.println("respuesta insert. " + insertado);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXIÓN");
            e.printStackTrace();
        }
        return false;
    }

    public static Usuario obtenerUsuario(Usuario user) throws NotRegisteredException, SQLException {

        String sql = "SELECT * FROM usuarios WHERE nombre=? AND password =?";
        System.out.println("Prepared statement" + sql);
        System.out.println("PROCESO DE LECTURA _v5");
        Usuario usuario = new Usuario();
    
        try (Connection conn = DatabaseConnection.getConnection();PreparedStatement pstmt = conn.prepareStatement(sql)) {
           
                pstmt.setString(1, user.getNombre());
                pstmt.setString(2, user.getPass());
                ResultSet rs = pstmt.executeQuery();
                System.out.println("CONSULTA ENVIADOA A SQLITE" + pstmt.toString());
                if (rs.next()) {
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setPass(rs.getString("password"));

                } else
                    throw new NotRegisteredException(usuario, "Usuario no registrado");

                System.out.println("Usuarios obtenidos correctamente.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());

            System.out.println("ERROR EN LA CONEXIÓN O CONSULTA");
            throw new SQLException();
        }
        return usuario;
    }

}
