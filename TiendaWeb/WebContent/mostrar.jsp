<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.indra.formacion.springmvc.model.Producto"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1><spring:message code="mostrar.titulo"/></h1>
		<table>
			<tr>
				<th><spring:message code="mostrar.tabla.articulo"/></th>
				<th><spring:message code="mostrar.tabla.precio"/></th>
				<th><spring:message code="mostrar.tabla.cantidad"/></th>
				<th><spring:message code="mostrar.tabla.total"/></th>
			</tr>
			<%
				float totalTotal = 0;
				Object obj = request.getAttribute("productos");

				if (obj != null) {
					List<Producto> productos = (List<Producto>) obj;

					for (Producto p : productos) {
						float total = p.getPrecio() * p.getCantidad();
						totalTotal += total;
			%>

			<tr>
				<td><%=p.getNombre()%></td>
				<td><%=p.getPrecio()%></td>
				<td><input type='text' name='cantidad' size='3'
					value='<%=p.getCantidad()%>' /></td>
				<td><%=total%></td>
			</tr>
			<%
					}
				}
			%>

			<tr>
				<td colspan='3' align='right'><spring:message code="mostrar.tabla.pie.total"/></td>
				<td><%=totalTotal%></td>
			</tr>

			<tr>
				<td colspan='4' align='center'><a href='inicio.do'><spring:message code="mostrar.boton.inicio"/></a></td>
			</tr>
		</table>
		</form>
	</center>
</body>
</html>