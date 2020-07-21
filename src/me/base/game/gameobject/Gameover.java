package me.base.game.gameobject;

import me.base.engine.*;
import me.base.game.*;

public class Gameover extends GameObject {
	
	private float sizeX;
	private float sizeY;
	
	public Gameover(Game game) {
		this.game = game;
		this.sizeX = 500;
		this.sizeY = 500;
		init(0,game.getWidth()/2-sizeX/2,game.getHeight()/2-sizeY/2,new Texture("./res/gameover.png"),sizeX,sizeY);	
	}
}
