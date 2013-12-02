package es.indra.formacion.springmvc.basico;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioServlet
 */
@WebServlet("/ProcesarFormulario")
public class ProcesarFormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarFormularioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String sexo = request.getParameter("sexo");
		String[] categorias = request.getParameterValues("categoria");
		String tipo = request.getParameter("tipo");

		// Inluyendo la cabecera
		getServletContext()
			.getRequestDispatcher("/Cabecera")
			.include(request, response);
		
		PrintWriter pw = response.getWriter();
		pw.println("Nombre: " + nombre + "<br>");
		pw.println("Descripción: " + descripcion + "<br>");
		pw.println("Sexo: " + sexo + "<br>");
		
		for (String c : categorias) 
			pw.println("Categoría: " + c + "<br>");
		
		pw.println("Tipo: " + tipo + "<br>");

		// Inluyendo la cabecera
		getServletContext()
			.getRequestDispatcher("/PiePagina")
			.include(request, response);

		pw.flush();
	}

}
