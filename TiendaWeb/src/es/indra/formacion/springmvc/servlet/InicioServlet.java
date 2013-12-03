package es.indra.formacion.springmvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.indra.formacion.springmvc.model.Producto;
import es.indra.formacion.springmvc.service.IProductoService;
import es.indra.formacion.springmvc.service.ProductoServiceFactory;

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
		IProductoService productoService = 
				ProductoServiceFactory.createProductoService();
		
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
				"			</tr>";
		
		for (Producto p : productoService.obtenerProductos()) {
			html += "			<tr>"+
				"				<td>" + p.getNombre() + "</td>"+
				"				<td>" + p.getPrecio() + "</td>"+
				"				<td><input type='text' name='cantidad' size='3'/></td>"+
				"			</tr>";
		}
				html += "			<tr>"+
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
