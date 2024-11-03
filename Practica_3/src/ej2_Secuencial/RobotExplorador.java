package ej2_Secuencial;

public class RobotExplorador extends Robot {

	public RobotExplorador(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
	}

	public void run() {
		this.operar();
	}

	@Override
	public synchronized void operar() { //Sincronizando directamente el método se acaba con la concurrencia,
										//obteniendo así un programa secuencial

		System.out.println("El " + nombre + " ha comenzado a explorar");
		// this.sleep(tiempoOperacion * 1000);
		System.out.println("El " + nombre + " ha terminado su exploración");

	}

	@Override
	public void start() {
		this.run();
	}

}
