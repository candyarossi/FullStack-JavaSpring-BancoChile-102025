<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Editar Videojuego</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <h1>Editar Videojuego:</h1>
        <form:form action="/edit" method="POST" modelAttribute="videojuego">
            <input type="hidden" name="_method" value="PUT"/>

            <form:label path="nombre">Nombre:</form:label>
            <form:input type="text" path="nombre"/>
            <form:errors path="nombre"/>

            <form:label path="descripcion">Descripción:</form:label>
            <form:textarea path="descripcion"></form:textarea>
            <form:errors path="descripcion"/>

            <form:label path="portada">Portada:</form:label>
            <form:input type="text" path="portada"/>
            <form:errors path="portada"/>

            <form:label path="fecha_lanzamiento">Fecha Lanzamiento:</form:label>
            <form:input type="date" path="fecha_lanzamiento"/>
            <form:errors path="fecha_lanzamiento"/>

            <form:label path="rating">Rating:</form:label>
            <form:input type="number" path="rating" step="0.5"/>
            <form:errors path="rating"/>

            <input type="hidden" name="id" value="${videojuego.id}"/>
            <input type="hidden" name="precio" value="${videojuego.precio}"/>

            <input type="submit" value="Editar"/>
        </form:form> 
        <a href="/getAll">Volver</a>
    </body>
</html>