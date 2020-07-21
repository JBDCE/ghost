package me.base.game;

import static org.lwjgl.glfw.GLFW.*;

import java.util.*;

import org.lwjgl.glfw.*;

import me.base.database.*;
import me.base.engine.*;
import me.base.game.gameobject.*;
import me.base.game.gameobject.counter.*;
import me.base.game.gameobject.item.*;

public class Game {
	
	private long framesRendered;
	
	private int height;
	private int width;
	
	private long window;
	
	private ArrayList<GameObject> object;
	private ArrayList<GameObject> toDelete;
	private Player player;
	private Coin coin;
	private Counter counter;
	RandomNumberGenerator rand = new RandomNumberGenerator();
	MySQL sql;
	
	
	
	public Game(int height, int width, long window){
		this.height = height;
		this.width = width;
		
		this.window = window;
		sql = new MySQL();
		
		object = new ArrayList<GameObject>();
		toDelete = new ArrayList<GameObject>();
		
		player = new Player(width/2-32/2,height/2-32/2, new Texture("./res/ghost.png"));
		coin = new Coin(rand.createRandomInt(200, 700),rand.createRandomInt(100, 500),player,this);
		counter = new Counter(this);
	
		
		
		addObject(coin);
		addObject(player);
		
		addObject(new Border(0 ,player, this));
		addObject(new Border(1, player, this));
		addObject(new Border(2, player, this));
		addObject(new Border(3, player, this));
		
		
		addObject(counter);
		counter.addLabel();
		counter.createFigures();
	}
	
	
	public void addObject(GameObject obj) {
		object.add(obj);
	}
	
	public void render(){
		for(GameObject go : object)
			go.render();
	}
		
	public void update(){
		framesRendered += 1;
		//System.out.println(framesRendered);
		for(GameObject go : object)
			go.update();
		for(GameObject go : toDelete)
			object.remove(go);
		
		if(framesRendered == 3600){
			player.halt();
			destroyObject(coin);
			
			addObject(new Gameover(this));	
			
			uploadResults();
		}
		
		if(Input.keys[GLFW.GLFW_KEY_ESCAPE])
			closeWindow();
	}
	
	public void closeWindow(){
		glfwSetWindowShouldClose(window, true);
	}
	
	private void uploadResults(){
		try {
			sql.insertResults(getScore());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getInputs(){
		player.getInput();
	}
	
	public long getFramesRendered(){
		return framesRendered;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getScore(){
		return player.getScore();
	}
	
	public void destroyObject(GameObject target){
		for(GameObject go : object){
			if(go == target)
				toDelete.add(target);
		}
	}
	
	public void printScore(){
		System.out.println("You score was: " + player.getScore() + "!");
	}
}
