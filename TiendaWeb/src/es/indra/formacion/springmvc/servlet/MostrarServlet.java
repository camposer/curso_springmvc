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
		
		request.setAttribute("productos", productos);
		
		getServletContext()
			.getRequestDispatcher("/mostrar.jsp")
			.forward(request, response);

	}

}
