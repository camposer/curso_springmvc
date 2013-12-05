package es.indra.formacion.springmvc.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.indra.formacion.springmvc.model.Producto;
import es.indra.formacion.springmvc.service.IProductoService;
import es.indra.formacion.springmvc.service.ProductoServiceFactory;

@Controller
@RequestMapping("/carrito/*")
public class CarritoController {
	
	@RequestMapping("inicio")
	public void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductoService productoService = 
				ProductoServiceFactory.createProductoService();
		
		List<Producto> productos = productoService.obtenerProductos();
		request.setAttribute("productos", productos);
		
		request.getServletContext()
			.getRequestDispatcher("/inicio.jsp")
			.forward(request, response);

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="agregar", method=RequestMethod.POST)
	public void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		response.sendRedirect("mostrar.do");

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("mostrar")
	public void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> productos = new LinkedList<Producto>();
		
		Object obj = request.getSession().getAttribute("productos");
		
		if (obj != null)
			productos = (List<Producto>) obj;
		
		request.setAttribute("productos", productos);
		
		request.getServletContext()
			.getRequestDispatcher("/mostrar.jsp")
			.forward(request, response);

		
	}
}
