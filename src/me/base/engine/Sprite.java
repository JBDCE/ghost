package me.base.engine;

import static org.lwjgl.opengl.GL11.*;

public class Sprite {

	private Texture tex;
	
	private float sizeX;
	private float sizeY;
	
	public Sprite(Texture tex, float sX, float sY){
		
		this.tex = tex;
		
		this.sizeX = sX;
		this.sizeY = sY;
	}
	
	public void render(){
		tex.bind();
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 1);
			glVertex2f(0,0);
			
			glTexCoord2f(0, 0);
			glVertex2f(0,sizeY);
			
			glTexCoord2f(1, 0);
			glVertex2f(sizeX, sizeY);
			
			glTexCoord2f(1, 1);
			glVertex2f(sizeX, 0);
		}
		glEnd();
	}
	
	public void render(int repeatsX, int repeatsY){
		tex.bind();
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		glBegin(GL_QUADS);
		{
			glTexCoord2f(1*repeatsX, 1*repeatsY);
			glVertex2f(0,0);
			
			glTexCoord2f(1*repeatsX, 0*repeatsY);
			glVertex2f(0,sizeY);
			
			glTexCoord2f(0*repeatsX, 0*repeatsY);
			glVertex2f(sizeX, sizeY);
			
			glTexCoord2f(0*repeatsX, 1*repeatsY);
			glVertex2f(sizeX, 0);
		}
		glEnd();
	}
	
	

	public float getSizeX() {
		return sizeX;
	}

	public void setSizeX(float sizeX) {
		this.sizeX = sizeX;
	}

	public float getSizeY() {
		return sizeY;
	}

	public void setSizeY(float sizeY) {
		this.sizeY = sizeY;
	}
	
	
}
