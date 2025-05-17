package es.avellaneda.model;
public class Cancion {
    private int id;
    private String titulo;
    private String cantante;
    private int duracion; // en segundos
    private String genero;

    // Constructor vacío
    public Cancion() {}

    // Constructor completo (sin id si se autogenera)
    public Cancion(String titulo, String cantante, int duracion, String genero) {
        this.titulo = titulo;
        this.cantante = cantante;
        this.duracion = duracion;
        this.genero = genero;
    }

    // Constructor con ID (si se necesita)
    public Cancion(int id, String titulo, String cantante, int duracion, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.cantante = cantante;
        this.duracion = duracion;
        this.genero = genero;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    

}
