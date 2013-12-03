package es.indra.formacion.springmvc.dao;

import java.util.LinkedList;
import java.util.List;

import es.indra.formacion.springmvc.model.Producto;

public class ProductoDao implements IProductoDao {
	private List<Producto> productos;
	private int contador;

	public ProductoDao() {
		productos = new LinkedList<Producto>();
		contador = 1;
	}
	
	@Override
	public void agregar(Producto p) {
		p.setId(contador++);
		productos.add(p);
	}

	@Override
	public void modificar(Producto p) {
		int pos = buscarPos(p.getId());
		
		if (pos >= 0)
			productos.set(pos, p);
	}

	@Override
	public void eliminar(Integer id) {
		int pos = buscarPos(id);
		
		if (pos >= 0)
			productos.remove(pos);
	}

	@Override
	public Producto obtener(Integer id) {
		int pos = buscarPos(id);
		
		if (pos >= 0)
			return productos.get(pos);
		else
			return null;
	}

	private int buscarPos(Integer id) {
		int pos = -1;
		
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getId().equals(id)) {
				pos = i;
				break;
			}
		}
		
		return pos;
	}
	
	@Override
	public List<Producto> obtenerTodos() {
		return productos;
	}

	public static void main(String[] args) {
		// Probando
		IProductoDao dao = new ProductoDao();
		
		// Agregar
		Producto p = new Producto("Portátiles", 599f);
		
		dao.agregar(p);
		dao.agregar(new Producto("DVD", 230f));
		dao.agregar(new Producto("Cámaras", 60f));
		System.out.println(dao.obtenerTodos());
		
		// Modificar
		p.setNombre("Tabletas");
		dao.modificar(p);
		System.out.println(dao.obtenerTodos());

		// Eliminar
		dao.eliminar(1);
		System.out.println(dao.obtenerTodos());

		// Obtener
		System.out.println(dao.obtener(2));
	}
}
