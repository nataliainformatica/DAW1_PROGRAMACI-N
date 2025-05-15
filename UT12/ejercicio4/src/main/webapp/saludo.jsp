<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mensaje</title>
</head>
<body>
    <h1> MENSAJE PARA EL USUARIO</h1>
    <h2><%= request.getAttribute("mensaje") %></h2>
  
    <a href="index.jsp">Volver</a>
</body>
</html>

