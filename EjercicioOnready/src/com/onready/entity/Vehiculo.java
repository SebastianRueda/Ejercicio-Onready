package com.onready.entity;

public class Vehiculo implements Comparable<Vehiculo> {
	
	protected String marca;
	protected String modelo;
	protected double precio;
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(String marca, String modelo, double precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	
	@Override
	public int compareTo(Vehiculo o) {
		return (int) (o.precio - this.precio);
	}

}
