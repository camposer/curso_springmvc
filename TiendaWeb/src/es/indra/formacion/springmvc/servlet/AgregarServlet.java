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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductoService productoService = ProductoServiceFactory.createProductoService();
		
		String[] cantidades = request.getParameterValues("cantidad");
		String[] productoIds = request.getParameterValues("productoId");
		
		Object obj = request.getSession().getAttribute("productos");
		List<Producto> productos = null;
		
		if (obj == null)
			productos = new LinkedList<Producto>();
		else
			productos = (List<Producto>) obj;
		
		for (int i = 0; i < productoIds.length; i++) {
			try {
				int cantidad = Integer.parseInt(cantidades[i]);
				int productoId = Integer.parseInt(productoIds[i]);
				
				Producto p = productoService.obtenerProducto(productoId);
				p.setCantidad(cantidad);
				
				boolean encontrado = false;
				for (int j = 0; j < productos.size(); j++) {
					Producto prod = productos.get(j);

					if (prod.getId().equals(p.getId())) {
						int cantidadResultante = prod.getCantidad() + cantidad;
						
						if (cantidadResultante > 0) 
							prod.setCantidad(cantidadResultante);
						else
							productos.remove(j);
						
						encontrado = true;
						break;
					}
				}
				
				if (!encontrado) {
					productos.add(p);
				}
				
			} catch (NumberFormatException nfe) { }
		}
		
		request.getSession().setAttribute("productos", productos);
		
		response.sendRedirect("Mostrar");
	}

}
