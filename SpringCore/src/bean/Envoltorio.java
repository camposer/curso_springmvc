package bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Envoltorio {
	@Autowired
	private IHolaMundo holaMundo1;
	
	public void imprimir() {
		System.out.println(holaMundo1.holaMundo());
	}

	public IHolaMundo getHolaMundo() {
		return holaMundo1;
	}

	public void setHolaMundo(IHolaMundo holaMundo1) {
		this.holaMundo1 = holaMundo1;
	}

}
