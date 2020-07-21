package me.base.game.gameobject.counter;

import me.base.engine.*;
import me.base.game.*;

public class Figure extends GameObject{

	private Digit d0;
	private Digit d1;
	private Digit d2;
	private Digit d3;
	private Digit d4;
	private Digit d5;
	private Digit d6;
	private Digit d7;
	private Digit d8;
	private Digit d9;
	
	public Figure(int row, Game game) {
		d0 = new Digit(row, 0, game);
		d1 = new Digit(row, 1, game);
		d2 = new Digit(row, 2, game);
		d3 = new Digit(row, 3, game);
		d4 = new Digit(row, 4, game);
		d5 = new Digit(row, 5, game);
		d6 = new Digit(row, 6, game);
		d7 = new Digit(row, 7, game);
		d8 = new Digit(row, 8, game);
		d9 = new Digit(row, 9, game);
		
		game.addObject(d0);
		game.addObject(d1);
		game.addObject(d2);
		game.addObject(d3);
		game.addObject(d4);
		game.addObject(d5);
		game.addObject(d6);
		game.addObject(d7);
		game.addObject(d8);
		game.addObject(d9);
	}
	
	public void show(int number){
		if(number == 0){
			d0.show();
			d1.hide();
			d2.hide();
			d3.hide();
			d4.hide();
			d5.hide();
			d6.hide();
			d7.hide();
			d8.hide();
			d9.hide();
		}else
		if(number == 1){
			d0.hide();
			d1.show();
			d2.hide();
			d3.hide();
			d4.hide();
			d5.hide();
			d6.hide();
			d7.hide();
			d8.hide();
			d9.hide();
		}else
		if(number == 2){
			d0.hide();
			d1.hide();
			d2.show();
			d3.hide();
			d4.hide();
			d5.hide();
			d6.hide();
			d7.hide();
			d8.hide();
			d9.hide();
		}else
		if(number == 3){
			d0.hide();
			d1.hide();
			d2.hide();
			d3.show();
			d4.hide();
			d5.hide();
			d6.hide();
			d7.hide();
			d8.hide();
			d9.hide();
		}else
		if(number == 4){
			d0.hide();
			d1.hide();
			d2.hide();
			d3.hide();
			d4.show();
			d5.hide();
			d6.hide();
			d7.hide();
			d8.hide();
			d9.hide();
		}else
		if(number == 5){
			d0.hide();
			d1.hide();
			d2.hide();
			d3.hide();
			d4.hide();
			d5.show();
			d6.hide();
			d7.hide();
			d8.hide();
			d9.hide();
		}else
		if(number == 6){
			d0.hide();
			d1.hide();
			d2.hide();
			d3.hide();
			d4.hide();
			d5.hide();
			d6.show();
			d7.hide();
			d8.hide();
			d9.hide();
		}else
		if(number == 7){
			d0.hide();
			d1.hide();
			d2.hide();
			d3.hide();
			d4.hide();
			d5.hide();
			d6.hide();
			d7.show();
			d8.hide();
			d9.hide();
		}else
		if(number == 8){
			d0.hide();
			d1.hide();
			d2.hide();
			d3.hide();
			d4.hide();
			d5.hide();
			d6.hide();
			d7.hide();
			d8.show();
			d9.hide();
		}else
		if(number == 9){
			d0.hide();
			d1.hide();
			d2.hide();
			d3.hide();
			d4.hide();
			d5.hide();
			d6.hide();
			d7.hide();
			d8.hide();
			d9.show();
		}
	}	
}
