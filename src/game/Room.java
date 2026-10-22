package game;

import java.awt.Graphics;
import java.util.List;

import entitys.Entity;
import material.RoomList;
import tiles.Tile;
import tiles.WallTile;

public class Room {
		
	private List<Entity> entities;
	private Camera camera;
	
	public int width;
	public int height;
	
	public int playerSpawnX, playerSpawnY;
	
	private Tile[] tiles;
	
	public Room(int id, List<Entity> ent) {
		entities = ent;
		
		height = RoomList.rooms[id].length;
		width = RoomList.rooms[id][0].length;
		
		tiles = new Tile[width * height];
		
		for (int y = 0; y < RoomList.rooms[id].length; y++) {
			
			for (int x = 0; x < RoomList.rooms[id][y].length; x++) {
				
				switch(RoomList.rooms[id][y][x]) {
				case 1:
					tiles[x + (y * width)] = new WallTile(x*16, y*16);
					break;
				case 2:
					playerSpawnX = x*16;
					playerSpawnY = y*16;
					break;
				}
			}
			
			System.out.printf("\n");
		}
		
	}
	
	
	public void setCamera(Camera c) {
		camera = c;
	}
	
	public boolean isFree(int nextx, int nexty) {
		
		int tile1 = nextx/16 + (nexty/16 * width);
		
		int tile2 = (nextx+15)/16 + (nexty/16 * width);
			
		int tile3 = nextx/16 + ((nexty+15)/16* width);

		int tile4 = (nextx+15)/16 + ((nexty+15)/16 * width);
	
	    if (nextx / 16 < 0 || (nextx + 15) / 16 >= width || nexty / 16 < 0 || (nexty + 15) / 16 >= height) {
	        return true; 
	    }
		
		if (tiles[tile1] instanceof WallTile || tiles[tile2] instanceof WallTile || tiles[tile3] instanceof WallTile || tiles[tile4] instanceof WallTile) {
			return false;
		}
		
		return true;
	}
	
	public void render(Graphics g) {
		for (Tile t : tiles) {
			if (t == null) continue;
			
			if (camera != null) { 
				t.render(g, camera.x, camera.y);
			} else {
				t.render(g, 0, 0);
			}
			
		}
	}
	
}
