package me.base.game.gameobject;

import static org.lwjgl.opengl.GL11.*;

import me.base.engine.*;
import me.base.game.*;

public class Border extends GameObject{
	
	Game game;	
	Player player;
	
	private int repeatsX;
	private int repeatsY;
	private int thicness;
	private int side;
	
	
	public Border(int side, Player play, Game game){
		thicness = 64;
		this.side = side;
		if(side == 0){
			init(0, 0, 0, new Texture("./res/wall.png"), game.getWidth(), thicness);
			repeatsX = game.getWidth()/thicness;
			repeatsY = 1;
		}else if(side == 1){
			init(0, 0, 0, new Texture("./res/wall.png"), thicness, game.getHeight());
			repeatsX = 1;
			repeatsY = game.getHeight()/thicness;
		}else if(side == 2){
			init(0, 0, game.getHeight()-thicness, new Texture("./res/wall.png"), game.getWidth(), thicness);
			repeatsX = game.getWidth()/thicness;
			repeatsY = 1;
		}else if(side == 3){
			init(0, game.getWidth()-thicness, 0, new Texture("./res/wall.png"), thicness, game.getHeight());
			repeatsX = 1;
			repeatsY = game.getHeight()/thicness;
		}
				
		this.game = game;
		this.player = play;
	}
	
	public void update(){
		if(Physics.checkCollision(player, this)){
			player.stop(side);
		}else{
			player.start(side);
		}
	}	
	
	@Override
	public void render(){
		glPushMatrix();
		glTranslatef(x, y, 0);
		sprite.render(repeatsX,repeatsY);
		glPopMatrix();
	}
}
