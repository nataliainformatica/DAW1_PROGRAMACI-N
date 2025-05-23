/*CREATE TABLE pokemon (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL UNIQUE,
    imagen TEXT NOT NULL
);
*/
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




select * from pokemon;