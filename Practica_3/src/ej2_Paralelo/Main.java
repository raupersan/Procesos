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
		
		
		for(RobotConstructor aux: lista) {
			for(int i=0; i<10; i++) {
				aux.start();
			}
		}
		
	}

}
