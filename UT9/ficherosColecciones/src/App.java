import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class App {
    private static Map<String,String> diccionario 
        = new HashMap<String,String>(); 
            public static void main(String[] args) throws Exception {
                lecturaDiccionario(); 
                menu();




    }

    private static void menu(){
        boolean continua = true; 
        Scanner sc =  new Scanner(System.in);
        Map<String,Integer> contadorMap; 
        String opcion, texto; 
        while(continua){
        System.out.println("1. Escribe el texto a analizar");
        System.out.println("2. Introduce la ruta del archivo");
        System.out.println("3.Salir");
        opcion = sc.nextLine();

        switch (opcion) {
            case "1": 
                 System.out.println("Introduce el texto que quieres analizar");
                 texto = sc.nextLine(); 
                 contadorMap= analizarTexto(texto);
                 mostrarResultados(contadorMap);
                break;
            case "2":
                texto= leerFichero();
                contadorMap= analizarTexto(texto);
                mostrarResultados(contadorMap);
            case "3": 
                continua = false; 
            default:
                break;
        }

        }   

    }

    private static String leerFichero(){
        String ruta, texto; 
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); 
        System.out.println("Introduce el nombre del fichero");
        ruta = sc.nextLine();
      
        try(BufferedReader br = 
        new BufferedReader(new FileReader(ruta))){
            String linea; 
           
           
            while((linea = br.readLine())!= null){  
                sb.append(linea);
                sb.append(" "); 

            }

        }catch(IOException ex){
            System.out.println("No ha sido posible leer el diccionario");
        }
        System.out.println(sb.toString());
        return sb.toString(); 
    }
    private static void lecturaDiccionario(){

        try(BufferedReader br = 
        new BufferedReader(new FileReader("diccionario.csv"))){
            String linea; 
            // como no quiero la primera línea para almacenar en el diccionario
            // leo la línea (palabra, categoría), pero no la almacenaré
            br.readLine(); 

            while((linea = br.readLine())!= null){
                // en línea tengo la cadena de texto leida 
                // necesitamos dividir la línea en palabra, categoria
                String[] dosPalabras = linea.split(","); 
                if (dosPalabras.length == 2) {
                    String palabra = dosPalabras[0].toLowerCase();
                    String categoria = dosPalabras[1].toLowerCase();
                    diccionario.put(palabra,categoria);    
                }  
            }

        }catch(IOException ex){
            System.out.println("No ha sido posible leer el diccionario");
        }



    }

    private static Map<String,Integer> analizarTexto(String texto){

        // para almacenar las repeticiones de las categorías
        // usaré map <categoria,repeticiones> == <String,Integer>

        Map<String,Integer> contadorMap = new HashMap<>();
        String[] textoAnalizar = texto.toLowerCase().split(" "); 

        // Analizar cada una de las palabras del diccionario
        // feliz,Emociones Positivas - ya está en el MAP
        for(Entry<String,String> entry: diccionario.entrySet()){
            String clave = entry.getKey();
            for(String palabra : textoAnalizar){
                if(clave.equals(palabra)){
                        // he encontrado genial (emociones positivas)
                        // emociones positivas ,1 
                        // DEFINICIÓN DEL MÉTODO get(Object key) 
                        // contadorMap.get(entry.getKey()); 
                        // coger el valor que tiene el map para la posición de la clave
                        // put(emociones,+1)
                    System.out.println("CATEGORÍA " + entry.getValue()); 
                   
                    System.out.println("VALOR" + contadorMap.get(entry.getValue()));   
                    contadorMap.put(entry.getValue(),
                            contadorMap.getOrDefault(entry.getKey(), 1) + 1); 
                            System.out.println("VALOR" + contadorMap.get(entry.getValue()));   

                            // Returns the value to which the specified key is mapped, 
                            //or defaultValue if this map contains no mapping for the key.
                }
            }


            
        }
        return contadorMap; 
    }
    private static void mostrarResultados(Map<String,Integer> contadorMap){
        // mostrar los resultados que tengo en el contadorMap
        if(contadorMap.isEmpty()){
            System.out.println("No se han encontrado resultados");
            // si no mostramos las categorías que están a cero
        }else{
            for(Entry<String,Integer> entry: contadorMap.entrySet()){
                System.out.println(entry.getKey() + ":"  + entry.getValue());
            }
        }

            
    }
}
