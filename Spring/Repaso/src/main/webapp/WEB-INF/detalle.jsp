<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Detalle de Frase</title>
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
        <h2>"${frase.texto}"</h2>
        <ul>
            <li><b>Creador:</b>${frase.creador.nombre} ${frase.creador.apellido}</li>
            <li><b>Autor Original:</b>${frase.autor}</li>
            <li><b>Categoría/Tema:</b>${frase.categoria}</li>
            <li><b>Idioma:</b>${frase.idioma}</li>
        </ul>
        <c:if test="${fn:length(frase.usuariosFavoritos) > 0}">
            <h4>Usuarios que han marcado como favorita esta frase:</h4>
            <ul>
                <c:forEach var="usuario" items="${frase.usuariosFavoritos}">
                    <li>${usuario.nombre} ${usuario.apellido}</li>
                </c:forEach>
            </ul>
        </c:if>
        <c:if test="${frase.creador.id == idUsuario}">
            <form:form action="/delete/${frase.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <button>Eliminar frase</button>
            </form:form>             
        </c:if>
    </body>
</html>