package framework;

import java.awt.Graphics;

import game.Game;

public class Main {

	private Draw draw;
	private Logic logic;
	
	private Game game;
	
	public Main() {
		draw = new Draw(this);
		logic = new Logic(this, draw);
		
		game = new Game();
	}
	public static void main(String args[]) {
		System.out.printf("Carregando...\n");
		
		Main main = new Main();
		
		System.out.printf("Carregado!\n\n");
		main.logic.start();
		main.draw.setVisible(true);
		
	}
	
	public void step() {
		game.step();
	}
	
	public void render(Graphics g) {
		game.render(g);
	}
	
}
