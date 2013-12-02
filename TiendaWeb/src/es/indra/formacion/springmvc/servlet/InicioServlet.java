package es.indra.formacion.springmvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet("/Inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String html = "<html>"+
				"	<head>"+
				"		<meta charset='iso-8859-1'>"+
				"	</head>"+
				"	<body>"+
				"		<center>"+
				"		<h1>Tienda de Equipos Electrónicos</h1>"+
				"		<form action='Agregar' method='POST'>"+
				"		<table>"+
				"			<tr>"+
				"				<th>Artículo</th>"+
				"				<th>Precio</th>"+
				"				<th>Cantidad</th>"+
				"			</tr>"+
				"			<tr>"+
				"				<td>Portátiles</td>"+
				"				<td>599</td>"+
				"				<td><input type='text' name='cantidad' size='3'/></td>"+
				"			</tr>"+
				"			<tr>"+
				"				<td>DVD</td>"+
				"				<td>230</td>"+
				"				<td><input type='text' name='cantidad' size='3'/></td>"+
				"			</tr>"+
				"			<tr>"+
				"				<td>Cámaras</td>"+
				"				<td>60</td>"+
				"				<td><input type='text' name='cantidad' size='3'/></td>"+
				"			</tr>"+
				"			<tr>"+
				"				<td colspan='3' align='center'><input type='submit' value='Agregar'/></td>"+
				"			</tr>"+
				"		</table>"+
				"		</form>"+
				"		</center>"+
				"	</body>"+
				"</html>";
		
		pw.println(html);
		pw.flush();
	}
}
