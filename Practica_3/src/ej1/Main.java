package ej1;

public class Main {

	public static void main(String[] args) {
		RobotExplorador robot1 =  new RobotExplorador("robot1", 10);
		RobotExplorador robot2 = new RobotExplorador("robot2", 20);
		RobotExplorador robot3 = new RobotExplorador("robot3", 5);
		RobotExplorador robot4 = new RobotExplorador("robot4", 2);
		
		robot1.start();
		robot2.start();
		robot3.start();
		robot4.start();
	}

}
