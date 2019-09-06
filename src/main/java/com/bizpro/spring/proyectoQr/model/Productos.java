package com.bizpro.spring.proyectoQr.model;

public class Productos {

	public Productos() {

	}

	
	
	public Productos(Long id, String nombreProducto, String descripcionProducto, double precio, String categoria,
			String image, int stock) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precio = precio;
		Categoria = categoria;
		this.image = image;
		this.stock = stock;
	}



	/*
	 * Productos ->Precio -> Cantidad Total Tienda No.Empleado (editado)
	 */

	private Long id;
	private String nombreProducto;
	private String descripcionProducto;
	private double precio;
	private String Categoria;
	private String image;
	private int stock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombreProducto=" + nombreProducto + ", descripcionProducto="
				+ descripcionProducto + ", precio=" + precio + ", Categoria=" + Categoria + ", image=" + image
				+ ", stock=" + stock + "]";
	}

}
