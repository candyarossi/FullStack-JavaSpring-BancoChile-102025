USE ejemplociudades;

SELECT * FROM personas;

-- CONCAT()
SELECT CONCAT(apellido, ', ', nombre) AS nombre_completo, edad, altura
FROM personas;

-- LENGTH()
SELECT nombre, LENGTH(nombre) AS length_nombre FROM personas;

-- UPPER / LOWER
SELECT
    LOWER(nombre) AS nombre,
    UPPER(apellido) AS apellido,
    fecha_nacimiento
FROM personas;

-- SUM
SELECT SUM(edad) AS suma_edades FROM personas;

-- AVG
SELECT AVG(edad) AS promedio_edad FROM personas;

-- MIN / MAX
SELECT MIN(altura) AS min_altura, MAX(altura) AS max_altura
FROM personas;

-- ROUND
SELECT nombre, apellido, ROUND(altura, 1) AS altura FROM personas;

-- DATE_FORMAT
SELECT nombre, apellido, DATE_FORMAT(fecha_nacimiento, '%d/%m/%y') AS nacimiento
FROM personas;

-- DAY / MONTH / YEAR
SELECT
    nombre,
    apellido,
    DAY(fecha_nacimiento) AS dia,
    MONTH(fecha_nacimiento) AS mes,
    YEAR(fecha_nacimiento) AS anio
FROM personas;

-- NOW / CURDATE / CURTIME
SELECT NOW() AS fecha_hora, CURDATE() AS fecha, CURTIME() AS hora;

-- COUNT
SELECT COUNT(*) AS cantidad_de_antonios
FROM personas
WHERE
    nombre = 'Antonio';

-- IF
SELECT nombre, apellido, IF(ciudad, ciudad, 'N/A') AS ciudad
FROM personas;