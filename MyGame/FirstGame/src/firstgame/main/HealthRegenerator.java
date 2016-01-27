package firstgame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Graphics2D;
import java.awt.Rectangle;

public class HealthRegenerator extends GameObject {
	
	private Handler handler;

	public HealthRegenerator(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 0;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x+2,(int)y+2,16,16);  //16 x 16 is the bounds of the player, adjust this for my specs of player must be (size - 1)
	}


	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 50) velY *= -1; //10 is the size of the enemy. Handles the object going outside the top and bottom edge
		
		if(x <= 0 || x >= Game.WIDTH - (25))  velX *= -1; //10 is the size of the enemy specified in render function. Handles object going outside right and left edge
	}


	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillOval((int) x,(int) y, 20, 20);

		
		//smile
		g.setColor(Color.black);
		g.fillOval((int) x+4, (int) y+1, 12, 16);
		g.setColor(Color.green);
		g.fillOval((int) x+3, (int) y+1, 15, 10);
		g.fillRect((int) x+3, (int)y+9, 15, 3);

		//eyes
		g.setColor(Color.black);
		g.fillRect((int)x+6, (int)y+5, 3, 3);
		g.fillRect((int)x+12, (int)y+5, 3, 3);
		
	
		
		//g.fillRect((int)x+6, (int)y+12, 9, 2);
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//The below code shows the bounds of the area designated as the collision area for the enemy 
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
	}

	
}
