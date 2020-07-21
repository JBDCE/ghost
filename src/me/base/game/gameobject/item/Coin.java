package me.base.game.gameobject.item;

import me.base.engine.*;
import me.base.game.*;
import me.base.game.gameobject.*;

public class Coin extends Item{
	
	private final int SIZE = 32;
	
	private RandomNumberGenerator rng;
	
	private Player player;
	
	public Coin(float x, float y, Player play, Game game){
		this.x = x;
		this.y = y;
		
		rng = new RandomNumberGenerator();
				
		init(1, x, y, new Texture("./res/coin.png"), SIZE, SIZE, "a Coin", game);
		this.player = play;
	}
	
	
	
	public void pickUp(){
		player.addItem(this);
		game.printScore();
		
		relocate();
		//game.destroyObject(this);
	}
	
	public void relocate() {
		this.x = rng.createRandomInt(100, game.getWidth()-100);
		this.y = rng.createRandomInt(100, game.getHeight()-100);
	}
	
	
	public void update(){
		if(Physics.checkCollision(player, this))
			pickUp();
	}
}
