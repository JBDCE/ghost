package me.base.game.gameobject.counter;

import me.base.engine.*;

public class Background extends GameObject{
		
	public Background(int x, int y){
		init(0, x, y, new Texture("./res/bg.png"), 250, 50);
	}
}
