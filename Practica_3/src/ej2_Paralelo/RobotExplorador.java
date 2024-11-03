package ej2_Paralelo;

public class RobotExplorador extends Robot {

	public RobotExplorador(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
	}

	@Override
	public void run() {
		this.operar();
	}

	@Override
	public void operar() {

		System.out.println("El " + nombre + " ha comenzado a explorar");
		try {
			this.sleep(tiempoOperacion * 1000);
			System.out.println("El " + nombre + " ha terminado su exploración");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
