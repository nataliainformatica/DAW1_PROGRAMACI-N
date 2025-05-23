package es.avellaneda.principal;

import java.sql.SQLException;
import java.util.Scanner;

import es.avellaneda.excepciones.NotRegisteredException;
import es.avellaneda.utilidades.DaoPokemon;

public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String nombre, ruta; 
       System.out.println("Consulta la ruta a la imagen de un pokemon");
        nombre = sc.nextLine();

        // consulta la ruta de la imagen

        try {
            ruta = DaoPokemon.consultaPokemon(nombre.toLowerCase());
            System.out.println("La imagen de " + nombre);
            System.out.println("está en : " + ruta);
        } catch (NotRegisteredException | SQLException e) {
            System.out.println("No existe o no se puede consultar");
            e.printStackTrace();
         

        
      
        
    }
}}
