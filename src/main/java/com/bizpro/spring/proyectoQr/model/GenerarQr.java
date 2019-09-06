package com.bizpro.spring.proyectoQr.model;

import java.util.ArrayList;

public class GenerarQr {

	private String nombre;
	private double total;
	private int numeroCuenta;
	private ArrayList<Productos> lista = new ArrayList<>();
	private int numeroEmpleado;
	private double sumaTotal;
	
	public GenerarQr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GenerarQr(String nombre, double total, int numeroCuenta, ArrayList<Productos> lista, int numeroEmpleado,
			double sumaTotal) {
		super();
		this.nombre = nombre;
		this.total = total;
		this.numeroCuenta = numeroCuenta;
		this.lista = lista;
		this.numeroEmpleado = numeroEmpleado;
		this.sumaTotal = sumaTotal;
	}

	/*
	 * public GenerarQr(double total, int numeroCuenta, ArrayList<Productos> lista)
	 * { super(); this.total = total; this.numeroCuenta = numeroCuenta; this.lista =
	 * lista; }
	 */

	public double getTotal() {
		for (int i = 0; i < lista.size(); i++) {
			total += lista.get(i).getPrecio();
		}
		System.out.println("is a total " + total);

		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getNumeroCuenta() {	
		numeroCuenta = 919191111;
		System.out.println("this is number of cuenta " + numeroCuenta);
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public ArrayList<String> getLista() {
		ArrayList<String> nombre = new ArrayList<>();		
		for (int i = 0; i < lista.size(); i++) {
			 nombre.add(lista.get(i).getNombreProducto());
		}
		System.out.println("is a nombre " + nombre);
		return nombre;
	}

	public void setLista(ArrayList<Productos> lista) {
		this.lista = lista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public double getSumaTotal() {
		return sumaTotal;
	}

	public void setSumaTotal(double sumaTotal) {
		this.sumaTotal = sumaTotal;
	}

	
}
