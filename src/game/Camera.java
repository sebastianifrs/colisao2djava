package game;

import entitys.Entity;

public class Camera {

	private Entity following;
	public int x;
	public int y;
	
	
	
	public void step() {
		if (following != null) {
			
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
