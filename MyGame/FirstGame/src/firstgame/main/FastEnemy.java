package firstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {
	
	private Handler handler;

	public FastEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 4;
		velY = 4;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,15,15);  //16 x 16 is the bounds of the player, adjust this for my specs of player must be (size - 1)
	}


	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - (2 *(10+10))) velY *= -1; //10 is the size of the enemy. Handles the object going outside the top and bottom edge
		
		if(x <= 0 || x >= Game.WIDTH - (2*(10)))  velX *= -1; //10 is the size of the enemy specified in render function. Handles object going outside right and left edge
	
		//handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.green, 16, 16, 0.065f, handler));
	}


	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
	
		
		//The below code shows the bounds of the area designated as the collision area for the enemy 
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 16, 16);

		//details of enemy
		g.setColor(Color.black);
		//face of enemy
		g.fillRect((int)x+3, (int)y+3, 3, 3);
		g.fillRect((int)x+10, (int)y+3, 3, 3);
		g.fillRect((int)x+3, (int)y+10, 9, 2);
		
	}

	
}
