<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Login</title>
        <link rel="stylesheet" href="/css/styles.css" />
    </head>
    <body>
        <h1>FRASES</h1>
        <ul id="nav">
            <li><a href="/">Login</a></li>
            <li><a href="/form/registro">Registro</a></li>
        </ul>
        <h2>Login</h2>
        <form:form action="/login" method="POST" modelAttribute="loginUsuario">

            <form:label path="correo">Correo Electrónico:</form:label>
            <form:input path="correo" type="text" />
            <form:errors path="correo" class="error" />

            <form:label path="password">Contraseña:</form:label>
            <form:input path="password" type="password" />
            <form:errors path="password" class="error" />

            <input type="submit" value="Login" />
        </form:form>
    </body>
</html>