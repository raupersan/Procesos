package ej1;

public class RobotExplorador extends Thread {
	private  String nombre;
	private static int tiempoExploracion;

	public RobotExplorador(String nombre, int tiempoExploracion) {
		this.nombre = nombre;
		this.tiempoExploracion = tiempoExploracion;

	}

	@Override
	public void run() {
		try {
			this.explorar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private  void explorar() throws InterruptedException {
		System.out.println("El " + nombre   + " ha comenzado a explorar");
		Thread.sleep(tiempoExploracion*1000);
		System.out.println("El " + nombre + " ha terminado su exploración");
	}
}
