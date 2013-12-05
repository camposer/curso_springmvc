<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.indra.formacion.springmvc.model.Producto"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC -//W3C//DTD HTML 4.01 Transitional//EN
http://www.w3.org/TR/html4/loose.dtd>
<html>
<head>
<meta http-equiv=Content-Type content=text/html; charset=UTF-8>
<title>Insert title here</title>
</head>
<body>

	<center>
		<h1><spring:message code="inicio.titulo"/></h1>
		<form action='agregar.do' method='POST'>
			<table>
				<tr>
					<th><spring:message code="inicio.tabla.articulo"/></th>
					<th><spring:message code="inicio.tabla.precio"/></th>
					<th><spring:message code="inicio.tabla.cantidad"/></th>
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
						value='<spring:message code="inicio.boton.agregar"/>' /><a href='mostrar.do'><input type='button'
							value='<spring:message code="inicio.boton.carrito"/>' /></a></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>