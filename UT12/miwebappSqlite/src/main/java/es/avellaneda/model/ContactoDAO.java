package es.avellaneda.model;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


public class ContactoDAO {
  
    public boolean insertarUsuario(Contacto contacto) {
        String sql = "INSERT INTO emp(empname,email) VALUES(?, ?)";
        System.out.println(sql);
       System.out.println("PROCESO DE INSERCIÓN");
        int insertado =0; 
        try (Connection conn = DatabaseConnection.getConnection( );
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                System.out.println("Ejecutando SQL: " + sql);          
            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(2, contacto.getEmail());
            System.out.println(pstmt.toString());
            insertado= pstmt.executeUpdate();
            if(insertado!=0){
                System.out.println("Usuario insertado correctamente.");
                return true; 
            }else{
                System.out.println("respuesta insert. "+ insertado);
            }
          
        } catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXIÓN");
            e.printStackTrace();
        }
        return false; 
    }

 


}
