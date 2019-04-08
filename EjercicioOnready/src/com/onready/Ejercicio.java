package com.onready;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.onready.entity.Auto;
import com.onready.entity.Moto;
import com.onready.entity.Vehiculo;

public class Ejercicio {
	private File archivo;
	private List<Vehiculo> vehiculos;

	public Ejercicio(String path) {
		this.archivo = new File(path);
		this.vehiculos = new ArrayList<Vehiculo>();
		this.leerArchivo();
	}

	private void leerArchivo() {
		Scanner sc = null;

		try {
			sc = new Scanner(archivo);
			sc.useLocale(Locale.ENGLISH);

			while (sc.hasNextLine()) {

				String line = sc.nextLine();
				String[] v = line.split(" ");
				
				switch (v[0]) {
				case "Auto":
					this.vehiculos.add(new Auto(v[1], v[2], Integer.parseInt(v[3]), Double.parseDouble(v[4])));
					break;

				case "Moto":
					this.vehiculos.add(new Moto(v[1], v[2], Integer.parseInt(v[3]), Double.parseDouble(v[4])));
					break;
					
				default:
					break;
				}
				
			}

		} catch (FileNotFoundException e) {
			System.err.println("Error Archivo");
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public void resolver() {

		for (Vehiculo vehiculo : this.vehiculos) {
			System.out.println(vehiculo);
		}

		System.out.println("======================================================");

		masCaro(this.vehiculos);

		masBarato(this.vehiculos);

		contieneLetraY(this.vehiculos);

		System.out.println("======================================================");

		System.out.println("Vehículos ordenados por precio de mayor a menor:");

		Collections.sort(this.vehiculos);

		for (Vehiculo v : this.vehiculos) {
			System.out.println(v.getMarca() + " " + v.getModelo());
		}
	}

	public static void masCaro(List<Vehiculo> vehiculos) {

		Collections.sort(vehiculos, new Comparator<Vehiculo>() {

			@Override
			public int compare(Vehiculo o1, Vehiculo o2) {
				return (int) (o2.getPrecio() - o1.getPrecio());
			}
		});

		System.out.println("Vehículo más caro: " + vehiculos.get(0).getMarca() + " " + vehiculos.get(0).getModelo());
	}

	public static void masBarato(List<Vehiculo> vehiculos) {

		Collections.sort(vehiculos, new Comparator<Vehiculo>() {

			@Override
			public int compare(Vehiculo o1, Vehiculo o2) {
				return (int) (o1.getPrecio() - o2.getPrecio());
			}
		});

		System.out.println("Vehículo más barato: " + vehiculos.get(0).getMarca() + " " + vehiculos.get(0).getModelo());
	}

	public static void contieneLetraY(List<Vehiculo> vehiculos) {

		Vehiculo vehiculo = new Vehiculo();

		for (Vehiculo v : vehiculos) {
			if (v.getModelo().contains("Y"))
				vehiculo = v;
		}

		System.out.println("Vehículo que contiene en el modelo la letra ‘Y’: " + vehiculo.getMarca() + " " 
				+ vehiculo.getModelo() + " $" + String.format("%1$,.2f", vehiculo.getPrecio()));
	}

}
