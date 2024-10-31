package ej0;

public class Main {

	public static void main(String[] args) {

		Thread coche1 = new Thread(new CocheRunnable("uno", 80, 1000));
		Thread coche2 = new Thread(new CocheRunnable("dos", 100, 1000));
		Thread coche3 = new Thread(new CocheRunnable("tres", 140, 1000));
		Thread coche4 = new Thread(new CocheRunnable("cuatro", 60, 1000));
		
		
		coche1.start();
		coche2.start();
		coche3.start();
		coche4.start();
		try {
			coche1.wait();
			coche2.wait();
			coche3.wait();
			coche4.wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
