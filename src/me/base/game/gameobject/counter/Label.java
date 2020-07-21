package me.base.game.gameobject.counter;

import me.base.engine.*;
import me.base.game.*;

public class Label extends GameObject {
	public Label(Game game){
		init(0,game.getWidth()-220,5,new Texture("./res/score.png"),75,40);
	}
}
