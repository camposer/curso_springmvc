package es.indra.formacion.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import es.indra.formacion.springmvc.model.Producto;

@Component
public class ProductoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clase) {
		return Producto.class.equals(clase);
	}

	@Override
	public void validate(Object obj, Errors errores) {
		Producto p = (Producto) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errores, "nombre", "producto.error.nombreInvalido");
		ValidationUtils.rejectIfEmptyOrWhitespace(errores, "precio", "producto.error.precioInvalido");
		
		if (p.getPrecio() != null && p.getPrecio() <= 0)
			errores.rejectValue("precio", "producto.error.precioMenorQue0");
	}
}
