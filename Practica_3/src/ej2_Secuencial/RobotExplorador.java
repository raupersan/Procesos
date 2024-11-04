package ej2_Secuencial;

public class RobotExplorador extends Robot {

	public RobotExplorador(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
	}

	@Override
	public void comenzarOperar() {
		this.run();
	}
	public void run() {
		this.operar();
	}

	@Override
	public void operar() { 

		System.out.println("El " + nombre + " ha comenzado a explorar");
		System.out.println("El " + nombre + " ha terminado su exploración");

	}

	

}
