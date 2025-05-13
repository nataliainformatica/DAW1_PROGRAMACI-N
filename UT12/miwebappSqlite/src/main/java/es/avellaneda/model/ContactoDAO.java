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

 
   public boolean consultarContacto(Contacto contacto){
        // conexión , preparar la consulta , recoger el resultado
        // tratar el resultset
        //emp(empname,email)
        String sql = "SELECT empname, email  FROM emp"; 
        ResultSet resultado; 
        try (Connection conn = DatabaseConnection.getConnection( );
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            resultado = pstmt.executeQuery(); 
            while(resultado.next()){
                // fila con empname , email
                // comprobar si tengo el contacto recibido en la bbdd
                // contacto.getNombre().equals(el valor de la bbdd)

                String nombre = resultado.getString(1);
                String email = resultado.getString(2); 
                if(contacto.getNombre().equals(nombre) 
                        && contacto.getEmail().equals(email)){
                            // HE ENCONTRADO UN MATCH
                            return true; 
                        }
            }  
              

        }catch (SQLException e) {
            System.out.println("ERROR EN LA CONEXIÓN");
            e.printStackTrace();
        }
        return false;

    }

}
