package com.djdarkside.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private int width, height;
	private String path;
	public int[] pixels;
	public final int SPRITE_WIDTH, SPRITE_HEIGHT, SIZE;
	
	public static SpriteSheet sheet = new SpriteSheet(256, "/sheet1.png");
	public static SpriteSheet player = new SpriteSheet(64, 32, "/player.png");
	
	public SpriteSheet(int size, String path) {
		SPRITE_WIDTH = size;
		SPRITE_HEIGHT = size;
		this.path = path;
		SIZE = size;
		pixels = new int [SIZE * SIZE];
		load();
	}
	
	
	//Constructor for variable size sheet
	public SpriteSheet(int width, int height, String path) {
		SIZE = (width == height) ? width : width;
		this.path = path;
		SPRITE_WIDTH = width;
		SPRITE_HEIGHT = height;
		pixels = new int [SPRITE_WIDTH * SPRITE_HEIGHT];
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
