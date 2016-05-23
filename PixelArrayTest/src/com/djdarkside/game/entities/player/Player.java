package com.djdarkside.game.entities.player;

import com.djdarkside.game.Game;
import com.djdarkside.game.entities.Entities;
import com.djdarkside.game.gameStates.State;
import com.djdarkside.game.graphics.Display;
import com.djdarkside.game.graphics.Sprite;
import com.djdarkside.game.keyboard.Keyboard;

public class Player extends Entities {

	public int x, x2;
	public int y, y2;
	private Sprite sprite;
	public boolean jumping = false;
	public boolean falling = true;
	public double gravity = 0.0;
	
	public Player(int x, int y, Keyboard key) {
		super(x, y, key);
		sprite = Sprite.player1;
	}
	
	public void update() {
		
		if (x > -10) {
			if (key.left) x--;			
		} else x =  -10;
		
		if (x < Game.getWindowWidth() - 22) {
			if (key.right) x++;
		} else x = Game.getWindowWidth()  - 22;		
		
		//if (key.up2) y2--;
		//if (key.down2) y2++;
		if (key.left2) x2--;
		if (key.right2) x2++;
		
		////Jumping
		if (key.jump) {
			gravity = 2.1;
			jumping = true;
			falling = false;
			//System.out.println("J: " + jumping);
			y = (int) ((Game.getWindowHeight() - 32) - gravity);
		} else {
			gravity = -2.1;
			falling = true;
			jumping = false;
			//System.out.println("F: " + falling);
			y = (Game.getWindowHeight() - 32);
		}
		
		
	}
	
	public void render(Display display) {
		display.renderPlayer(x, y, sprite);
	}	
}


/*
public Player(int x, int y, Keyboard key) {
	this.x = x;
	this.y = y;
	this.key = key;
	sprite = Sprite.player1;
}
*/