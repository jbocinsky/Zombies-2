package firstgame.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{

	private Handler handler;
	private float alpha = 1;
	private Color color;
	private int width, height;
	private float life;
	
	
	public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}


	public void tick() {
		if(alpha > life){
			alpha -= (life - .001f);
		}else handler.removeObject(this);
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		
		//details of enemy
		g.setColor(Color.black);
		//border of enemy
		g.drawRect((int)x-1, (int)y-1, 17, 17 );
		//face of enemy
		g.fillRect((int)x+3, (int)y+3, 3, 3);
		g.fillRect((int)x+10, (int)y+3, 3, 3);
		g.fillRect((int)x+3, (int)y+10, 9, 2);
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha){
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	public Rectangle getBounds() {
		return null;
	}

}
