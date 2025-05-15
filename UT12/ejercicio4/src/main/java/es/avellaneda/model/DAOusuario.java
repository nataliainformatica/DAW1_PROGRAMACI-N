package es.avellaneda.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOusuario {

    public static Usuario usuarioRegistrado(Usuario usuario) throws Exception {

        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?";
        ResultSet resultSet;
        Usuario usr = null; 

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement(sql)) {
            // terminar la sentencia
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getPass());
            // AQUÍ YA TENGO LA SENTENCIA PREPARADA

            resultSet = pstm.executeQuery(); 
            if(resultSet.next()){
                int id = resultSet.getInt(1); 
                String nombre = resultSet.getString(2);
                String password = resultSet.getString(3);
                usr = new Usuario(id,nombre, password); 
            }
            // "SELECT * FROM usuarios WHERE nombre = 'juan' AND password = '1234";

        } catch (SQLException ex) {
            throw new SQLException(); 

        }
        return usr;

    }
}
