package com.bizpro.spring.proyectoQr.model;

public class Clientes {

	public Clientes() {

	}

	public Clientes(Long id, String cliente, int numeroCuenta) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.numeroCuenta = numeroCuenta;
	}

	private Long id;
	private String cliente;
	private int numeroCuenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	@Override
	public String toString() {
		return "Clientes [id=" + id + ", cliente=" + cliente + ", numeroCuenta=" + numeroCuenta + "]";
	}

}
