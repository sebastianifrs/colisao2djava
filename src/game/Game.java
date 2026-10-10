package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import entitys.Entity;
import entitys.Player;

public class Game {

	
	private Player player;
	private List<Entity> entities;
	private Room room;
	
	public Game() {
		loadRoom();
	}
	
	public void loadRoom() {
		entities = new ArrayList<Entity>();
		player = new Player(0,0);
		
		room = new Room(0);
		
		entities.add(player);
	}
	
	public void step() {
		for (Entity e : entities) {
			e.step();
		}
	}
	
	public void render(Graphics g) {
		
		room.render(g);
		
		for (Entity e : entities) {
			e.render(g);
		}
	}
	
}
