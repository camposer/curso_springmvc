package es.indra.formacion.springmvc.service;

import java.util.List;

import es.indra.formacion.springmvc.dao.IProductoDao;
import es.indra.formacion.springmvc.dao.ProductoDaoFactory;
import es.indra.formacion.springmvc.model.Producto;

public class ProductoService implements IProductoService {
	IProductoDao productoDao;
	
	public ProductoService() {
		productoDao = ProductoDaoFactory.createProductoDao();
		init();
	}

	private void init() {
		productoDao.agregar(new Producto("Portátiles", 599f));
		productoDao.agregar(new Producto("DVD", 230f));
		productoDao.agregar(new Producto("Cámaras", 60f));
		productoDao.agregar(new Producto("Monitor", 150f));
	}
	
	@Override
	public void agregarProducto(Producto p) {
		productoDao.agregar(p);
	}

	@Override
	public void modificarProducto(Producto p) {
		productoDao.modificar(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		productoDao.eliminar(id);
	}

	@Override
	public Producto obtenerProducto(Integer id) {
		return productoDao.obtener(id);
	}

	@Override
	public List<Producto> obtenerProductos() {
		return productoDao.obtenerTodos();
	}

}
