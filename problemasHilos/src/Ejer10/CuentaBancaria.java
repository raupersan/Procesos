package Ejer10;

class Transferencia implements Runnable {
	private CuentaBancaria origen;
	private CuentaBancaria destino;
	private int cantidad;

	public Transferencia(CuentaBancaria origen, CuentaBancaria destino, int cantidad) {
		this.origen = origen;
		this.destino = destino;
		this.cantidad = cantidad;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			origen.transferir(destino, cantidad);
		}
	}
}

public class CuentaBancaria {
	private int balance;

	public CuentaBancaria(int balanceInicial) {
		this.balance = balanceInicial;
	}

	public void depositar(int cantidad) {
		balance += cantidad;
	}

	public void retirar(int cantidad) {
		balance -= cantidad;
	}

	public void transferir(CuentaBancaria destino, int cantidad) {
		this.hashCode();
		Object primero, segundo;

		// primero = cuentaBancariaMenor;
		// segundo = cuentaBancariaMayor;
		/* Esto puede dar un error ya que el metodo hashCode puede ser sobreescrito
		 * if (this.hashCode() < destino.hashCode()) {
			primero = this;
			segundo = destino;
			this.retirar(cantidad);
			destino.depositar(cantidad);
		}
		*/
		if(System.identityHashCode(this)<System.identityHashCode(destino)) {
			primero=this;
			segundo=destino;
		}
		else {
			primero=destino;
			segundo=destino;
		}
		synchronized(this) {
			synchronized(segundo) {
				this.retirar(cantidad);
				destino.depositar(cantidad);
			}
		}
	}

	public int getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		CuentaBancaria cuenta1 = new CuentaBancaria(1000);
		CuentaBancaria cuenta2 = new CuentaBancaria(1000);

		Thread hilo1 = new Thread(new Transferencia(cuenta1, cuenta2, 12));
		Thread hilo2 = new Thread(new Transferencia(cuenta2, cuenta1, 10));

		hilo1.start();
		hilo2.start();

		try {
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Balance final de cuenta1: " + cuenta1.getBalance());
		System.out.println("Balance final de cuenta2: " + cuenta2.getBalance());
	}
}
