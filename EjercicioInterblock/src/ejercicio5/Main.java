package ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LinkedBlockingQueue<Filosofo> filosofos = new LinkedBlockingQueue<>();
		LinkedBlockingQueue<Tenedor> tenedores = new LinkedBlockingQueue<>();
		int nFilosofos=0;

		while(nFilosofos<2) {
		System.out.println("Indica el número de filósofos. Tiene que haber al menos 2");
		nFilosofos=sc.nextInt();
		}
		
		Semaphore semaforo= new Semaphore(nFilosofos);

		for (int i = 0; i < nFilosofos; i++) {
			Filosofo filo = new Filosofo("Hambriento");
			filosofos.add(filo);
			Tenedor tenedor = new Tenedor(true);
			tenedores.add(tenedor);
		}
		for (Filosofo filoAux : filosofos) {
			filoAux.start();
		}
	}

}
