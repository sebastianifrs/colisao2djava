package tiles;

import java.awt.Graphics;

public class Tile {

	
	protected int x, y;
	
	protected int width, height;
	
	protected boolean visible;
	protected boolean collide;
	
	public Tile(int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	
	public void render(Graphics g, int cameraX, int cameraY) {
		if (visible) {
			g.fillRect(x - cameraX, y - cameraY, width, height);
		}
	}
	
}
