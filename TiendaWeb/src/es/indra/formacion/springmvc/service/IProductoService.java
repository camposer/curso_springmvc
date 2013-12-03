package es.indra.formacion.springmvc.service;

import java.util.List;

import es.indra.formacion.springmvc.model.Producto;

public interface IProductoService {
	public void agregarProducto(Producto p);
	public void modificarProducto(Producto p);
	public void eliminarProducto(Integer id);
	public Producto obtenerProducto(Integer id);
	public List<Producto> obtenerProductos();
}
