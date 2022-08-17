package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	
	public double x,y;
	public int width,height;
	
	public Enemy (int x, int y) {
		this.x = x;
		this.y = y; 
		this.width = 40;
		this.height = 5;
	}
	
	public void tick() {
		//LOGICA da I.A
		x+= (Game.ball.x - x - 6) * 0.03;		//O enemy segue a ball 
		//LOGICA COLISAO
		if(x+width > Game.WIDTH) {
			x = Game.WIDTH - width;
		}else if (x < 0) {
			x = 0;
		}
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int)x, (int)y, width , height);
	}

}
