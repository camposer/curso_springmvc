package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Envoltorio;
import bean.IHolaMundo;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
						"config/applicationContext.xml"
					); 
		
		IHolaMundo holaMundo1 = context.getBean(
				"holaMundo1", 
				IHolaMundo.class);
		System.out.println(holaMundo1.holaMundo()); // => Hola: Sin nombre

		holaMundo1.setNombre("Rodolfo");
		System.out.println(holaMundo1.holaMundo()); // => Hola: Rodolfo

		holaMundo1 = context.getBean(
				"holaMundo1", 
				IHolaMundo.class);
		System.out.println(holaMundo1.holaMundo()); // => Hola: Rodolfo

		IHolaMundo holaMundo2 = context.getBean(
				"holaMundo2", 
				IHolaMundo.class);
		holaMundo2.setNombre("Juan");
		System.out.println(holaMundo2.holaMundo()); // => Hola: Juan

		holaMundo2 = context.getBean(
				"holaMundo2", 
				IHolaMundo.class);
		System.out.println(holaMundo2.holaMundo()); // => Hola: Sin nombre

		Envoltorio envoltorio1 = context.getBean(
				"envoltorio1", 
				Envoltorio.class);
		envoltorio1.imprimir(); // => Hello: Rodolfo

		Envoltorio envoltorio2 = context.getBean(
				"envoltorio2", 
				Envoltorio.class);
		envoltorio2.imprimir(); // => Hello: Undefined
		envoltorio2.getHolaMundo().setNombre("Pedro");
		
		envoltorio2 = context.getBean(
				"envoltorio2", 
				Envoltorio.class);
		envoltorio2.imprimir(); // => ?
	}

}
