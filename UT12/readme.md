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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Formulario</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilos.css">

    </head>

    <body>
         <div>
        <h2>Ingresa el título</h2>
       
        <form action="entrada" method="post">

            <input type="text" name="titulo" required>
            <button type="submit">Buscar</button>
        </form>
        <p style="color:red;">
            <%= request.getAttribute("mensaje") !=null ? request.getAttribute("mensaje") : "" %>
        </p>
        </div>
    </body>

    </html>```









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


# Ejercicio 6

<img width="759" alt="image" src="https://github.com/user-attachments/assets/b1d122c8-bd05-4699-9c5c-fc7f396d8131" />



<img width="353" alt="image" src="https://github.com/user-attachments/assets/8db45cce-8e06-45b6-8fa0-96cd1734dc66" />



```
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>POKEDEX WEB</title>
    <!-- https://www.flaticon.com/search?word=pokemon-->
    <link rel="icon" href="pokeball.png" type="image/x-icon">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(to right, #f9f9f9, #d6eaff);
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            color: #e3350d;
            margin-top: 40px;
            font-size: 2.5em;
            text-shadow: 1px 1px #fff;
        }

        h2 {
            color: #3b4cca;
            margin-bottom: 20px;
        }

        div {
            background-color: white;
            border: 2px solid #3b4cca;
            border-radius: 10px;
            padding: 30px 40px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 350px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: bold;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"],
        input[name="nombrePokemon"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
            font-size: 1em;
        }

        input[type="radio"] {
            margin-right: 8px;
        }

        p {
            margin: 10px 0;
        }

        input[type="submit"] {
            background-color: #ffcb05;
            color: #2a75bb;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            font-size: 1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #f2b807;
        }

        select {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
            font-size: 1em;
            background-color: #fff;
        }

        button[type="submit"] {
            background-color: #ffcb05;
            color: #2a75bb;
            border: none;
            padding: 12px 20px;
            border-radius: 8px;
            font-size: 1.1em;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        button[type="submit"]:hover {
            background-color: #f2b807;
            transform: translateY(-2px);
        }

        button[type="submit"]:active {
            transform: translateY(0);
            background-color: #e6a800;
        }
    </style>

</head>

<body>
    <h1>POKEDEX DAW 1A</h1>
    <h2>Escribe el nombre del Pokemon del que quieres ver la imagen</h2>
    <div>
        <form action="GetPokemonServlet" method="post">
            <label for="nombrePokemon">Nombre:</label>
            <select name="nombrePokemon" id="nombrePokemon" required>
                <option value="">-- Elige un Pokémon --</option>
                <option value="pikachu">Pikachu</option>
                <option value="bulbasaur">Bulbasaur</option>
                <option value="charmander">Charmander</option>
                <option value="squirtle">Squirtle</option>
                <option value="eevee">Eevee</option>
                <option value="snorlax">Snorlax</option>
                <option value="mew">Mew</option>
                <option value="gengar">Gengar</option>
                <!-- Puedes añadir más Pokémon aquí -->
            </select>
            <!--
			<p>
				<label>Ficha completa del pokemon:</label><input type="radio"
					name="tipo" value="info" />
			</p>
			<p>
				<label>Mostrar imagen FRONT: </label><input type="radio" name="tipo"
					value="front" />
			</p>
			<p>
				<label>Mostrar imagen BACK: </label><input type="radio" name="tipo"
					value="back" />
			</p>
            -->

            <button type="submit" name="action" value="Ver info">Ver info</button>



        </form>
    </div>
</body>

</html>
```


base de datos 

```
CREATE TABLE pokemon (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL UNIQUE,
    imagen TEXT NOT NULL
);

-- Insertar primeros 20 Pokémon
INSERT INTO pokemon (nombre, imagen) VALUES ('bulbasaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('ivysaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('venusaur', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('charmander', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('charmeleon', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('charizard', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('squirtle', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('wartortle', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('blastoise', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('caterpie', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('metapod', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/11.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('butterfree', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/12.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('weedle', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/13.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('kakuna', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/14.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('beedrill', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/15.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('pidgey', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/16.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('pidgeotto', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/17.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('pidgeot', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('rattata', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/19.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('raticate', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/20.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('spearow', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/21.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('fearow', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/22.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('ekans', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/23.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('arbok', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/24.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('pikachu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('raichu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/26.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('sandshrew', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/27.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('sandslash', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/28.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('nidoran-f', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/29.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('nidorina', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/30.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('nidoqueen', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/31.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('nidoran-m', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/32.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('nidorino', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/33.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('nidoking', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/34.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('clefairy', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('clefable', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/36.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('vulpix', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/37.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('ninetales', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/38.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('jigglypuff', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png');
INSERT INTO pokemon (nombre, imagen) VALUES ('wigglytuff', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/40.png');




select * from pokemon;
```


Página de resultado: 

```
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ficha del Pokémon</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to bottom, #f0f8ff, #e6f0ff);
            color: #333;
            text-align: center;
            padding: 40px;
        }

        .pokemon-card {
            display: inline-block;
            background-color: #ffffff;
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
            padding: 30px;
            max-width: 400px;
            margin-top: 30px;
        }

        .pokemon-card h2 {
            color: #ff4444;
            text-transform: capitalize;
        }

        .pokemon-card img {
            width: 200px;
            height: auto;
            margin-top: 20px;
        }

        .btn {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #0056b3;
        }

    </style>
</head>
<body>
    <h1>POKEDEX DAW 1A</h1>

    <div class="pokemon-card">
        <h2><%= request.getAttribute("nombre") %></h2>

        <img src="<%= request.getAttribute("imagenUrl") %>" alt="Imagen de <%= request.getAttribute("nombre") %>">

        <br>
        <a class="btn" href="index.html">Volver a buscar</a>
    </div>
</body>
</html>

```


