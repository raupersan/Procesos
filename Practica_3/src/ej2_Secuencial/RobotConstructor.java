package ej2_Secuencial;

public class RobotConstructor extends Robot {
	public static int contadorEstructuras = 0;

	public RobotConstructor(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
	}
	@Override
	public void comenzarOperar() {
		this.run();
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.operar();
		}
	}

	@Override
	public void operar() {
		if (contadorEstructuras % 2 == 0) {
			construir();
		} else
			destruir();
	}

	public void destruir() {
		contadorEstructuras--;
		System.out.println("Se ha destruido una estructura. Cantidad actual:" + contadorEstructuras);
	}

	public void construir() {
			contadorEstructuras += 3;
			System.out.println("Se han construido tres estructuras. Cantidad actual:" + contadorEstructuras);
			try {
				Thread.sleep(tiempoOperacion);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	
}
