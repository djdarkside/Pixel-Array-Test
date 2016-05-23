package com.djdarkside.game.entities;

import java.util.Random;

import com.djdarkside.game.graphics.Display;
import com.djdarkside.game.graphics.Sprite;
import com.djdarkside.game.keyboard.Keyboard;

public class Entities {

	protected int x, y;
	protected Sprite sprite;
	protected final Random r = new Random();
	protected Keyboard key;
	
	public Entities(int x, int y, Keyboard key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}
	
	public void update() {}
	
	public void render(Display display) {
		if (sprite != null) display.renderPlayer(x, y, sprite);
	}
	
	public int getX() { return x;}
	public int getY(){ return y;}
	
	public Sprite getSprite() { return sprite;}
	
	
	
}
