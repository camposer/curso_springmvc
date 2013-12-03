package es.indra.formacion.springmvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String[] cantidades = request.getParameterValues("cantidad");
		
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


		
		for (String c : cantidades) {
			try {
				Integer.parseInt(c);
				
				html += "			<tr>"+
					"				<td>XX</td>"+
					"				<td>XX</td>"+
					"				<td><input type='text' name='cantidad' size='3' value='" + c + "'/></td>"+
					"			</tr>";
				
			} catch (NumberFormatException nfe) { }
		}
		
		html += "			<tr>"+
			"				<td colspan='3' align='center'><input type='submit' value='Agregar'/></td>"+
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
