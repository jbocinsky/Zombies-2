package firstgame.main;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler;
	Random r = new Random();

	public EnemyBossBullet(float x, float y, ID id, Handler handler, EnemyBoss boss) {
		super(x, y, id);
		
		this.handler = handler;
		
		int horizontal = r.nextInt(10);
		//bullets that go sideways opposite of the boss. Make it more of a challenge to kill boss
		if(horizontal == 0){
			if(boss.velX < 0){
				velX = 2.5f;
			}
			else if(boss.velX > 0){
				velX = -2.5f;
			}
			velY = -.1f;
		}
		//normal bullets going down the screen bullets
		else{
			velX = (r.nextInt(6) + -3);  //makes velocity x random so that the enemies fly down the screen randomly with velocity from -3 to 3
			velY = 3;
		}
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,15,15);  //16 x 16 is the bounds of the player, adjust this for my specs of player must be (size - 1)
	}


	public void tick() {
		x += velX;
		y += velY;
		
		if(x <= 0 - (2*10)|| x >= Game.WIDTH + (2*(10)))  handler.removeObject(this); //10 is the size of the enemy specified in render function. Handles object going outside right and left edge
	
		if(y >= Game.HEIGHT + (2*10) || y <= 0 - (2*10)) handler.removeObject(this); // removes the bullet when bullet is below screen
		
		//handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.gray, 16, 16, 0.065f, handler));
	}


	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
	
		
		//The below code shows the bounds of the area designated as the collision area for the enemy 
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		
		g.setColor(Color.gray);
		g.fillRect((int)x, (int)y, 16, 16);

		//details of enemy
		g.setColor(Color.black);
		//face of enemy
		g.fillRect((int)x+3, (int)y+3, 3, 3);
		g.fillRect((int)x+10, (int)y+3, 3, 3);
		g.fillRect((int)x+3, (int)y+10, 9, 2);
		
	}

	
}
