package es.indra.formacion.springmvc.controller;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HolaMundoController {
	@RequestMapping("/holaMundo")
	public @ResponseBody String holaMundo() {
		return "Hola mundo";
	}
	
	@RequestMapping("/holaMundo1")
	public @ResponseBody String holaMundo(@RequestParam String nombre) {
		return "Hola: " + nombre;
	}

	@RequestMapping("/holaMundo2")
	public @ResponseBody String holaMundo(HttpServletRequest request) {
		return "Hola: " + request.getParameter("nombre");
	}

	@RequestMapping("/holaMundo3")
	public String holaMundo3(Model model, @RequestParam String nombre, @RequestParam Integer edad) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("edad", edad);
		
		return "/holaMundo.jsp";
	}
	
	@RequestMapping("/holaMundo4")
	public ModelAndView holaMundo3(@RequestParam String nombre, @RequestParam Integer edad) {
		Map<String, Object> model = new Hashtable<String, Object>();
		
		model.put("nombre", nombre);
		model.put("edad", edad);
		
		return new ModelAndView("/holaMundo.jsp", model);
	}

	@RequestMapping("/holaMundo5")
	public ModelAndView holaMundo3(Persona persona) {
		Map<String, Object> model = new Hashtable<String, Object>();
		
		model.put("nombre", persona.getNombre());
		model.put("edad", persona.getEdad());
		
		return new ModelAndView("/holaMundo.jsp", model);
	}

	@RequestMapping("/holaMundo6")
	public void holaMundo3(HttpServletRequest request, HttpServletResponse response, Persona persona) throws ServletException, IOException {
		request.setAttribute("nombre", persona.getNombre());
		request.setAttribute("edad", persona.getEdad());
		
		request
			.getServletContext()
			.getRequestDispatcher("/holaMundo.jsp")
			.forward(request, response);
	}

}

class Persona {
	private String nombre;
	private Integer edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
}