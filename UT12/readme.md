# EJERCICIOS

## EJERCICIO 4 - EjercicioLogin

Usando el "esqueletoProyecto" proporcionado , deberás modificar el código
desde la página principal, nos mostrará un formulario de login
si el usuario está registrado
nos mostrará un mensaje , por ejemplo con el id que tiene el usuario (en la tabla)
usando jsp


si no está registrado, mostrará otro mensaje distinto


bbdd: 
tabla:  usuarios
id (pk, autoincrement)
nombre (varchar, unique)
pass (varchar)



## Ejercicio 5
Al arrancar la aplicación, mostrará un pequeño formulario que permitirá introducir el título de la canción: 

```
CREATE TABLE canciones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT UNIQUE NOT NULL, 
    cantante TEXT NOT NULL,
    duracion INTEGER, 
    genero TEXT

);



<img width="572" alt="image" src="https://github.com/user-attachments/assets/8e1ce0d4-e550-4afd-8fb7-6508a21b4342" />


```
### FICHERO CSS
```
 body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f4f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        label {
            display: block;
            margin-top: 15px;
            color: #555;
            font-weight: bold;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
        }

        button[type="submit"] {
            margin-top: 25px;
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        input[readonly] {
            background-color: #e9ecef;
            color: #6c757d;
        }



El botón dirigirá a un servlet que se encargará de buscar la información de la canción devolviendo otro formulario con los datos de ésta: 
<img width="572" alt="image" src="https://github.com/user-attachments/assets/8b79293c-0be9-48e3-bf43-a6533dbc2e62" />


```

Éste es el formato vacío del formulario: 
<img width="471" alt="image" src="https://github.com/user-attachments/assets/a20f308b-73f3-485a-ad10-87e2b21fe96b" />

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Canción</title>
      <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<div class="form-container">
    <h2>Datos de la Canción</h2>
    <form action="procesarCancion.jsp" method="post">
        <label for="titulo">Título</label>
        <input type="text" id="titulo" name="titulo"
               value="<%= request.getAttribute("titulo") != null ? request.getAttribute("titulo") : "" %>"
               readonly />

        <label for="cantante">Cantante</label>
        <input type="text" id="cantante" name="cantante"
               value="<%= request.getAttribute("cantante") != null ? request.getAttribute("cantante") : "" %>" />

        <label for="duracion">Duración</label>
        <input type="text" id="duracion" name="duracion"
               value="<%= request.getAttribute("duracion") != null ? request.getAttribute("duracion") : "" %>" />

        <label for="genero">Género</label>
        <input type="text" id="genero" name="genero"
               value="<%= request.getAttribute("genero") != null ? request.getAttribute("genero") : "" %>" />
  <button type="submit" name="accion" value="guardar">Guardar</button>
  <button type="submit" name="accion" value="enviar">Enviar</button>
    </form>
</div>
</body>
</html>
```


Desarrolla el código que permitirá al pulsar el botón MODIFICAR, actualizar la canción (identificada por el título - que no se puede modificar), con los datos que modifique el usuario. 
Desarrolla la funcionalidad del botón SIGUIENTE, que mostrará otra canción (aleatoria). 





