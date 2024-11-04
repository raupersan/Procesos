package ej2_Paralelo;

public abstract class Robot extends Thread {

	protected String nombre;
	protected int tiempoOperacion;

	public Robot(String nombre, int tiempoOperacion) {
		this.nombre = nombre;
		this.tiempoOperacion = tiempoOperacion;

	}

	public abstract void operar();
	public abstract void comenzarOperar();

}