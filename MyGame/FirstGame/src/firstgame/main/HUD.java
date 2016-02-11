package firstgame.main;

import java.awt.Color;
import java.awt.Font;
//import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	private Game game;
	private int healthLevel = 0;
	public static float HEALTH = 100;
	public static float ENEMYHEALTH = 100;
	private float greenValue = 255;
	private float enemyGreenValue = 255;
	public static int bombCount = 0;
	private float healthFactor = 1;
	private float maxHealth; //used to clamp HEALTH to it's max value
	
	public int score = 1;
	public int level = 1;
	
	public HUD(Game game, int healthLevel){
		this.game = game;
		
		if(healthLevel == 0){
			healthFactor = 1;
			HEALTH = 100;
		}
		else if(healthLevel == 1){
			healthFactor = 1.2F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 2){
			healthFactor = 1.4F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 3){
			healthFactor = 1.6F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 4){
			healthFactor = 1.8F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 5){
			healthFactor = 2;
			HEALTH *= healthFactor;
		}
		
		maxHealth = HEALTH; 
		
	}
	
	public int getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(int healthLevel) {
		HEALTH = 100;
		
		if(healthLevel == 0){
			healthFactor = 1;
			HEALTH = 100;
		}
		else if(healthLevel == 1){
			healthFactor = 1.2F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 2){
			healthFactor = 1.4F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 3){
			healthFactor = 1.6F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 4){
			healthFactor = 1.8F;
			HEALTH *= healthFactor;
		}
		else if(healthLevel == 5){
			healthFactor = 2;
			HEALTH *= healthFactor;
		}
		
		maxHealth = HEALTH; 
		
		this.healthLevel = healthLevel;
	}

	public void tick(){
		HEALTH = Game.clamp(HEALTH, 0, maxHealth);
		greenValue = HEALTH*1.4f;
		greenValue = Game.clamp(greenValue, 0, 255);
		
		ENEMYHEALTH = Game.clamp(ENEMYHEALTH, 0, 100);
		enemyGreenValue = Game.clamp(enemyGreenValue, 0, 255);
		enemyGreenValue = ENEMYHEALTH*2;
		
	}
	
	public void render(Graphics g){		
		g.setColor(Color.darkGray);
		g.fillRect(11, 15, 200, 20);
		g.setColor(new Color(75,(int)greenValue,0));
		g.fillRect(11, 15, (int)((HEALTH*2)/healthFactor), 20);
		g.setColor(Color.gray);
		g.drawRect(11, 15, 200, 20);
		g.drawRect(10,14,202,22);
		
		Font fntBold = new Font("arial", 1, 14);
		g.setFont(fntBold);
		g.setColor(Color.white);
		g.drawString("Health",87,30);
		
		g.setFont(new Font("arial", 1, 12));
		g.setColor(Color.white);
		g.drawString("Bombs: " + bombCount, 10, 55);
		g.drawString("Score: " + score, 10, 72);
		g.drawString("Level: " + level, 10, 89);
	
		//Pause button
		g.setColor(Color.gray);
		g.drawRect(860,612, 25, 25);
		g.drawRect(859,611, 27, 27);
		g.fillRect(866, 617, 5, 16);
		g.fillRect(875,617,5,16);
		
		//Money display
		g.setColor(new Color(255,215,0));//gold
		g.setFont(new Font("arial", 1, 12));
		g.drawString("Money: " + game.getMoney(), 10, 635);
	}
	
	public void renderEnemy(Graphics g){
		g.setFont(new Font("arial", 1, 12));
		g.setColor(Color.darkGray);
		g.fillRect(680, 15, 200, 20);
		g.setColor(new Color(75,(int)enemyGreenValue,0));
		g.fillRect(680, 15, (int)ENEMYHEALTH*2, 20);
		g.setColor(Color.gray);
		g.drawRect(680, 15, 200, 20);
		
		g.setColor(Color.red);
		g.drawString("Boss", 851, 52);
		
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
}
