package com.djdarkside.game.gameStates;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Timer;


import com.djdarkside.game.Game;
import com.djdarkside.game.graphics.Display;

public class SplashScreen {
	
	Game game;
	Display display;
	float time = 0;
	float alpha = 0.0f;
	private Timer timer;
	private int seconds = 2000;
	private boolean show = true;
	private int seq = 0;
	
	
	public SplashScreen(Game game, Display display) {
		this.game = game;
		this.display = display;
	}
	
	public void render(Graphics g) {	
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
	    
		Font font = new Font("arial" , 1, 40);
		g2d.setColor(Color.white);
		g2d.setFont(font);
		
	//Splash Screen Sequence	
		if (show && seq == 0) {			
			alpha += 0.00008f;
			g2d.drawString("Created by", 75 + time, 175+time);
	    	if (alpha >= 0.8f) { 
	    		alpha = 0.0f;
	    		seq = 1;
	    		show = false;	    		
	    	}  
		}
    	show = true;
		if (show && seq == 1) {
			alpha += 0.00008f;
			g2d.drawString("Mitchell Baptist", game.getWindowWidth() / 2 - 150, 100 + time);
	    	if (alpha >= 0.8f) { 
	    		alpha = 0.0f;
	    		seq = 2;
	    		show = false;	    		
	    	}    	
		}
		show = true;
		if (show && seq == 2) {
			alpha += 0.00008f;
			g.drawString("2016", game.getWindowWidth() - 150, game.getWindowHeight()-20);
	    	if (alpha >= 0.8f) { 
	    		alpha = 0.0f;
	    		seq = 3;
	    		show = false;	    		
	    	} 
		}
		show = true;
		if (show && seq == 3) {
			//delay();
			alpha += 0.00008f;
			g.drawString("Loading", game.getWindowWidth() / 2 - 25, game.getWindowHeight() / 2 -20);		
	    	if (alpha >= 0.8f) { 
	    		alpha = 0.0f;
	    		seq = 4;
	    		game.gameState = State.Game; 
	    		show = false;	
	    	}			
		}
	}
	
	public void update() {
		if (game.gameState == State.SplashScreen) {
			time += 0.3;			
		}
	}	
	
	private void delay() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
