package es.daw.model;

/**
 * Con los atributos:
 * Grado (Nombre (String) , curso (enum (primer,segundo), - nota media(double)),
 * Como requisito, al crear la instancia de Alumno, si recibe un grado con una
 * nota media de cero se propagará una excepción no controlada.
 */

public class Alumno extends Persona {
    private Grado grado;

    public Alumno(String nombre, String direccion, int edad, Grado grado) {
        super(nombre, direccion, edad);

        if(grado.getNotaMedia()<=0){
            throw new IllegalArgumentException("La nota media del grado no puede ser cero");
        }
        this.grado = grado;
    }

    @Override
    public String mostrarTipo() {
        return "Alumno con nombre:  " + getNombre();

    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }


    


}
