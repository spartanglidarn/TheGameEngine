package GameEngine;

public class Engine {
	private boolean gameRunning = true;
	private boolean gamePause = false;
	private int fps = 60;
	private int frameCount = 0;
	
	public void gameLoop(){
		
		final double GAME_HERTZ = 30.0;
		//how many ns each frame should take. Accourding to our game hertz
		final double TIME_BETWEEN_UPDATES = 1000000000 / GAME_HERTZ;
		
		//this is the maximum number of times we will before vi render the screen
		final int MAX_UPDATES_BEFORE_RENDER = 5;
		
		//Variables for storing the last time we did a update and last time we did a render.
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();
		
		//If the computer is able to get as high as this FPS, stop the render
		final double TARGET_FPS = 60;
		final double TARGET_TIME_BETWEEN_RENDERS = 1000000000 / TARGET_FPS;
		
		//Calculate the FPS
		int lastSecondTime = (int) ( lastUpdateTime / 1000000000);
		
		
		while (gameRunning){
			double now = System.nanoTime();
			int updateCount = 0;
			
			if (!gamePause) {
				while ( now - lastUpdateTime > TIME_BETWEEN_UPDATES && updateCount < MAX_UPDATES_BEFORE_RENDER){
					//*****UPDATE GAME*******
					System.out.println("UPDATE GAME!!");
					lastUpdateTime += TIME_BETWEEN_UPDATES;
					updateCount++;
				}
				
			//calculate interpolation for the render
			float interpolation = Math.min(1.0f, (float)((now - lastUpdateTime) / TIME_BETWEEN_UPDATES));
			//******RENDER(INTERPOLATION)*******drawGame(interpolation);
			System.out.println("RENDER GAME!!!");
			lastRenderTime = now;
			
			//Update frames
			int thisSecond = (int) (lastUpdateTime / 1000000000);
			if (thisSecond > lastSecondTime){
				System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
				fps = frameCount;
				frameCount = 0;
				lastSecondTime = thisSecond;
			}
			//Take a break until the target time between renders have been met.
			while (now - lastRenderTime < TARGET_TIME_BETWEEN_RENDERS && now - lastUpdateTime < TIME_BETWEEN_UPDATES) {
				Thread.yield();
				
				//Stops the game frome consuming to much CPU.
				try{
					Thread.sleep(1);
				} catch (Exception e){}
				now = System.nanoTime();
			}
				
			}
			//hantera input
			//uppdatera spelv�rlden
			//generera output
			//System.out.println("Spelloopen k�rs");
			//gameRunning = false;
		}
	}
}
