package game;

import entitys.Entity;
import framework.Draw;

public class Camera {

	private Room room;
	private Entity following;
	public int x;
	public int y;
	
	
	
	public Camera(Room r) {
		room = r;
	}
	
	public Camera(Room r, Entity e) {
		room = r;
		following = e;
	}
	
	public void step() {
		if (following != null) {
			x = clamp(following.getPosition()[0] - Draw.width/2, 0, room.width * Draw.sprSize - Draw.width);
			y = clamp(following.getPosition()[1] - Draw.height/2, 0, room.height* Draw.sprSize - Draw.height);
		}
	}
	
	public int clamp(int atual, int min, int max) {
		if (atual < min) {
			return min;
		}
		
		if (atual > max) {
			return max;
		}
		return atual;
	}
	
	
}
