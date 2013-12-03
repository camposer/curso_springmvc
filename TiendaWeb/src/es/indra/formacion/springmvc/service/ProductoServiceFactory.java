package es.indra.formacion.springmvc.service;

public abstract class ProductoServiceFactory {
	private static IProductoService productoService = 
			new ProductoService();
	
	public static IProductoService createProductoService() {
		return productoService;
	}
}
