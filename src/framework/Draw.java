package framework;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Draw extends Canvas{

	private JFrame frame;
	
	private BufferedImage bimage;
	private BufferStrategy bs;
	private Graphics g;
	
	private Main main;
	
	public static final int sprSize = 16;
	public static final int width = sprSize * 18;
	public static final int height = sprSize * 14;
	
	private static final int zoom = 3;
	
	
	
	public Draw(Main m) {
		main = m;
		bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		frame = new JFrame("Titulo");
		
		this.setPreferredSize(new Dimension(width * zoom, height * zoom));
		
		frame.add(this);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addKeyListener(new Input());
		this.requestFocus();
	}
	
	
	public void setVisible(boolean valor) {
		frame.setVisible(valor);
	}
	
	
	public void draw() {
		bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		g = bimage.getGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
		// Pintar main
		
		main.render(g);
		
		g.dispose();
		
		g = bs.getDrawGraphics();
		
		g.drawImage(bimage, 0, 0, width * zoom, height * zoom, null);
		
		g.dispose();
		
		bs.show();
	}
	
}
