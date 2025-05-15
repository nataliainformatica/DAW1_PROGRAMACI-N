package es.avellaneda.model;

public class Usuario {
    private String nombre, pass; 
    private int id;
    public Usuario(int id, String nombre, String pass ) {
        this.nombre = nombre;
        this.pass = pass;
        this.id = id;
    }

    
    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
        this.id =-1;  // ponemos una valor que no se utiliza nunca en la app
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
