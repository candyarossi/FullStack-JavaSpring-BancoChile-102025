<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Videojuegos</title>
    </head>
    <body>
        <h1>Videojuegos:</h1>
        <ul>
            <c:forEach var="juego" items="${videojuegos}">
                <li>Nombre: <b>${juego.nombre}</b>, Fecha Lanzamiento: <b>${juego.fecha_lanzamiento}</b></li>
            </c:forEach>
        </ul>
    </body>
</html>