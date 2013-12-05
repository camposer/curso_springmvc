package es.indra.formacion.springmvc.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.indra.formacion.springmvc.model.Producto;
import es.indra.formacion.springmvc.service.IProductoService;

@Controller
@RequestMapping("/carrito/*")
public class CarritoController {
	@Autowired
	IProductoService productoService;
	
	@RequestMapping("inicio")
	public String inicio(Model model) {
		model.addAttribute("productos", productoService.obtenerProductos());
		
		return "/inicio.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="agregar", method=RequestMethod.POST)
	public String agregar(@RequestParam("cantidad") String[] cantidades, @RequestParam("productoId") String[] productoIds, HttpSession sesion) {
		Object obj = sesion.getAttribute("productos");
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
					p.setCantidad(cantidad);					
					productos.add(p);
				}
				
			} catch (NumberFormatException nfe) { }
		}
		
		sesion.setAttribute("productos", productos);
		
		return "redirect:mostrar.do";

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("mostrar")
	public ModelAndView mostrar(HttpSession sesion) {
		List<Producto> productos = new LinkedList<Producto>();
		
		Object obj = sesion.getAttribute("productos");
		
		if (obj != null)
			productos = (List<Producto>) obj;
		
		return new ModelAndView("/mostrar.jsp", "productos", productos);
	}
}
