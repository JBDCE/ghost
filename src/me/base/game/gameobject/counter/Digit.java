package me.base.game.gameobject.counter;

import me.base.engine.*;
import me.base.game.*;

public class Digit extends GameObject{
	
	private String path;
	
	
	
	
	public Digit(int row, int number, Game game) {
		path = String.join("", "./res/", Integer.toString(number), ".png");
		if(row == 0){
			//System.out.println(path);
			init(0,game.getWidth()-90,5,new Texture(path),20,40);
		}else
		if(row == 1){
			init(0,game.getWidth()-60,5,new Texture(path),20,40);
		}else
		if(row == 2){
			init(0,game.getWidth()-30,5,new Texture(path),20,40);
		}
	}
	
	public void hide(){
		this.y = -50;
	}
	
	public void show(){
		this.y = 5;
		//this.x = 100;
	}
	
	
}
