package com.djdarkside.game.level;

import java.util.Random;

public class RandomLevel extends Level {
	
	private final Random r = new Random();

	public RandomLevel(int width, int height) {
		super(width, height);
	}
	
	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) { 
				tiles[x + y * width] = r.nextInt(4);
			}
		}
	}
}
