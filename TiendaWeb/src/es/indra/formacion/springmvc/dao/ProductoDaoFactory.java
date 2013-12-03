package es.indra.formacion.springmvc.dao;

public abstract class ProductoDaoFactory {
	public static IProductoDao createProductoDao() {
		return new ProductoDao();
	}
}
