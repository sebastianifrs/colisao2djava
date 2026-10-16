package entitys;

import java.awt.Color;
import java.awt.Graphics;

import framework.Input;
import game.Room;
import tiles.WallTile;

public class Player extends Entity {

	
	private Room room;
	
	private double jumpForce = 4.0;
	private double gravity = 0.15;
	private double movementSpeed = 1.5;
	private double hspeed;
	private double vspeed;

	private boolean onFloor = false;
	
	public Player(int xx, int yy, Room r) {
		super(xx, yy);
		
		room = r;
	}
	
	
	
	public void movement() {
		if (Input.right && !Input.left) {
			hspeed = movementSpeed;
		}else if(Input.left && !Input.right) {
			hspeed = -movementSpeed;
		}else {
			hspeed = 0;
		}
		
		if (!onFloor) {
			vspeed += gravity;
		}
		
		if (Input.a && onFloor == true) {
			Input.a = false;
			onFloor = false;
			vspeed-=jumpForce;
		}
		
		if (!room.isFree((int) (x+hspeed), (int) (y))) {
			hspeed = 0;
		}
	
		if (!room.isFree((int) (x), (int) (y+vspeed))) {
			vspeed = 0;
			onFloor = true;
			
		}else {
			onFloor = false;
		}
		
		if (x+hspeed < 0) {
			hspeed = 0;
		}
		
	}
	
	public void step() {
		movement();
		
		x+=hspeed;
		y+=vspeed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
