<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Saludo</title>
</head>
<body>
    <h1><%= request.getAttribute("mensaje") %></h1>
    <a href="index.html">Volver</a>
</body>
</html>

<!--
Aquí usamos <%= %> para escribir directamente el resultado de una expresión Java. En este caso,
 accedemos al atributo que dejó el Servlet (mensaje) en el objeto request.
 ->