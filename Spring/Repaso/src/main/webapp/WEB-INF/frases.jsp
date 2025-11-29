<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>FRASES</title>
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
        <h2>Bienvenido de vuelta ${nombreCompleto}</h2>
        <ul>
            <c:forEach var="frase" items="${frases}">
                <li>${frase.texto}</li>
            </c:forEach>
        </ul>
    </body>
</html>