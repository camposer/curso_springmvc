<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hola Mundo</title>
</head>
<body>
	Hola <%= request.getParameter("nombre") %><br/>
	Tu edad es: <%= request.getParameter("edad") %><br/>
	
	<%
		int edad = Integer.parseInt(request.getParameter("edad"));
	
		if (edad >= 18) {
	%>
		<font color="blue">Puedes conducir</font>
	<% } else { %>
		<font color="red">No puedes conducir</font>
	<% } %>
</body>
</html>