import java.util.ArrayList;
import java.util.Scanner;

import es.daw.model.Alumno;
import es.daw.model.Curso;
import es.daw.model.Grado;
import es.daw.model.Persona;

public class App {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Persona>  personas = new ArrayList<>(); 

    public static void main(String[] args) {
     

        String opcion;
        do {

            System.out.println("1. Introduce un alumno");
            System.out.println("2. Introduce un profesor");
            System.out.println("3.Muestra los alumnos del grado DAW, segundo (2)");
            System.out.println("4.Muestra los alumnos ordenados por nombre.");
            System.out.println("5.Muestra las personas del aula (profesores y alumnos)");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    try {
                        personas.add(introduceAlumno());
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                default:
                    break;
            }

        } while (!opcion.equals("0"));

    }

    public static Alumno introduceAlumno() {

        // public Grado(String nombre, double notaMedia, Curso curso) {

        String nombreGrado;
        Curso curso;
        double notaMedia;
        String nombre, direccion;
        int edad;
        System.out.println("Introduce el nombre del grado");
        nombreGrado = sc.nextLine();
        System.out.println("Introduce el curso");
        /**
         * Si al introducir el curso, el usuario introduce un valor que no corresponda
         * (no es del tipo enumerado) se mostrará el mensaje: "No has introducido un
         * curso correcto, solo puedes poner números)
         */
        try {
            curso = Curso.valueOf(sc.nextLine().toLowerCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Has introducido un valor de curso que no es válido");
        }

        System.out.println("Introduce la nota media del curso");
        try {
            notaMedia = Double.parseDouble(sc.nextLine());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Has introducido un valor de nota media que no es válido");
        }
        System.out.println("Introduce el nombre del alumno");
        nombre = sc.nextLine();
        System.out.println("Introduce la dirección del alumno");
        direccion = sc.nextLine();
        System.out.println("Introduce la edad del alumno");
        edad = Integer.parseInt(sc.nextLine());

        // public Alumno(String nombre, String direccion, int edad, Grado grado) {

        Grado grado = new Grado(nombreGrado, notaMedia, curso);
        Alumno alumno = new Alumno(nombre,direccion,edad, grado);
        return alumno;
    }

    public static void muestraAlumhos(String nombreGrado, Curso curso){
   // personas

   for(Persona p: personas){
    // solo los alumnos
    // necesito saber si p es instancia de Alumno

    if(p instanceof Alumno){
        // puedo comprobar si el nombreGrado 
        // si el curso 
        Alumno a = ((Alumno)p);
        if(a.getGrado().getNombre().equals(nombreGrado)){
            if(a.getGrado().getCurso() == curso){
                // puedo mostrar el alumno
                System.out.println(a);
            }
        }
       
    }


   }



    }
}
