<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table style="text-align: ">
<tr>
	<td colspan="1">Anuncios</td>
</tr>
<c:forEach var="anuncio" items="${listado}">
<tr>
	<td style="border: 1px solid black"><c:out value="${anuncio.texto }"></c:out></td>
</tr>

</c:forEach>

</table>
</body>
</html>