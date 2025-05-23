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
