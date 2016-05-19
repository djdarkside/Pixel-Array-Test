package com.djdarkside.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int width, height;
	private String path;
	public int[] pixels;
	public final int SPRITE_WIDTH, SPRITE_HEIGHT, SIZE;
	
	public static SpriteSheet tile1 = new SpriteSheet("/waterTile.png", 32);
	
	public SpriteSheet(String path, int size) {
		SPRITE_WIDTH = -1;
		SPRITE_HEIGHT = -1;
		this.path = path;
		SIZE = size;
		pixels = new int [SIZE * SIZE];
		load();
	}
	
	
	//Constructor for variable size sheet
	public SpriteSheet(int width, int height, String path) {
		SIZE = (width == height) ? width : -1;
		this.path = path;
		SPRITE_WIDTH = width;
		SPRITE_HEIGHT = height;
		pixels = new int [SPRITE_WIDTH * SPRITE_HEIGHT];
		load();
	}	
	//Constructor for a square sheet
	public SpriteSheet(int size, String path) {
		this.path = path;
		SIZE = size;
		SPRITE_WIDTH = size;
		SPRITE_HEIGHT = size;
		pixels = new int[SIZE * SIZE];
		load();
	}
	
	public void load() {
		try {
			System.out.println("Loading image from: " + path);
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			System.out.println("Success!");
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int [width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(" failed");
		}
	}
}
