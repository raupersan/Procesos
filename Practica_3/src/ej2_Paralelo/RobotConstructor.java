package ej2_Paralelo;

public class RobotConstructor extends Robot {
	public static int contadorEstructuras=0;

	public RobotConstructor(String nombre, int tiempoOperacion) {
		super(nombre, tiempoOperacion);
	}

	@Override
	public void run() {
		this.operar();
	}

	@Override
	public void operar() {
		synchronized (this) { //Sincronizamos aquí porque sino, la lectura de la variable compartida puede dar lugar a condiciones de carrera
			if (contadorEstructuras % 2 == 0) {
				construir();
			} else
				destruir();
		}
	}

	public void destruir() {
		synchronized (this) {//Sincronizamos la lectura y actualización de la variable
			contadorEstructuras--;
			System.out.println("Se ha destruido una estructura. Cantidad actual:" + contadorEstructuras);
			try {
				Thread.sleep(tiempoOperacion*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void construir() {
		synchronized (this) {//Sincronizamos la lectura y actualización de la variable
			contadorEstructuras += 3;
			System.out.println("Se han construido tres estructuras. Cantidad actual:" + contadorEstructuras);
			try {
				Thread.sleep(tiempoOperacion*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
