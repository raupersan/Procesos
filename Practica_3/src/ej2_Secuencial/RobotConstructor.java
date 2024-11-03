package ej2_Secuencial;

public class RobotConstructor extends Robot {
	public static int contadorEstructuras = 0;

	public RobotConstructor(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
	}

	public void run() {
		this.operar();
	}

	@Override
	public synchronized void operar() {//Sincronizando directamente el método se acaba con la concurrencia,
									   //obteniendo así un programa secuencial
		if (contadorEstructuras % 2 == 0) {
			construir();
		} else
			destruir();

	}

	public void destruir() {
		contadorEstructuras--;
		System.out.println("Se ha destruido una estructura. Cantidad actual:" + contadorEstructuras);
		try {
			Thread.sleep(tiempoOperacion * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void construir() {
		synchronized (this) {// Sincronizamos la lectura y actualización de la variable
			contadorEstructuras += 3;
			System.out.println("Se han construido tres estructuras. Cantidad actual:" + contadorEstructuras);
			try {
				Thread.sleep(tiempoOperacion * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void start() {
		this.run();
	}

}
