package firstgame.main;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BlinkingEnemy extends GameObject {
	
	Timer timer = new Timer();
	private Handler handler;
	private GameObject player;
	private Random r;
	private float randomSpeedConst;
	private boolean show = true;
	private boolean delay = false;

	public BlinkingEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		// finds the player inside the handler array of objects and sets it to our player in this class
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
		}
		r = new Random();
		randomSpeedConst = (float)(r.nextInt(15))/7;  // Settings handle enemies overlapping each other and essentially becoming one enemy, slightly randomizes their speed by this constant
	
		timer.scheduleAtFixedRate(new TimerTask() {
			  public void run() {
				  show = !show;
				  if(show == false){
					  delay = !delay;
				  }
			  }
			}, 500L, 500L); 
	}
	
	//sets random speed to avoid clumping of smart enemies
	public float setRandomSpeed(){
		float baseSpeed = .5f; // base speed of the smart enemy
		float speed = baseSpeed + randomSpeedConst;
		return speed;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y,15,15);  //16 x 16 is the bounds of the player, adjust this for my specs of player must be (size - 1)
	}


	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() + 1; // play with last number to set to center of player object, has to do with the players size
		float diffY = y - player.getY() - 2; // play with last number to set to center of player object, has to do with the players size
		float distance = (float)Math.sqrt((x-player.getX()) * (x-player.getX()) + (y - player.getY()) * (y - player.getY())); // gets the current distance between the player and This smart enemy
		
		velX = (float) (((-setRandomSpeed())/distance) * diffX); //sets speed in x direction towards player
		velY = (float) (((-setRandomSpeed())/distance) * diffY); //sets speed in y direction towards player
		
		if(y <= 0 || y >= Game.HEIGHT - (2 *(10+10))) velY *= -1; //10 is the size of the enemy. Handles the object going outside the top and bottom edge
		
		if(x <= 0 || x >= Game.WIDTH - (2*(10)))  velX *= -1; //10 is the size of the enemy specified in render function. Handles object going outside right and left edge
	
		//handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.white, 16, 16, 0.065f, handler));
	}


	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
	
		
		//The below code shows the bounds of the area designated as the collision area for the enemy 
		//g.setColor(Color.green);
		//g2d.draw(getBounds()); 
		
		if((show)){
			Color randColor = new Color((int)Game.clamp((float)r.nextInt(256),50F, 256F), (int)Game.clamp((float)r.nextInt(256),50F, 256F),(int)Game.clamp((float)r.nextInt(256),50F, 256F));
			
			g.setColor(randColor);
			
			g.fillRect((int)x, (int)y, 16, 16);
			
			//details of enemy
			g.setColor(Color.black);
			//face of enemy
			g.fillRect((int)x+3, (int)y+3, 3, 3);
			g.fillRect((int)x+10, (int)y+3, 3, 3);
			g.fillRect((int)x+3, (int)y+10, 9, 2);
		}

		
		
	}

	
}
