package es.indra.formacion.springmvc.basico;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	doPost(request, response);
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

		HttpSession sesion = request.getSession();
		// Para borrar la sesión
		//sesion.invalidate();
		
		// Guardando datos en la sesión
		if (nombre != null)
			sesion.setAttribute("nombre", nombre);
		if (descripcion != null)
			sesion.setAttribute("descripcion", descripcion);
		if (sexo != null)
			sesion.setAttribute("sexo", sexo);
		if (categorias != null)
			sesion.setAttribute("categorias", categorias);
		if (tipo != null)
			sesion.setAttribute("tipo", tipo);
		
		// Inluyendo la cabecera
		getServletContext()
			.getRequestDispatcher("/Cabecera")
			.include(request, response);
		
		PrintWriter pw = response.getWriter();
		
		// Datos de la petición (request)
		pw.println("<h1>Datos del request</h1>");
		pw.println("Nombre: " + nombre + "<br>");
		pw.println("Descripción: " + descripcion + "<br>");
		pw.println("Sexo: " + sexo + "<br>");
		
		if (categorias != null)
			for (String c : categorias) 
				pw.println("Categoría: " + c + "<br>");
		
		pw.println("Tipo: " + tipo + "<br>");

		// Datos de la sesión (session)
		pw.println("<h1>Datos de la sesión</h1>");
		pw.println("Nombre: " + sesion.getAttribute("nombre") + "<br>");
		pw.println("Descripción: " + sesion.getAttribute("descripcion") + "<br>");
		pw.println("Sexo: " + sesion.getAttribute("sexo") + "<br>");
		
		if (sesion.getAttribute("categorias") != null)
			categorias = (String[])sesion.getAttribute("categorias");
		
		if (categorias != null)
			for (String c : categorias) 
				pw.println("Categoría: " + c + "<br>");
		
		pw.println("Tipo: " + sesion.getAttribute("tipo") + "<br>");

		pw.println("<p align='center'><a href='ProcesarFormulario'>Recargar</a>&nbsp;<a href='formulario.html'>Formulario</a></p>");
		
		// Inluyendo la cabecera
		getServletContext()
			.getRequestDispatcher("/PiePagina")
			.include(request, response);

		pw.flush();
	}

}
