<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear</title>
</head>
<body>
<h1>Crear producto</h1>

<form action="productos" method ="post">
<input type="hidden" name="opcion" value="save">
<table border="1">
<tr> <td>Nombre: </td> <td> <input type="text" name="nombre" size="50"> </td> </tr>
<tr> <td>Cantidad: </td><td> <input type="text" name="cantidad" size="50"> </td> </tr>
<tr> <td>Precio: </td><td> <input type="text" name="precio" size="50"> </td> </tr>
</table>
<button type="submit" value="save">Enviar</button>
</form>
</body>
</html>