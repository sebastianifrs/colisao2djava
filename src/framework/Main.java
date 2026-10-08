package framework;

import java.awt.Color;
import java.awt.Graphics;

public class Main {

	private Draw draw;
	private Logic logic;
	
	public Main() {
		draw = new Draw(this);
		logic = new Logic(this, draw);
		
	}
	public static void main(String args[]) {
		System.out.printf("Carregando...\n");
		
		Main main = new Main();
		
		System.out.printf("Carregado!\n\n");
		main.logic.start();
		main.draw.setVisible(true);
		
	}
	
	
	int x = 0;
	int y = 0;
	public void step() {
		if (Input.left) {
			x--;
		}else if(Input.right) {
			x++;
		}else if(Input.down) {
			y++;
		}else if(Input.up) {
			y--;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
}
