package problemasConcurrencia;

import hilos.Ejemplo1.RatonParalelo;
import hilos.Ejemplo1.RatonRunnable;

public class RatonConProblemas implements Runnable {

	private String nombre;
	private int tiempoAlimentacion;
	private int alimentoConsumido;

	public RatonConProblemas(String nombre, int tiempoAlimentacion) {
			this.nombre=nombre;
			this.tiempoAlimentacion=tiempoAlimentacion;
			}
	
	@Override // Es un método de la clase thread
	public void run() {
		// Esto es lo que se va a paralelizar
		this.comer();
	}	

	public void comer() {
		try {
			System.out.println("El raton " + nombre + " ha empezado a comer");
			Thread.sleep(tiempoAlimentacion * 1000); // Tiempo en ms
			alimentoConsumido++;
			System.out.println("El ratón " + nombre + " ha terminado de comer");
			System.out.println("Ha consumido: "+ alimentoConsumido);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		RatonConProblemas a = new RatonConProblemas("a", 4);
		for(int i=0; i<1000; i++) {
			(new Thread(a)).start();
		}

	}

}
