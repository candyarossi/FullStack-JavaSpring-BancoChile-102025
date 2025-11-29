<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Registrarse</title>
        <link rel="stylesheet" href="/css/styles.css" />
    </head>
    <body>
        <h1>FRASES</h1>
        <ul id="nav">
            <li><a href="/">Login</a></li>
            <li><a href="/form/registro">Registro</a></li>
        </ul>
        <h2>Registro</h2>
        <form:form action="/register" method="POST" modelAttribute="usuario">

            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" type="text" />
            <form:errors path="nombre" class="error" />

            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" type="text" />
            <form:errors path="apellido" class="error" />

            <form:label path="correo">Correo Electrónico:</form:label>
            <form:input path="correo" type="text" />
            <form:errors path="correo" class="error" />

            <form:label path="password">Contraseña:</form:label>
            <form:input path="password" type="password" />
            <form:errors path="password" class="error" />

            <form:label path="confirmarPassword">Confirmar Contraseña:</form:label>
            <form:input path="confirmarPassword" type="password" />
            <form:errors path="confirmarPassword" class="error" />

            <input type="submit" value="Registrarse" />
        </form:form>
    </body>
</html>