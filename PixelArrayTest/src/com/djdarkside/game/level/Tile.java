package com.djdarkside.game.level;
import com.djdarkside.game.graphics.Display;
import com.djdarkside.game.graphics.Sprite;
import com.djdarkside.game.level.tiles.WaterTile;

public abstract class Tile {

	public Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Display display) {		
		//We render Stuff
	}
	
	public boolean isSolid() {
		return false;
	}
	
}
