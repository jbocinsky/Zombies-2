package firstgame.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class BulletController {

	LinkedList<GameObject> bullet = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < bullet.size(); i++){
			GameObject TempBullet = bullet.get(i);
			
			TempBullet.tick();
			float x = TempBullet.getX();
			if(x <= 0 || x >= Game.WIDTH - 5) removeBullet(TempBullet);
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < bullet.size(); i++){
			GameObject TempBullet = bullet.get(i);
			
			TempBullet.render(g);
		}
	}
	
	public void addBullet(GameObject block){
		this.bullet.addFirst(block);
	}
	public void removeBullet(GameObject block){
		this.bullet.remove(block);
	}
	
}
