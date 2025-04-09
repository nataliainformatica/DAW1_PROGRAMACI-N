Tenemos un aula con personas  con la siguiente información: 

Persona, que es una clase base con los atributos: 
Nombre
Edad
Dirección

De esta clase base heredan Alumno y Profesor

Alumno

Con los atributos:  
Grado (Nombre (String) , curso (int), - nota media(double)), 

Como requisito, al crear la instancia de Alumno, 
si recibe un grado con una nota media de cero
se propagará una excepción no controlada. 

Profesor

Con los atributos: Módulo que imparte
 (String)


Debes completar en la clase Principal un menú, que permita, introducir

 Personas 
en una colección (puede ser estática o dinámica, lo que prefieras). 

Todas las excepciones que haya en el código, 
se tratarán en la clase Principal. 


Cada opción debe escribirse en un método: 

1. Introduce un Alumno (aquí se mostrará el menú para pedir los datos)
     ```public static Alumno introduceAlumno(); ```
2. Introduce static un Profesor ( aquí se mostrará el menú para pedir los datos)
    ```public Profesor introduceProfesor();```
3. Muestra los alumnos del grado DAW, segundo (2)

    ``` public static muestraAlumnos(nombreGrado, curso)```
   
5. Muestra los alumnos ordenados por nombre. 
6. Muestra las personas del aula (profesores y alumnos)
  ```  public static muestraTodasPersonas()```

Si al introducir el curso, el usuario introduce un carácter que no sea un número
se mostrará el mensaje: "No has introducido un curso correcto, solo puedes poner números)


