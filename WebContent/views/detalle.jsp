<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr> <th>id</th><th>nombre</th><th>cantidad</th><th>precio</th><th>Fecha creacion</th><th>Fecha modificaciono</th> </tr>
  <tbody>
  <tr>
     <td> <c:out value="${producto.id}"></c:out></td>
   <td> <c:out value="${producto.nombre}"></c:out></td>
   <td><c:out value="${producto.cantidad}"></c:out></td>
   <td><c:out value="${producto.precio}"></c:out></td>
   <td><c:out value="${producto.fechaCrear}"></c:out></td>
   <td><c:out value="${producto.fechaActualizar}"></c:out></td>
  </tr>
  </tbody>
  </table>
  <h1>Crear producto</h1>

<form action="productos" method ="post">
<input type="hidden" name="opcion" value="editar">
<input type="hidden" name="id" value="<c:out value="${producto.id}"></c:out>">
<table border="1">
<tr> <td>Nombre: </td> <td> <input type="text" name="nombre" size="50" value="<c:out value="${producto.nombre}"></c:out>"> </td> </tr>
<tr> <td>Cantidad: </td><td> <input type="text" name="cantidad" size="50" value="<c:out value="${producto.cantidad}"></c:out>"> </td> </tr>
<tr> <td>Precio: </td><td> <input type="text" name="precio" size="50" value="<c:out value="${producto.precio}"></c:out>"> </td> </tr>
</table>
<button type="submit" value="edit">Enviar</button>
</form>
  
</body>
</html>