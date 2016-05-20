package com.djdarkside.game.gameStates;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Timer;
import java.util.TimerTask;

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
	    
		Font font = new Font("arial" , 1, 50);
		g2d.setColor(Color.white);
		g2d.setFont(font);
		
	//Splash Screen Sequence	
		if (show && seq == 0) {			
			alpha += 0.00005f;
			g2d.drawString("Created by: ", 100 + time, 175);
	    	if (alpha >= 1.0f) { 
	    		alpha = 0.0f;
	    		seq = 1;
	    		show = false;	
	    	}  
		}
    	show = true;
		if (show && seq == 1) {
			alpha += 0.00005f;
			g2d.drawString("Me ", game.getWindowWidth() / 2 - 20, 175 + time);
	    	if (alpha >= 1.0f) { 
	    		alpha = 0.0f;
	    		seq = 2;
	    		show = false;	    		
	    	}    	
		}
		show = true;
		if (show && seq == 2) {
			alpha += 0.00005f;
			g.drawString("2016", game.getWindowWidth() - 150, game.getWindowHeight()-20);
	    	if (alpha >= 1.0f) { 
	    		alpha = 0.0f;
	    		seq = 3;
	    		show = false;	    		
	    	} 
		}

		
		
		
    	
    	
    	//g2d.setColor(Color.black);
    	//g2d.drawString("Created by: ", 100 + time, 175);
		

	}
	
	public void update() {
		if (game.gameState == State.SplashScreen) {
			time += 0.3;			
		}
	}	
	
	public void delay() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
