package framework;

public class Logic implements Runnable{

	
	private Thread thread;
	private Main main;
	private Draw draw;
	
	private boolean rodando = false;
	
	private static final double sps = 1000000000 / 60;
	private static final double fps = 1000000000 / 30;
	
	private double accS = 0, accF = 0;
	private long lastT, nowT, elapsedT;
	private int countS = 0, countF = 0;
	
	private long clockT;
	private long elapsedClockT;
	
	public Logic(Main m, Draw d) {
		main = m;
		draw = d;
		thread = new Thread(this);
	}
	
	public synchronized void start() {
		if (rodando) return;
		rodando = true;
		thread.start();
	}
	
	
	private synchronized void stop() {
		if (!rodando) return;
		rodando = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void step() {
		main.step();
		accS--;
		countS++;
	}
	
	private void gstep() {
		draw.draw();
		accF--;
		countF++;
	}
	
	@Override
	public void run() {
		lastT = System.nanoTime();
		clockT = System.currentTimeMillis();
		while (rodando) {
			nowT = System.nanoTime();
			elapsedT = nowT - lastT;
			lastT+= elapsedT;
			
			accS += elapsedT / sps;
			accF += elapsedT / fps;
			
			while (accS >= 1) {
				step();
			}
			
			while (accF >= 1) {
				gstep();
			}
			
			if (accS >0) {
				long milis = (long) (accS * sps) / 1000000;
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			elapsedClockT = System.currentTimeMillis() - clockT;
			if (elapsedClockT >= 1000) {
				System.out.printf("fps: %d sps: %d\n", countF, countS);
				countS = 0;
				countF = 0;
				clockT += elapsedClockT;
			}
		}
		stop();
		
	}

}
