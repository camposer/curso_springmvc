package bean;

public class Envoltorio {
	private IHolaMundo cualquierCosa;
	
	public void imprimir() {
		System.out.println(cualquierCosa.holaMundo());
	}

	public IHolaMundo getHolaMundo() {
		return cualquierCosa;
	}

	public void setHolaMundo(IHolaMundo holaMundo) {
		this.cualquierCosa = holaMundo;
	}
}
