CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);



INSERT INTO usuarios (nombre, password) VALUES ('juan', '1234');
INSERT INTO usuarios (nombre, password) VALUES ('maria', 'abcd');


// /C:/Users/ntgra/.rsp/redhat-community-server-connector/runtimes/installations/tomcat-10.1.4_1/apache-tomcat-10.1.4/webapps/Ejercicio3/WEB-INF/classes/usuarios.db

select * from usuarios;