package me.base.game.gameobject.item;

import me.base.engine.*;
import me.base.game.*;

public class Item extends GameObject {
	
	protected String name;
	
	protected void init(int type, float x, float y, Texture tex, float sizeX, float sizeY, String name, Game game){
		this.name = name;
		
		this.type = type;
		
		this.x = x;
		this.y = y;
		this.sprite = new Sprite(tex,sizeX,sizeY);
		
		this.game = game;
	}
	
	public String getName(){
		return name;
	}
	
	public void pickUp(){
		
	}
}
