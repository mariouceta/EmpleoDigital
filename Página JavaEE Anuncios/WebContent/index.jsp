<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de bienvenida</title>
</head>
<body>


<c:set var="totalAnuncios" value="${0}"></c:set>
<c:forEach var="anuncio" items="${listado}">
	<c:set var="totalAnuncios" value="${totalAnuncios+1}"></c:set>
</c:forEach>

<h1 style="text-align: center;">Bienvenida</h1>

<p>Número de anuncios totales: ${totalAnuncios}</p>
<p>Conexiones a la página: ${nSesiones}</p>

<br>
<a href="mostrarAnuncios.jsp">Mostrar todos los anuncios</a>

</body>
</html>