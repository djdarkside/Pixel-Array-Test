package com.djdarkside.game.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.djdarkside.game.player.Player;

public class Keyboard implements KeyListener {

	public int x = 0, y = 0;
	public boolean[] keys = new boolean[120];
	public boolean up, down, left, right;
	public boolean up2, down2, left2, right2;
	public boolean jump;
	
	Player player;
	
	
	public void update() {
		//Player 1 Movement
		up = /*keys[KeyEvent.VK_UP] ||*/ keys[KeyEvent.VK_W];
		down = /*keys[KeyEvent.VK_DOWN] ||*/ keys[KeyEvent.VK_S];
		left = /*keys[KeyEvent.VK_LEFT] ||*/ keys[KeyEvent.VK_A];
		right = /*keys[KeyEvent.VK_RIGHT] ||*/ keys[KeyEvent.VK_D];		
		
		jump = keys[KeyEvent.VK_SPACE];
		
		//Player 2 Movement
		up2 = keys[KeyEvent.VK_UP];
		down2 = keys[KeyEvent.VK_DOWN];
		left2 = keys[KeyEvent.VK_LEFT];
		right2 = keys[KeyEvent.VK_RIGHT];	
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		e.getKeyCode();		
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	public void keyTyped(KeyEvent e) {
		
	}

}
