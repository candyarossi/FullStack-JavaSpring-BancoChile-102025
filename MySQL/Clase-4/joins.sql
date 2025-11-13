USE ejemplociudades;

-- INNER JOIN
SELECT
    p.nombre,
    p.apellido,
    p.edad,
    p.altura,
    DATE_FORMAT(p.fecha_nacimiento, '%d/%m/%y') AS fecha_nacimiento,
    c.nombre AS ciudad
FROM personas AS p
    INNER JOIN ciudades AS c ON c.id_ciudad = p.ciudad;

-- LEFT JOIN
SELECT *
FROM personas
    LEFT JOIN ciudades ON ciudades.id_ciudad = personas.ciudad;

SELECT *
FROM personas
    LEFT JOIN ciudades ON ciudades.id_ciudad = personas.ciudad
WHERE
    ciudades.id_ciudad IS NULL;

-- RIGHT JOIN
SELECT *
FROM personas
    RIGHT JOIN ciudades ON ciudades.id_ciudad = personas.ciudad;

SELECT *
FROM personas
    RIGHT JOIN ciudades ON ciudades.id_ciudad = personas.ciudad
WHERE
    personas.ciudad IS NULL;

-- FULL / CROSS JOIN
SELECT *
FROM personas
    CROSS JOIN ciudades
ORDER BY ciudades.nombre ASC;

SELECT *
FROM personas FULL
    JOIN ciudades
ORDER BY ciudades.nombre ASC;

-- OUTER JOIN no tiene soporte en MySQL