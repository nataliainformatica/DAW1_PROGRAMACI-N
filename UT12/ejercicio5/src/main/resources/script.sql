CREATE TABLE canciones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT UNIQUE NOT NULL, 
    cantante TEXT NOT NULL,
    duracion INTEGER, 
    genero TEXT

);