package com.djdarkside.game.gameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.djdarkside.game.Game;
import com.djdarkside.game.graphics.Display;

public class SplashScreen {
	
	Game game;
	Display display;
	
	public SplashScreen(Game game, Display display) {
		this.game = game;
		this.display = display;
	}
	
	public void render(Graphics g) {		
		Font font = new Font("arial" , 1, 75);
		g.setColor(Color.white);
		g.setFont(font);
		//g.drawRect(100, 100, 32, 64);
		g.drawString("Created by: ", game.getWindowWidth() / 2, game.getWindowHeight() / 2);	
		
	}
}
