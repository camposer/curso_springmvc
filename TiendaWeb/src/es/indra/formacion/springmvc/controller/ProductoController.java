package es.indra.formacion.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import es.indra.formacion.springmvc.editor.PrecioEditor;
import es.indra.formacion.springmvc.model.Producto;
import es.indra.formacion.springmvc.service.IProductoService;
import es.indra.formacion.springmvc.validator.ProductoValidator;

@Controller
@RequestMapping("/producto/*")
public class ProductoController {
	@Autowired
	IProductoService productoService;
	@Autowired
	ProductoValidator productoValidator;

	/*
	@ModelAttribute("producto")
	public Producto obtenerProducto() {
		return new Producto();
	}
	*/
	
	@RequestMapping("inicio")
	public String index(Model model) {
		model.addAttribute("producto", new Producto());
		
		return "/producto/inicio.jsp";
	}
	
	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Float.class, new PrecioEditor());
		binder.setValidator(productoValidator);
	}
	
	@RequestMapping("agregar")
	public String agregar(@ModelAttribute("producto") @Valid Producto producto, BindingResult result) {
		
		if (!result.hasErrors())
			productoService.agregarProducto(producto);
		
		return "/producto/inicio.jsp";
	}
}





