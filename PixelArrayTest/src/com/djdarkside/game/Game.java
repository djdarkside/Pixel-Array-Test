package com.djdarkside.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.djdarkside.game.graphics.Display;


public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -3476412947826110362L;
	
	private static int width = 320;
	private static int height = width / 16 * 9;
	private static int scale = 3;
	private static String title = "Pixel Array Test";
	
	private Thread thread;
	private boolean running = false;
	private JFrame frame;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); //Creates the image
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); //Allows up to modify the image
	
	private Display display;	
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);		
		display = new Display(width, height);
		frame = new JFrame();
	}
	
	public void update() {		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy(); 
		if (bs == null) { createBufferStrategy(3); return; }
		display.clear(); //clears the screen every frame		
		display.render(); //renders new frame
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = display.pixels[i];
		}		
		Graphics g = bs.getDrawGraphics();		
		{
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}		
		g.dispose();
		bs.show();
	}
	
	public int getWindowWidth() {
		return width * scale;
	}	
	public int getWindowHeight() {
		return height * scale;
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Thread Running");
		thread.start();
	}	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;		
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			if (running) render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;				
			}
		}
		stop();
	}	
	public static void main(String args[]) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();		
	}
}
