package GameEngine;

public class Engine {
	boolean gameRunning = true;
	
	public void gameLoop(){
		while (gameRunning){
			//hantera input
			//uppdatera spelvärlden
			//generera output
			System.out.println("Spelloopen körs");
			gameRunning = false;
		}
	}
}
