package com.onready.entity;

public class Moto extends Vehiculo {

	private int cilindrada;

	public Moto(String marca, String modelo, int cilindrada, double precio) {
		super(marca, modelo, precio);
		this.cilindrada = cilindrada;
	}
	
	@Override
	public String toString() {
		return "Marca: " + this.marca + " // Modelo: " + this.modelo + " // Cilindrada: " + this.cilindrada
				+ "c // Precio: $" + String.format("%1$,.2f", this.precio);
	}
}
