package tiles;

import java.awt.Color;
import java.awt.Graphics;

public class WallTile extends Tile{

	public WallTile(int xx, int yy) {
		super(xx, yy);
		x = xx;
		y = yy;
		
		width = 16;
		height = 16;
		
		this.visible = true;
		this.collide = true;
	}
	
	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		
		super.render(g);
	}

}
