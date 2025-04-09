package es.daw.model;
/*
 * Con los atributos: Módulo que imparte (String)
 */
public class Profesor extends Persona{
    private String moduloImparte;
public Profesor(String nombre, String direccion, int edad, String moduloImparte) {
        super(nombre, direccion, edad);
        this.moduloImparte = moduloImparte;
       
    }



@Override
public String mostrarTipo() {
    return "Sr/Sra" +  getNombre(); 
}



public String getModuloImparte() {
    return moduloImparte;
}



public void setModuloImparte(String moduloImparte) {
    this.moduloImparte = moduloImparte;
} 


}
