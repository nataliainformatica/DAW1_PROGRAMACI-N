package es.avellaneda.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
      public static Connection con;
    public static Connection getConnection(){
  
    if(con == null) {

        System.out.println("creando la conexión");
        try {
            con = DriverManager.getConnection("jdbc:sqlite:base.db") ;
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    
    }

    return con; 

    }

    

}
