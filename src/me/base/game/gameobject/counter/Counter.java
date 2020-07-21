package me.base.game.gameobject.counter;

import java.util.*;

import me.base.engine.*;
import me.base.game.*;

public class Counter extends GameObject {
	
	private int[] digit;
	
	private int lenght = 250;
	private int height = 64;
	
	private Figure f0;
	private Figure f1;
	private Figure f2;
	
	public Counter(Game game) {
		
		init(0,game.getWidth()-this.lenght,-14,new Texture("./res/bg.png"),this.lenght,this.height);
		
		digit = new int[3];
		//this.lenght = 64;
		//this.height = 64;
		this.game = game;
		
		
		//game.addObject(new Background(game.getWidth()-lenght, 0));
	}
	
	public void createFigures(){
		f0 = new Figure(0, game);
		f1 = new Figure(1, game);
		f2 = new Figure(2, game);
	}
	
	public void addLabel(){
		game.addObject(new Label(this.game));
	}
	
	
	public void display(int number){
		splitNumber(number);
		
		//System.out.println(this.digit[0]);
		
		f0.show(this.digit[0]);
		f1.show(this.digit[1]);
		f2.show(this.digit[2]);
		
	}
	
	private void splitNumber(int n){
		int number = n; // = and int
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for(int i = 0; i<3;i++) {
		    stack.push( number % 10 );
		    number = number / 10;
		}
		
		this.digit[0] = stack.get(0);
		this.digit[1] = stack.get(1);
		this.digit[2] = stack.get(2);
	}
	
	
	public void update(){
		display(game.getScore());
	}
}
