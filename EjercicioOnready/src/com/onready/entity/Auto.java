package com.onready.entity;

public class Auto extends Vehiculo {

	private int puertas;
	
	public Auto(String marca, String modelo, int puertas, double precio) {
		super(marca, modelo, precio);
		this.puertas = puertas;
	}
	
	@Override
	public String toString() {
		return "Marca: " + this.marca + " // Modelo: " + this.modelo + " // Puertas: " + this.puertas 
				+ " // Precio: $" + String.format("%1$,.2f", this.precio);
	}
}
