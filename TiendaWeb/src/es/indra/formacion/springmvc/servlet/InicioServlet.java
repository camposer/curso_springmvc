package es.indra.formacion.springmvc.servlet;

import java.io.IOException;
import java.util.List;

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
		
		List<Producto> productos = productoService.obtenerProductos();
		request.setAttribute("productos", productos);
		
		getServletContext()
			.getRequestDispatcher("/inicio.jsp")
			.forward(request, response);
	}
}
