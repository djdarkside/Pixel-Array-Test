package com.djdarkside.game.level.tiles;

import com.djdarkside.game.graphics.Display;
import com.djdarkside.game.graphics.Sprite;
import com.djdarkside.game.level.Tile;

public class WaterTile extends Tile {

	public WaterTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Display display) {		
		display.renderTile(x / 8, y / 8, this);
	}
	
	public boolean isSolid() {
		return true;
	}
	
	

}
