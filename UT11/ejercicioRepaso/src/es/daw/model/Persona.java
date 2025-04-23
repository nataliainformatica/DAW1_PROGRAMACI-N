package es.daw.model;

/**
 * Persona, que es una clase base con los atributos: Nombre Edad Dirección
 * 
 * Si la clase hija es Alumno, el método mostrarTipo devolverá  Alumno con nombre: nombre
 * Si la clase hija es Profesor, el método mostrarTipo devolverá Sr/Sra nombre
 * La clase Persona no se podrá instanciar. Y el método mostrarTipo, no se conoce cómo implementarlo
 */
public abstract class Persona {


    private String nombre,direccion;
    private int edad;
    public Persona(String nombre, String direccion, int edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
    }

// método abstracto. No tiene implementación
    public abstract String mostrarTipo();

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", edad=" + edad + "]";
    } 

    


}
