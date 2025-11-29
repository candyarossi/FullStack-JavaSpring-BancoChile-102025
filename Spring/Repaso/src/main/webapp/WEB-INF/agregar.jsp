<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Agregar Frase</title>
        <link rel="stylesheet" href="/css/styles.css" />
    </head>
    <body>
        <h1>FRASES</h1>
        <ul id="nav">
            <li><a href="/favoritos">Mis Favoritos</a></li>
            <li><a href="/frases">Todas las Frases</a></li>
            <li><a href="/form/add">Agregar Frase</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
        <h2>Agregar Nueva Frase</h2>
        <form:form action="/add" method="POST" modelAttribute="frase">

            <form:label path="texto">Frase:</form:label>
            <form:input path="texto" type="text" />
            <form:errors path="texto" class="error" />

            <form:label path="autor">Autor original:</form:label>
            <form:input path="autor" type="text" />
            <form:errors path="autor" class="error" />

            <form:label path="categoria">Categoría/Tema:</form:label>
            <form:input path="categoria" type="text" />
            <form:errors path="categoria" class="error" />

            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" type="text" />
            <form:errors path="idioma" class="error" />

            <input type="hidden" value="${idUsuario}" name="creador" />

            <input type="submit" value="Agregar" />
        </form:form>
    </body>
</html>