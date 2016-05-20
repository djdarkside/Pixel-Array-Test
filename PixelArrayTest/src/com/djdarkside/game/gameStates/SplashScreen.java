package com.djdarkside.game.gameStates;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import com.djdarkside.game.Game;
import com.djdarkside.game.graphics.Display;

public class SplashScreen {
	
	Game game;
	Display display;
	float time = 0;
	float alpha = 0.0f;
	
	
	public SplashScreen(Game game, Display display) {
		this.game = game;
		this.display = display;
	}
	
	public void render(Graphics g) {	
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
	    
		Font font = new Font("arial" , 1, 50);
		g2d.setColor(Color.white);
		g2d.setFont(font);
		//g.drawRect(100, 100, 32, 64);
		g2d.drawString("Created by: ", 100 + time, 175);		
		
		alpha += 0.008f;
    	if (alpha >= 1.0f) {
    		alpha = 0.0f;
    	}

	    try {
	        Thread.sleep(30);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public void update() {
		if (game.gameState == State.SplashScreen) {
			time += 0.3;			
		}
	}
}
