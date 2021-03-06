package es.indra.formacion.springmvc.basico;

public class Singleton {
	private static Singleton INSTANCE = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		Singleton.getInstance();
		Singleton.getInstance();
		Singleton.getInstance();
	}
}
