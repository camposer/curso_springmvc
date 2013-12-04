package bean;

public class HelloWorld implements IHolaMundo {
	private String nombre = "Undefined";

	@Override
	public String holaMundo() {
		return "Hello: " + nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

}
