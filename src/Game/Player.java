package Game;

import java.awt.Graphics;

import GameEngine.GameObject;

public class Player extends GameObject{
	Graphics graphics;
	
	public Player(Graphics g){
		super();
		this.graphics = g;
		
	}
	
	public static void tick(){
		//move();
		//shootOnkeypree();
		System.out.println("Tick in player Game Object");
	}

}
