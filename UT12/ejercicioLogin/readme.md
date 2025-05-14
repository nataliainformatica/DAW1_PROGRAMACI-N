
```
CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

````
```

INSERT INTO usuarios (nombre, password) VALUES ('juan', '1234');
INSERT INTO usuarios (nombre, password) VALUES ('maria', 'abcd');

```
/****************************index.jsp
```
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css"/>
    </head>
    <body>
         <div class="container">
            <form action="hello-servlet" method="post">
                <p>
                    <label for="usuario">Usuario:</label>
                    <input type="text" id="usuario" name="usuario" required/>
                </p>
                <p>
                    <label for="pass">Contraseña:</label>
                    <input type="password" id="pass" name="pass" required/>
                </p>
                <p>
                    <input type="submit" value="Entrar"/>
                </p>
            </form>
        </div>
    </body>
</html>
``` 
