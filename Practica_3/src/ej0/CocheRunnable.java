package ej0;

import java.util.Iterator;

public class CocheRunnable implements Runnable {
	private String nombre;
	private double velocidad;
	private double distanciaTotal;
	
	public CocheRunnable(String nombre, double velocidad, double distanciaTotal) {
		super();
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.distanciaTotal = distanciaTotal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public double getDistanciaTotal() {
		return distanciaTotal;
	}
	public void setDistanciaTotal(double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
	@Override
	public void run() {
		double distanciaActual=0;
		System.out.println("El coche " + nombre + " ha comenzado");
		for (int i = 0; i < this.distanciaTotal; i++) {
			distanciaActual=distanciaActual+velocidad;
			System.out.println("Soy el coche " + this.getNombre() + " y he avanzado " + distanciaActual + "m");
			try {
				Thread.sleep((int)velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(distanciaActual>distanciaTotal) {
				i=(int) distanciaTotal;
				System.out.println("El coche " + this.getNombre() + " ha terminado");
			}
		}
	}
	
}
