package com.djdarkside.game.level;

import com.djdarkside.game.graphics.Display;

public class Level {

	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	private void loadLevel(String path) {
		
	}

	protected void generateLevel() {
		
	}
	
	public void update() {
		
	}
	
	public void render(int xScroll, int yScroll, Display display) {
		
	}
	
	private void time() {		
	}
	
}
