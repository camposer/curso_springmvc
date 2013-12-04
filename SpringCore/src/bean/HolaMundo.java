package bean;

public class HolaMundo implements IHolaMundo {
	private String nombre = "Sin nombre";
	
	public String holaMundo() {
		return "Hola: " + nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
