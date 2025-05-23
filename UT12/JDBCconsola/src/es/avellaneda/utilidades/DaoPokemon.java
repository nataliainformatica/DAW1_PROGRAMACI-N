package es.avellaneda.utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.avellaneda.excepciones.NotRegisteredException;

public class DaoPokemon {

    public static String consultaPokemon(String nombre)throws SQLException, NotRegisteredException{
      
        String sql = "SELECT imagen from  pokemon WHERE nombre = ?"; 
        ResultSet resultado; 
        try (Connection conn = DataBaseConnection.getConnection( );
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            resultado = pstmt.executeQuery(); 
            if(resultado.next()){           
                String imagen = resultado.getString(1); 
                return imagen; 
            }  else
            {
                throw new NotRegisteredException("NO EXISTE EN LA BBDD "+ nombre); 
            }
        }catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXIÓN");
            e.printStackTrace();
            throw e; 
        }
       

    }

}
