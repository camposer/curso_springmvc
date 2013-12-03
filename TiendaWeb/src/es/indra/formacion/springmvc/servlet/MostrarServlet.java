package es.indra.formacion.springmvc.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.springmvc.model.Producto;

/**
 * Servlet implementation class MostrarServlet
 */
@WebServlet("/Mostrar")
public class MostrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> productos = new LinkedList<Producto>();
		
		Object obj = request.getSession().getAttribute("productos");
		
		if (obj != null)
			productos = (List<Producto>) obj;
		
		String html = "<html>"+
				"	<head>"+
				"		<meta charset='iso-8859-1'>"+
				"	</head>"+
				"	<body>"+
				"		<center>"+
				"		<h1>Tienda de Equipos Electrónicos</h1>"+
				"		<table>"+
				"			<tr>"+
				"				<th>Artículo</th>"+
				"				<th>Precio</th>"+
				"				<th>Cantidad</th>"+
				"				<th>Total</th>"+
				"			</tr>";


		float totalTotal = 0;
		for (Producto p : productos) {
			float total = p.getPrecio() * p.getCantidad();
			totalTotal += total;
				
			html += "			<tr>"+
				"				<td>" + p.getNombre() + "</td>"+
				"				<td>" + p.getPrecio() + "</td>"+
				"				<td><input type='text' name='cantidad' size='3' value='" + p.getCantidad() + "'/></td>"+
				"				<td>" + total + "</td>"+
				"			</tr>";
		}
		
		html += "			<tr>"+
				"				<td colspan='3' align='right'>Total</td>"+
				"				<td>" + totalTotal + "</td>"+
				"			</tr>";

		html += "		<tr>"+
			"				<td colspan='4' align='center'><a href='Inicio'>Inicio</a></td>"+
			"			</tr>"+
			"		</table>"+
			"		</form>"+
			"		</center>"+
			"	</body>"+
			"</html>";

		response.getWriter().println(html);
		response.getWriter().flush();

	}

}
