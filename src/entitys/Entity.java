package entitys;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Entity {

	protected double x, y;
	
	protected boolean visible;
	protected boolean collide;
	
	protected Rectangle mask;
	
	public Entity(int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	public void step() {
		
	}
	
	public void render(Graphics g) {
		
	}
}
