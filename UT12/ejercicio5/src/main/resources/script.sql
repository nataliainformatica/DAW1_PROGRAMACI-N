CREATE TABLE canciones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT UNIQUE NOT NULL, 
    cantante TEXT NOT NULL,
    duracion INTEGER, 
    genero TEXT

);
INSERT INTO canciones (titulo, cantante, duracion, genero)
VALUES
  ('Bohemian Rhapsody', 'Queen', 354, 'Rock'),
  ('Imagine', 'John Lennon', 183, 'Pop'),
  ('Billie Jean', 'Michael Jackson', 294, 'Pop'),
  ('Smells Like Teen Spirit', 'Nirvana', 301, 'Grunge'),
  ('Hotel California', 'Eagles', 390, 'Rock');

select *from canciones;