package entitys;

import java.awt.Color;
import java.awt.Graphics;

import framework.Input;

public class Player extends Entity {

	public Player(int xx, int yy) {
		super(xx, yy);
	}
	
	
	public void step() {
		if (Input.right) {
			x++;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
