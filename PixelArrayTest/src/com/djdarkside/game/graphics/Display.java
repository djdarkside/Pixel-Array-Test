package com.djdarkside.game.graphics;

import java.util.Random;

import com.djdarkside.game.Game;
import com.djdarkside.game.level.Tile;

public class Display {
	
	public int width, height;
	public int[] pixels;
	private Random r = new Random();
	Sprite sprite;
	private final int ALPHA_COL = 0xffff00ff;
	public int xOffset, yOffset;
	int time = 0;
	int counter = 0;
	Game game;
	
	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];		
 	}
	
	
	public void renderBG(int xOffset, int yOffset) {  //Temp Tile Render
		for (int y = 0; y < height; y++) {		
			int yp = (y + yOffset);
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {	
				int xp = (x + xOffset);
				if (xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.tile1.pixels[(x & 31) + (y & 31) * Sprite.tile1.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.height; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.width; x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) continue;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != ALPHA_COL) pixels[xa + ya * width] = col;
			}
		}
	}
		
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
}

/*
 * 	public void renderTile(int xp, int yp, Tile tile) { 
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;			
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;				
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
*/
