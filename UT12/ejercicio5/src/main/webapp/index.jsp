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

    </html>