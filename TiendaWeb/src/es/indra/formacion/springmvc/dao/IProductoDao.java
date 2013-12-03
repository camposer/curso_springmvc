package es.indra.formacion.springmvc.dao;

import java.util.List;

import es.indra.formacion.springmvc.model.Producto;

public interface IProductoDao {
	public void agregar(Producto p);
	public void modificar(Producto p);
	public void eliminar(Integer id);
	public Producto obtener(Integer id);
	public List<Producto> obtenerTodos();
}
