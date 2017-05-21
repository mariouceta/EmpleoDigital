<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Favoritos Existentes</title>
</head>
<body>
	<div>Favorito introducido con éxito</div>
	<h1>Lista de Viajes Favoritos</h1>
	<div>
		<table>
			<tr>
				<td>Destino</td>
				<td>Duración (días)</td>
				<td>Precio (Euros)</td>
				
			</tr>
			<c:forEach items="${sessionScope.favoritos}" var="viaje">
				<tr>
					<td>${viaje.destino}</td>
					<td>${viaje.duracion}</td>
					<td>${viaje.precio}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="inicio"><a href="Inicio">Volver al inicio.</a></div>
</body>
</html>