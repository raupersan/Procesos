package Ejer02;

class Venta implements Runnable {
	private Inventario inventario;
	private int cantidad;

	public Venta(Inventario inventario, int cantidad) {
		this.inventario = inventario;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		for (int i = 0; i < 30; i++) {
			inventario.venderProducto(cantidad);
		}
	}
}

class Reabastecimiento implements Runnable {
	private Inventario inventario;
	private int cantidad;

	public Reabastecimiento(Inventario inventario, int cantidad) {
		this.inventario = inventario;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			inventario.agregarProducto(cantidad);
		}
	}
}

public class Inventario {
	volatile private int stock; //Para asegurar que todos los cambios que sea hagan sobre esta variable sean visibles
								//para todos los hilos que la utilicen, así evitamos que los hilos hagan copias locales
								//de las variables
	final private Object stockLock = new Object();

	public Inventario(int stockInicial) {
		this.stock = stockInicial;
	}

	public void agregarProducto(int cantidad) {
		synchronized (stockLock) {
			stock += cantidad;
			System.out.println("Se agregaron " + cantidad + " productos. Stock actual: " + stock);
		}

	}

	public void venderProducto(int cantidad) {
		synchronized (stockLock) {
			if (stock >= cantidad) {
				stock -= cantidad;
				System.out.println("Se vendieron " + cantidad + " productos. Stock actual: " + stock);
			} else {
				System.out.println("No hay suficiente stock para vender " + cantidad + " productos.");
			}
		}
	}

	public int getStock() {
		synchronized(stockLock) {
		return stock;
		}
	}

	public static void main(String[] args) {
		Inventario inventario = new Inventario(50);

		Thread hiloVentas = new Thread(new Venta(inventario, 2));
		Thread hiloReabastecimiento = new Thread(new Reabastecimiento(inventario, 5));

		hiloVentas.start();
		hiloReabastecimiento.start();

		try {
			hiloVentas.join();
			hiloReabastecimiento.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stock final: " + inventario.getStock());
	}

}
