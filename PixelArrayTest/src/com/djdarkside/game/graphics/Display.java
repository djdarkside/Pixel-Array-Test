package com.djdarkside.game.graphics;

import java.util.Random;

import com.djdarkside.game.level.Tile;

public class Display {
	
	public int width, height;
	public int[] pixels;
	private Random r = new Random();
	public final int MAP_SIZE = 128;
	//public final int MAP_SIZE_MASK = MAP_SIZE -1;
	//public int[] tiles = new int [MAP_SIZE * MAP_SIZE];
	
	int time = 0;
	int counter = 0;
	
	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];		
		
		//for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
		//	tiles[i] = r.nextInt(0xffffff);
		//	tiles[0] = 0;
		//}
 	}
	
	
	public void renderSprite(int xOffset, int yOffset) {  //Temp Tile Render
		for (int y = 0; y < height; y++) {		
			int yp = (y + yOffset);
			if (yp < 0 || yp >= height) continue;
			for (int x = 0; x < width; x++) {	
				int xp = (x + xOffset);
				if (xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.splash.pixels[(x & 31) + (y & 31) * Sprite.splash.SIZE];
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
