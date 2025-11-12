-- Crear base de datos:
CREATE DATABASE ejemplociudades;

-- Seleccionarla para hacer consultas:
USE ejemplociudades;

-- Creación de tablas (Personas -> 1:N <- Ciudades):
CREATE TABLE ciudades (
	id_ciudad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE personas (
	id_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(15) NOT NULL,
    edad INT, 
    altura FLOAT,
    fecha_nacimiento DATE, 
    ciudad INT,
    FOREIGN KEY(ciudad) REFERENCES ciudades(id_ciudad)
);

-- SI (Personas -> N:M <- Ciudades):
-- CREATE TABLE personas_ciudades(
-- 	persona INT,
--  ciudad INT,
--  FOREIGN KEY(persona) REFERENCES personas(id_persona),
--  FOREIGN KEY(ciudad) REFERENCES ciudades(id_ciudad)
-- );

-- Crear/guardar registros:
INSERT INTO ciudades (nombre) VALUES ('Tucumán');
INSERT INTO ciudades (nombre) VALUES ('Buenos Aires');
INSERT INTO ciudades (nombre) VALUES ('New York');
INSERT INTO ciudades (nombre) VALUES ('Caracas');
INSERT INTO ciudades (nombre) VALUES ('Bogotá');
INSERT INTO ciudades (nombre) VALUES ('Santiago');
INSERT INTO ciudades (nombre) VALUES ('Santa Cruz');

INSERT INTO personas (nombre, apellido, edad, altura, fecha_nacimiento, ciudad)
VALUES ('Lucas', 'Álvarez', 35, 1.72, '1985-03-29', 1),
	   ('Leo', 'Sierras', 24, 1.89, '1996-01-10', 4),
       ('Romina', 'Moyano', 56, 1.80, '1972-03-23', null),
       ('Antonio', 'López', 47, 1.65, '1981-09-15', 2),
       ('Cecilia', 'Gutiérrez', 44, 1.67, '1983-12-08', 4),
       ('Luis', 'Pinki', 22, 1.58, '1999-08-05', 5),
       ('Antonio', 'López', 38, 1.64, '1989-10-31', null),
       ('Luis', 'Barboza', 53, 1.72, '1973-11-09', null),
       ('Carmen', 'Solano', 75, 1.56, '1945-09-02', 1),
       ('Diego', 'Palacios', 35, 1.76, '1990-01-26', 2);
       
-- Recuperar todos los registros:
SELECT * FROM ciudades;

SELECT * FROM personas;

-- Recuperar algunas columnas de todos los registros:
SELECT nombre, apellido FROM personas;

-- Recuperar un registro por ID:
SELECT * FROM personas WHERE id_persona = 3;

-- Recuperar registros bajo condiciones:
SELECT * FROM personas WHERE edad > 40; 

SELECT * FROM personas WHERE nombre = 'Antonio' AND apellido = 'López';

SELECT * FROM personas WHERE NOT ciudad = 1;

SELECT * FROM personas ORDER BY nombre ASC;

SELECT * FROM personas ORDER BY fecha_nacimiento DESC;

SELECT * FROM personas WHERE edad > 40 ORDER BY edad ASC;

SELECT ciudad, COUNT(*) AS cantidad_de_personas FROM personas GROUP BY ciudad;

SELECT * FROM personas WHERE nombre LIKE '%toni%';

SELECT * FROM personas WHERE nombre NOT LIKE '%toni%';

-- Paginado de registros:
SELECT * FROM personas LIMIT 3 OFFSET 6;

-- 3 registros por pag
-- pag (1) -> 1, 2, 3
-- pag (2) -> 4, 5, 6 -> OFFSET 3;
-- pag (3) -> 7, 8, 9 -> OFFSET 6;
-- pag (4) -> 10

-- LIMIT 3
-- OFFSET (limit * [nro_pag - 1])
-- pag 2 -> OFFSET 3 => (3 * [2 - 1])

-- Actualización de un registro:
UPDATE personas SET edad = 45, ciudad = 7 WHERE id_persona = 5;

-- Borrado de un registro:
DELETE FROM personas WHERE id_persona = 8;

