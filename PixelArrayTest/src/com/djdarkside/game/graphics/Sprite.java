package com.djdarkside.game.graphics;

public class Sprite {

	private int x, y, width, height;
	public int[] pixels;
	protected SpriteSheet sheet;
	public final int SIZE;

	public Sprite(int x, int y, int width, int height, SpriteSheet sheet) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int [width * height];
		this.x = x * width;
		this.y = y * height;
		this.sheet = sheet;
		load();		
	}
	
	public Sprite(int width, int height, int color) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int [width * height];
		setColor(color);
	}
	
	protected Sprite(SpriteSheet sheet, int width, int height) {
		SIZE = (width == height) ? width: -1;
		this.height = height;
		this.width = width;		
		this.sheet = sheet;
	}
	
	private void load() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SPRITE_WIDTH];
			}
		}
	}
	
	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = color;
		}
	}	
	public int getSpriteHeight() {
		return height;
	}	
	public int getSpriteWidth() {
		return width;
	}
	
}
