<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<h1>Agencia de Viajes</h1>
	
	<div><p>Numero de usuarios en el sito web:	${applicationScope.numeroUsuarios}</p></div>
	
	<div>
		<table>
	
	<tr><td colspan="4"><p id="oferta">Oferta de la semana:</p></td></tr>
			<tr>
				<td>Destino</td>
				<td>Duración (días)</td>
				<td>Precio (Euros)</td>
				
			</tr>
			<tr>
				<td><c:out value="${oferta.destino}"></c:out></td>
				<td><c:out value="${oferta.duracion}"></c:out></td>
				<td><c:out value="${oferta.precio}"></c:out></td>
				<td><a href="IntroducirFavorito?id=${oferta.id}"><button>Añadir a Favoritos</button></a></td>
			</tr>
	</table>
	</div>
	
	
	<div>
		<table>
			<tr>
				<td><a href="Listar">Listado completo de viajes</a></td>
			</tr>
			<tr>
				<td><a href="formularioBuscar.jsp">Búsqueda de viajes</a></td>
			</tr>
		</table>
	</div>
</body>
</html>