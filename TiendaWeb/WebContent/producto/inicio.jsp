<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="es.indra.formacion.springmvc.model.Producto" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Producto</title>
</head>
<body>
	<h1>Producto</h1>
	<form:form action="agregar.do" commandName="producto" method="POST">
		<form:errors path="*" cssStyle="color: red; background-color: lightgray;"/>
		<table>
			<tr>
				<td>Id:</td>
				<td><form:input path="id" readonly="true"/></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="nombre"/><form:errors path="nombre" cssStyle="color: red; background-color: lightgray;"/></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><form:input path="precio"/><form:errors path="precio" cssStyle="color: red; background-color: lightgray;"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Agregar" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>