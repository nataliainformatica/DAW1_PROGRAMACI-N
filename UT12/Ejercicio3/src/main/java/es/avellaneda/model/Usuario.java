package es.avellaneda.model;

public class Usuario {

    private String  nombre,pass;
    private int id;
    public Usuario(String nombre, String pass, int id) {
        this.nombre = nombre;
        this.pass = pass;
        this.id = id;
    }
    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        this.id =-1; // inicializamos a un valor que no es válido como pk
    }
     public Usuario() {
        this.nombre = "";
        this.pass =  "";
        this.id = -1;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    

}
