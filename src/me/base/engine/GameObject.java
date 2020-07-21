package me.base.engine;

import static org.lwjgl.opengl.GL11.*;

import me.base.game.*;


public abstract class GameObject {

	protected float x;
	protected float y;
	protected int type;
	
	protected Game game;
	//private Animation animation;
	protected Sprite sprite;
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public void update(){
		
	}
	
	public void render(){
		glPushMatrix();
		glTranslatef(x, y, 0);
		sprite.render();
		glPopMatrix();
	}
	
	public float getSizeX(){
		return sprite.getSizeX();
	}
	public float getSizeY(){
		return sprite.getSizeY();
	}
	public int getType(){
		return type;
	}
	
	
	protected void init(int type, float x, float y,Texture tex, float sizeX, float sizeY){
		this.type = type;
		
		this.x = x;
		this.y = y;
		this.sprite = new Sprite(tex,sizeX,sizeY);
	}
	
	
}
