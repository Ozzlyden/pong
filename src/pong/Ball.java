package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

	public double x,y;
	public int width,height;
	
	public double dx, dy;
	public double speed = 1.8;
	
	public Ball (int x, int y) {
		this.x = x;			//esse This se se referice ao x desse metodo
		this.y = y; 
		this.width = 4;		//Aqui tanto faz usar o this ou sem
		this.height = 4;
		
		
		int angle = new Random().nextInt(120 - 45) + 45 + 1;
		dx = Math.cos(Math.toRadians(angle));		//direcoes aleatorias
		dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		//LOGICA COLISOES
		if(x+(dx*speed)+ width >= Game.WIDTH) {
			dx*= -1;
		}else if(x + (dx*speed) < 0) {
			dx*=-1;
		}
		//LOGICA DE PONTOS
		if(y >= Game.HEIGHT) {
			System.out.println("Ponto do Inimigo");
			new Game();
			return;
		}else if (y < 0) {
			System.out.println("Ponto do Jogador");
			new Game();
			return;
		}
		//LOGICA COLISAO SIMPLE
		Rectangle bounds = new Rectangle ((int)(x+(dx*speed)),(int)(y+(dy*speed)), width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		
		if(bounds.intersects(boundsPlayer)) {		
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));		
			dy = Math.sin(Math.toRadians(angle));
			if(dy > 0)
				dy*= -1;
		}else if(bounds.intersects(boundsEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 45 + 1;
			dx = Math.cos(Math.toRadians(angle));		//direcoes aleatorias
			dy = Math.sin(Math.toRadians(angle));
			if( dy < 0)
				dy*=-1;
		}
			
		//LOGICA DIRECAO
		x+=dx*speed;
		y+=dy*speed;
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int)x, (int)y, width , height);
	}

}