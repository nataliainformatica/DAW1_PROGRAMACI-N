
Deberás  desarrollar una aplicación que permita analizar textos en español y determinar la cantidad de palabras que pertenecen a diferentes categorías; por ejemplo: emocionales, psicológicas y sociales, utilizando un diccionario**  en el que se cada palabra tiene su categoría definida.
La aplicación debe ser capaz de leer el texto desde dos fuentes posibles:
1.	Entrada por consola (escribiendo el texto manualmente).
2.	Un archivo de texto “nombre”.txt en la ruta de la aplicación (no es necesario implementar la función de escritura del fichero .txt)
El análisis se basará en un diccionario cargado desde un archivo CSV que contiene las palabras  asociadas a cada una de  las  categorías  que se pretenden evaluar (se proporciona como recursos). 
El análisis contará primero las categorías que proporciona el diccionario y contará después cuántas veces aparecen palabras en cada categoría, finalizará presentando  el resultado en consola.
Deberás implementar los métodos que permitan realizar las siguientes funcionalidades: 
1.	Lectura del Diccionario:
o	El programa debe leer un archivo CSV (diccionario.csv que se proporciona en recursos) que contiene palabras y sus categorías asociadas. Cada línea del archivo tiene  el formato: palabra,categoria.
2.	Entrada de Texto:
o	El usuario debe poder ingresar el texto de dos formas:
1.	Escribir manualmente el texto en consola.
2.	Leer desde un archivo de texto (.txt) que contenga el texto a analizar. Se le preguntará al usuario el nombre del fichero. 
3.	Análisis del Texto:
o	El programa debe analizar el texto proporcionado por el usuario  y contar cuántas palabras pertenecen a cada categoría. El análisis debe ser insensible a mayúsculas y minúsculas.
o	El programa usará el  diccionario cargado desde el archivo CSV (según se describe en la primera funcionalidad)
o	Se deben mostrar los resultados en consola indicando la cantidad de palabras que pertenecen a cada categoría.
4.	Interfaz de Usuario:
o	El programa debe mostrar un menú inicial donde el usuario puede elegir entre ingresar el texto manualmente o  proporcionar una ruta para leerlo desde un archivo de texto.
o	Una vez analizado el texto, se deben mostrar los resultados de manera clara, indicando la categoría y el número de palabras que tiene cada categoría.
Errores y Excepciones:
5.	El programa debe manejar adecuadamente los errores, como la entrada incorrecta de un archivo o la opción de menú no válida.
6.	Si el archivo de texto no puede ser leído o el archivo CSV está mal formado, el programa debe informar al usuario y no fallar inesperadamente.

Ejemplo del contenido del diccionario: 
palabra,categoria
feliz,Emociones Positivas
genial,Emociones Positivas
triste,Emociones Negativas
ansiedad,Salud Mental
psicólogo,Salud Mental
...

// no es necesario que se muestre exactamente igual a la traza
===== RESULTADO DEL ANÁLISIS====================
[Emociones Positivas] :  3 palabra(s)
[Emociones Negativas] : 1 palabra(s)
[Salud Mental] : 2 palabra(s)
[Dinero y Economía] : 0 palabra(s)

