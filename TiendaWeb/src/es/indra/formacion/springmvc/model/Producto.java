package es.indra.formacion.springmvc.model;

import java.io.Serializable;

public class Producto implements Serializable {
	private static final long serialVersionUID = 6580173244549492716L;

	private Integer id;
	private String nombre;
	private Float precio; 
	private Float cantidad;
	
	public Producto() {
	}
	
	public Producto(Integer id, String nombre, Float precio, Float cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Producto(String nombre, Float precio) {
		this(null, nombre, precio, null);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio="
				+ precio + ", cantidad=" + cantidad + "]";
	}
}
