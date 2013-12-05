<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.indra.formacion.springmvc.model.Producto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC -//W3C//DTD HTML 4.01 Transitional//EN
http://www.w3.org/TR/html4/loose.dtd>
<html>
<head>
<meta http-equiv=Content-Type content=text/html; charset=UTF-8>
<title>Insert title here</title>
</head>
<body>

	<center>
		<h1>Tienda de Equipos Electrónicos</h1>
		<form action='agregar.do' method='POST'>
			<table>
				<tr>
					<th>Artículo</th>
					<th>Precio</th>
					<th>Cantidad</th>
				</tr>

				<%
					Object obj = request.getAttribute("productos");
					if (obj != null) {
						List<Producto> productos = (List<Producto>) obj;

						for (Producto p : productos) {
				%>
				<tr>
					<td><input type='hidden' name='productoId'
						value='<%=p.getId()%>' /><%=p.getNombre()%></td>
					<td><%=p.getPrecio()%></td>
					<td><input type='text' name='cantidad' size='3' /></td>
				</tr>
				<%
						}
					}
				%>

				<tr>
					<td colspan='3' align='center'><input type='submit'
						value='Agregar' /><a href='mostrar.do'><input type='button'
							value='Carrito' /></a></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>