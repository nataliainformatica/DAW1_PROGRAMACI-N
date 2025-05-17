<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Canción</title>
      <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<div class="form-container">
    <h2>Datos de la Canción</h2>
    <form action="procesarCancion" method="post">
        <label for="titulo">Título</label>
        <input type="text" id="titulo" name="titulo"
               value="<%= request.getAttribute("titulo") != null ? request.getAttribute("titulo") : "" %>"
               readonly />

        <label for="cantante">Cantante</label>
        <input type="text" id="cantante" name="cantante"
               value="<%= request.getAttribute("cantante") != null ? request.getAttribute("cantante") : "" %>" />

        <label for="duracion">Duración</label>
        <input type="number" id="duracion" name="duracion"
               value="<%= request.getAttribute("duracion") != null ? request.getAttribute("duracion") : "" %>" />

        <label for="genero">Género</label>
        <input type="text" id="genero" name="genero"
               value="<%= request.getAttribute("genero") != null ? request.getAttribute("genero") : "" %>" />
  <button type="submit" name="accion" value="modificar">Modificar</button>
  <button type="submit" name="accion" value="siguiente">Siguiente</button>
    </form>
      <p style="color:red;">
            <%= request.getAttribute("mensaje") !=null ? request.getAttribute("mensaje") : "" %>
        </p>
</div>
</body>
</html>
