<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Mis Favoritos</title>
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
        <h2>Estas son tus frases favoritas</h2>
        <table border="1">
            <thead>
                <th>Frase motivacional</th>
                <th>Detalle</th>
                <th>Modificar</th>
                <th>Me gusta</th>
            </thead>
            <tbody>
                <c:forEach var="frase" items="${favsUsuario}">
                    <tr>
                        <td>${frase.texto}</td>
                        <td><a href="/detail/${frase.id}">Ver</a></td>
                        <td>
                            <c:if test="${frase.creador.id == idUsuario}">
                                <a href="/form/edit/${frase.id}">Editar</a>
                            </c:if>
                        </td>
                        <td>
                            <form:form action="/removeFav/${frase.id}">
                                <input type="hidden" name="_method" value="PUT"/>
                                <button style="font-size: 27px">&#9829;</button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>