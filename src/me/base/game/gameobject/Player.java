package me.base.game.gameobject;

import org.lwjgl.glfw.*;

import me.base.engine.*;
import me.base.game.gameobject.item.*;

public class Player extends GameObject	{
	
	public static final int SIZE = 64;
	
	private boolean running;
	
	private boolean allow_W;
	private boolean allow_S;
	private boolean allow_A;
	private boolean allow_D;
	
	
	private int score;
	
	public Player(float x, float y, Texture tex){
		running = true;
		
		allow_W = true;
		allow_A = true;
		allow_S = true;
		allow_D = true;
		score = 0;
		init(0, x, y, tex , SIZE, SIZE);		
	}
	
	public void getInput(){
		if(Input.keys[GLFW.GLFW_KEY_W]&&allow_W == true&&running == true){	//Up
			move(0,1);
		}
		if(Input.keys[GLFW.GLFW_KEY_S]&&allow_S == true&&running == true){	//Down
			move(0,-1);
		}
		if(Input.keys[GLFW.GLFW_KEY_A]&&allow_A == true&&running == true){	//Left
			move(-1,0);
		}
		if(Input.keys[GLFW.GLFW_KEY_D]&&allow_D == true&&running == true){	//Right
			move(1,0);
		}
	}
	
	private void move(float magX, float magY){
		x += getSpeed()*magX;
		y += getSpeed()*magY;
	}
	
	public void stop(int side){
		if(side == 0){
			allow_S = false;
		}else
		if(side == 1){
			allow_A = false;
		}else
		if(side == 2){
			allow_W = false;
		}else
		if(side == 3){
			allow_D = false;
		}
	}
		
	public void start(int side){
		if(side == 0){
			allow_S = true;
		}else
		if(side == 1){
			allow_A = true;
		}else
		if(side == 2){
			allow_W = true;
		}else
		if(side == 3){
			allow_D = true;
		}
	}
	
	public void halt(){
		running = false;
	}
	
	
	public float getSpeed(){	
		return 4f;
	}
	
	public void addItem(Item item){
		System.out.println("You picked up: " + item.getName());
		score++;
	}
	
	public int getScore(){
		return score;
	}
	
}
