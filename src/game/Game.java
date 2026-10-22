package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import entitys.Entity;
import entitys.Player;

public class Game {

	
	public Player player;
	private List<Entity> entities;
	public Room room;
	public Camera camera;
	
	
	public Game() {
		loadRoom();
	}
	
	public void loadRoom() {
		room = new Room(0, entities);
		entities = new ArrayList<Entity>();
		player = new Player(room.playerSpawnX,room.playerSpawnY, room);
		entities.add(player);
	
		
		camera = new Camera(room, player);
		room.setCamera(camera);
	}
	
	public void step() {
		
		for (Entity e : entities) {
			e.step();
		}
		camera.step();
		
	}
	
	public void render(Graphics g) {
		
		room.render(g);
		
		for (Entity e : entities) {
			e.render(g, camera.x, camera.y);
		}
	}
	
}
