package game;

import java.awt.Graphics;

import material.RoomList;
import tiles.Tile;
import tiles.WallTile;

public class Room {

	public int width;
	public int height;
	
	private Tile[] tiles;
	
	public Room(int id) {
		height = RoomList.rooms[id].length;
		width = RoomList.rooms[id][0].length;
		
		tiles = new Tile[width * height];
		
		for (int y = 0; y < RoomList.rooms[id].length; y++) {
			
			for (int x = 0; x < RoomList.rooms[id][y].length; x++) {
				
				switch(RoomList.rooms[id][y][x]) {
				case 1:
					tiles[x + (y * width)] = new WallTile(x*16, y*16);
					break;
				}
			}
			
			System.out.printf("\n");
		}
		
	}
	
	public void render(Graphics g) {
		for (Tile t : tiles) {
			if (t == null) continue;
			t.render(g);
		}
	}
	
}
