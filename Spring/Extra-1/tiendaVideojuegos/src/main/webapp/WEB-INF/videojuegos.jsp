<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Videojuegos</title>
        <link rel="stylesheet" href="/css/styles.css">
    </head>
    <body>
        <div class="nav">
			<h3>¡Bienvenido/a ${usuario.nombre} ${usuario.apellido}!</h3>
			<h3 class="precio" id="coins">$${usuario.coins}</h3>
            <a href="/form/add">Crear Videojuego</a>
			<a href="/logout">Salir</a>
        </div>
        <div class="content">
	        <div class="vPlataforma">
	            <h1>Mis Videojuegos</h1>
	            <ul class="videojuegos">
					<c:forEach var="juego" items="${misVideojuegos}">
						<li>
			                <img src="${juego.portada}"/>
			                <h3>${juego.nombre}</h3>
			                <a href="/detail/${juego.id}">Detalles</a>
							<c:if test="${juego.creador.id == usuario.id}">
								<a href="/form/edit/${juego.id}">Editar</a>
								<form action="/delete/${juego.id}" method="POST">
									<input type="hidden" name="_method" value="DELETE"/>
									<button>Eliminar</button>
								</form>
							</c:if>
			            </li>
					</c:forEach>
	            </ul>
	        </div>
	        <div class="vComunidad">
	            <h1>Videojuegos de la Comunidad</h1>
	            <ul class="videojuegos">
		            <c:forEach var="juego" items="${videojuegos}">
			            <li>
			                <img src="${juego.portada}"/>
			                <h3>${juego.nombre}</h3>
			                <a href="/detail/${juego.id}">Detalles</a>
							<c:if test="${juego.creador.id == usuario.id}">
								<a href="/form/edit/${juego.id}">Editar</a>
								<form action="/delete/${juego.id}" method="POST">
									<input type="hidden" name="_method" value="DELETE"/>
									<button>Eliminar</button>
								</form>
							</c:if>
							<c:if test="${juego.creador.id != usuario.id}">
				            	<a class="precio" href="/buy/${juego.id}">$${juego.precio}</a>
							</c:if>
			            </li>
		            </c:forEach>
	            </ul>
	        </div>
        </div>
        <script src="/js/script.js"></script>
    </body>
</html>