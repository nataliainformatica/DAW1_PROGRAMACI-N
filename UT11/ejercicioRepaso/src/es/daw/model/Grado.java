package es.daw.model;
/**
 * Grado (Nombre (String) , curso (enum (primer,segundo), - nota media(double)),
 */
public class Grado {
    private String nombre; 
    private double notaMedia; 
    private Curso curso;
    public Grado(String nombre, double notaMedia, Curso curso) {
        this.nombre = nombre;
        this.notaMedia = notaMedia;
        this.curso = curso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getNotaMedia() {
        return notaMedia;
    }
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    @Override
    public String toString() {
        return "Grado [nombre=" + nombre + ", notaMedia=" + notaMedia + ", curso=" + curso + "]";
    } 

    


}
