package ej2_Secuencial;

public abstract class Robot {

	protected String nombre;
	protected int tiempoOperacion;

	public Robot(String nombre, int tiempoOperacion) {
		this.nombre = nombre;
		this.tiempoOperacion = tiempoOperacion;

	}

	public abstract void operar();

	public abstract void start();

}