package com.djdarkside.game.graphics;

import java.util.Random;

public class Display {
	
	public int width, height;
	public int[] pixels;
	private Random r = new Random();
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE -1;
	public int[] tiles = new int [MAP_SIZE * MAP_SIZE];
	
	int time = 0;
	int counter = 0;
	
	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];		
		
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = r.nextInt(0xffffff);
		}
 	}
	
	public void render() {  //Temp Tile Render
		for (int y = 0; y < height; y++) {
			int yy = y;
			//if (yy < 0 || yy >= height) break;
			
			for (int x = 0; x < width; x++) {
				int xx = x;
				//if (xx < 0 || xx >= width) break;
				
				int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;				
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
}
