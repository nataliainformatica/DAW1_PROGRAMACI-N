package es.avellaneda.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.avellaneda.exceptions.NotRegisteredException;

public class DAOpokemon {


    public static Pokemon getPokemonByName(String nombre) throws NotRegisteredException, SQLException {
        String sql = "SELECT id, nombre, imagen FROM pokemon WHERE nombre = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre.toLowerCase());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nombrePokemon = rs.getString("nombre");
                    String imagen = rs.getString("imagen");
                    System.out.println("POKEMON ENCONTRADO " + nombrePokemon);
                    return new Pokemon(id, nombrePokemon, imagen);
                }else
                  throw new NotRegisteredException(nombre);
            }
        } catch (SQLException e) {
            // traza para ver posibles errores
            
            e.printStackTrace();
            throw e;
           
        }
        
    }


}
