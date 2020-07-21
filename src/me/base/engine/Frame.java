package me.base.engine;

public class Frame {
	
	private int length;
	private Sprite sprite;
	private int framesShown;
	
	public Frame(Sprite spr, int length){
		this.sprite = spr;
		this.length = length;
		
		framesShown = 0;
		
	}
	
	
	public boolean render(){
		
		sprite.render();
		framesShown++;
		
		if(framesShown >= length){
			framesShown = 0;
			return true;
		}
			
		
		return false;
	}

}
