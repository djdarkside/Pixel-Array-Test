package com.djdarkside.game.entities.player;

import com.djdarkside.game.Game;
import com.djdarkside.game.gameStates.State;
import com.djdarkside.game.graphics.Display;
import com.djdarkside.game.graphics.Sprite;
import com.djdarkside.game.keyboard.Keyboard;

public class Player2 {

	public int x, x2;
	public int y, y2;
	private Sprite sprite;
	private Keyboard input;
	
	public Player2(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player2;
	}
	
	public void update() {
		
		if (x > -10) {
			if (input.left2) x--;			
		} else x =  -10;
		
		if (x < Game.getWindowWidth() - 22) {
			if (input.right2) x++;
		} else x = Game.getWindowWidth()  - 22;
		
		
		//if (key.up2) y2--;
		//if (key.down2) y2++;
		if (input.left2) x2--;
		if (input.right2) x2++;
	}	
	
	public void render(Display display) {
		display.renderPlayer(x, y, sprite);
	}
	
}

