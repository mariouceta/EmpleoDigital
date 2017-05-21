<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="eS_ES"/>
<div>
	<table>
		<tr>
			<td>Destino</td>
			<td>Duración (días)</td>
			<td>Precio (Euros)</td>
			
		</tr>
		<c:forEach items="${lista}" var="viaje">
			<tr>
				<td><c:out value="${viaje.destino}"></c:out></td>
				<td><c:out value="${viaje.duracion}"></c:out></td>
				<td><c:out value="${viaje.precio}"></c:out></td>
				<td><a href="IntroducirFavorito?id=${viaje.id}"><button>Añadir a Favoritos</button></a></td>
			</tr>
		</c:forEach>
	</table>
</div>