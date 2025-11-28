<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Agregar Videojuego</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Agregar Videojuego:</h1>
        <form:form action="/add" method="POST" modelAttribute="videojuego">
            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/>
            <form:errors class="error" path="nombre"/>

            <form:label path="descripcion">Descripción:</form:label>
            <form:textarea path="descripcion"></form:textarea>
            <form:errors class="error" path="descripcion"/>

            <form:label path="portada">Portada:</form:label>
            <form:input type="text" path="portada"/>
            <form:errors class="error" path="portada"/>

            <form:label path="fecha_lanzamiento">Fecha Lanzamiento:</form:label>
            <form:input type="date" path="fecha_lanzamiento"/>
            <form:errors class="error" path="fecha_lanzamiento"/>

            <form:label path="rating">Rating:</form:label>
            <form:input type="number" path="rating" step="0.5"/>
            <form:errors class="error" path="rating"/>

            <input type="hidden" name="creador" value="${usuario.id}"/>

            <input type="submit" value="Crear"/>
        </form:form> 
        <a href="/getAll">Volver</a>
    </body>
</html>