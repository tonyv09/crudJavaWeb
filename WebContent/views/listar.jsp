<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar</title>
</head>
<body>
<table border="1">
<tr> <th>id</th><th>nombre</th><th>cantidad</th><th>precio</th><th>Fecha creacion</th><th>Fecha modificaciono</th> </tr>
  <tbody>
  <c:forEach var="producto" begin="0" items="${jsonProductos}">
   <tr>
   <td><a href="productos?opcion=meditar&id=<c:out value="${producto.id}"></c:out>"> <c:out value="${producto.id}"></c:out></a></td>
   <td> <c:out value="${producto.nombre}"></c:out></td>
   <td><c:out value="${producto.cantidad}"></c:out></td>
   <td><c:out value="${producto.precio}"></c:out></td>
   <td><c:out value="${producto.fechaCrear}"></c:out></td>
   <td><c:out value="${producto.fechaActualizar}"></c:out></td>
	 <td><a href="productos?opcion=eliminar&id=<c:out value="${producto.id}"></c:out>"> Eliminar</a></td>
   </tr>
   </c:forEach>
   </tbody>
  
</table>
</body>
</html>