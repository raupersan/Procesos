package ej2_Paralelo;


import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		
		ArrayList<RobotConstructor> lista = new ArrayList<RobotConstructor>();
		RobotExplorador robotEx1 = new RobotExplorador("robotEx1", 10);
		RobotExplorador robotEx2 = new RobotExplorador("robotEx2", 4);
		RobotExplorador robotEx3 = new RobotExplorador("robotEx3", 3);
		RobotExplorador robotEx4 = new RobotExplorador("robotEx4", 2);

		RobotConstructor robotCons1 = new RobotConstructor("robotCons1", 2);	
		RobotConstructor robotCons2 = new RobotConstructor("robotCons2", 1);
		RobotConstructor robotCons3 = new RobotConstructor("robotCons3", 3);
		
		robotEx1.start();
		robotEx2.start();
		robotEx3.start();
		robotEx4.start();
	
		lista.add(robotCons1);
		lista.add(robotCons2);
		lista.add(robotCons3);
		/*He interpretado el enunciado como que quiere que se lancen
		 * hilos hasta que la cantidad de estructuras sea 10, por lo 
		 * tanto hago un bucle hasta que la variable contadorEstructuras
		 * sea mayor o igual que 10
		 */
		
		/*He probado haciéndolo de la siguiente manera:
		 * for (int i = 0; i < 10; i++) {
			robotCons1.start();
			robotCons2.start();
			robotCons3.start();
		}
		Pero salta una excepción, así que he guardado los objetos en 
		un ArryList y llamar al método a partir de este
		 */
		for(RobotConstructor aux: lista) {
			for(int i=0; i<10; i++) {
				aux.operar();
			}
		}
		
	}

}
