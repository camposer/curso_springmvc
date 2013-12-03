package es.indra.formacion.springmvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.indra.formacion.springmvc.model.Producto;
import es.indra.formacion.springmvc.service.IProductoService;
import es.indra.formacion.springmvc.service.ProductoServiceFactory;

/**
 * Servlet implementation class AgregarServlet
 */
@WebServlet("/Agregar")
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductoService productoService = ProductoServiceFactory.createProductoService();
		
		String[] cantidades = request.getParameterValues("cantidad");
		String[] productoIds = request.getParameterValues("productoId");
		
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
		for (int i = 0; i < productoIds.length; i++) {
			String c = cantidades[i];
			int productoId = Integer.parseInt(productoIds[i]);
			
			Producto p = productoService.obtenerProducto(productoId);
			
			try {
				int cantidad = Integer.parseInt(c);
				float total = p.getPrecio() * cantidad;
				totalTotal += total;
				
				html += "			<tr>"+
					"				<td>" + p.getNombre() + "</td>"+
					"				<td>" + p.getPrecio() + "</td>"+
					"				<td><input type='text' name='cantidad' size='3' value='" + c + "'/></td>"+
					"				<td>" + total + "</td>"+
					"			</tr>";
				
			} catch (NumberFormatException nfe) { }
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
