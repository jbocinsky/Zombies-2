package firstgame.main;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velX, velY;
	protected boolean L; // keeps track of if object is going Left or Right. True if going Left.
	
	public GameObject(float x, float y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(float x){
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setId(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	public void setVelX(float velX){
		if(this.velX < 0){ 
			L = true;
		}
		else if(this.velX > 0){
			L = false;
		}
		this.velX = velX;
	}
	public void setVelY(float velY){
		this.velY = velY;
	}
	public float getVelX(){
		return velX;
	}
	public float getVelY(){
		return velY;
	}
	public boolean getL() {
		return L;
	}
	public void setL(boolean L){
		this.L = L;
	}
}
