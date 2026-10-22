package entitys;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Camera;

public class Entity {

	protected double x, y;
	
	protected boolean visible;
	protected boolean collide;
	
	protected Rectangle mask;
	
	public Entity(int xx, int yy) {
		x = xx;
		y = yy;
	}
	
	public Entity(int xx, int yy, Camera c) {
		x = xx;
		y = yy;
	}
	
	public int[] getPosition() {
		int[] position = {(int) x, (int) y};
		
		return position;
	}
	
	public void setPosition(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void step() {
		
	}
	
	public void render(Graphics g, int cameraX, int cameraY) {
		
	}
}
