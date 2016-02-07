package firstgame.main;

import java.util.Random;

import firstgame.main.Game.DIFFICULTY;
import firstgame.main.Game.STATE;

public class Spawn {

	private Handler handler;
	private HUD hud;
	private Game game;
	private Player player;
	private Random r = new Random();
	private int bossLevel = 25;
	private int finalLevel = 25;
	private int bombLevel;
	
	private int scoreKeep = 0;
	
	public Spawn(Game game, Handler handler, HUD hud, Player player, int bombLevel){
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.player = player;
		this.bombLevel = bombLevel;
	}
	
	public void tick(){
		//sets up score
		scoreKeep++;
		hud.setScore(1 + hud.getScore()); 
		
		
		//Easy setting spawner
		if(game.difficulty == DIFFICULTY.Easy){
			// Does what's in the if statement every 300 scores
			if(scoreKeep >= 300 && hud.getScore() >= 300){
				scoreKeep = 0;
				hud.setLevel(hud.getLevel() + 1);// increments level every 500 scores	
			
				// Spawn's units by level
				if(hud.getLevel()%10 == 0){
					handler.addObject(new HealthRegenerator(generateEnemyX(),generateEnemyY(), ID.HealthRegenerator, handler)); // makes an enemy at the start of the game
				}
				if(hud.getLevel()%5 == 0){
					handler.addObject(new Bomb(generateEnemyX(),generateEnemyY(), ID.Bomb, handler, bombLevel));
				}
				if(hud.getLevel() == 2){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 3){
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
				}
				else if(hud.getLevel() == 4){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 5){
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 6){
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 8){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 10){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 13){
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 15){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 17){
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 20){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}  
				if(hud.getLevel() == bossLevel){
					handler.clearEnemys();
					handler.addObject(new EnemyBoss(game,(Game.WIDTH / 2)- 48, -20, ID.EnemyBoss, handler));
				}                
			}
		}
		
		else if(game.difficulty == DIFFICULTY.Medium){
			// Does what's in the if statement every 300 scores
			if(scoreKeep >= 300 && hud.getScore() >= 300){
				scoreKeep = 0;
				hud.setLevel(hud.getLevel() + 1);// increments level every 500 scores	
			
				// Spawn's units by level
				if(hud.getLevel()%12 == 0){
					handler.addObject(new HealthRegenerator(generateEnemyX(),generateEnemyY(), ID.HealthRegenerator, handler)); // makes an enemy at the start of the game
				}
				if(hud.getLevel()%8 == 0){
					handler.addObject(new Bomb(generateEnemyX(),generateEnemyY(), ID.Bomb, handler, bombLevel));
				}
				if(hud.getLevel() == 2){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 3){
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
				}
				else if(hud.getLevel() == 4){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 5){
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 6){
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 8){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 10){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 13){
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 15){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 17){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 20){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}  
				if(hud.getLevel() == bossLevel){
					handler.clearEnemys();
					handler.addObject(new EnemyBoss(game,(Game.WIDTH / 2)- 48, -20, ID.EnemyBoss, handler));
				}                
			}
		}
		
		else if(game.difficulty == DIFFICULTY.Hard){
			// Does what's in the if statement every 300 scores
			if(scoreKeep >= 300 && hud.getScore() >= 300){
				scoreKeep = 0;
				hud.setLevel(hud.getLevel() + 1);// increments level every 500 scores	
			
				// Spawn's units by level
				if(hud.getLevel()%15 == 0){
					handler.addObject(new HealthRegenerator(generateEnemyX(),generateEnemyY(), ID.HealthRegenerator, handler)); // makes an enemy at the start of the game
				}
				if(hud.getLevel()%10 == 0){
					handler.addObject(new Bomb(generateEnemyX(),generateEnemyY(), ID.Bomb, handler, bombLevel));
				}
				if(hud.getLevel() == 2){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 3){
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
				}
				else if(hud.getLevel() == 4){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
				}
				else if(hud.getLevel() == 5){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 6){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}
				else if(hud.getLevel() == 8){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 10){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 13){
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 15){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 17){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
				}
				else if(hud.getLevel() == 19){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 20){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new BlinkingEnemy(generateEnemyX(),generateEnemyY(), ID.BlinkingEnemy, handler));
				}
				else if(hud.getLevel() == 21){
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new BasicEnemy(generateEnemyX(),generateEnemyY(), ID.BasicEnemy, handler));
					handler.addObject(new FastEnemy(generateEnemyX(),generateEnemyY(), ID.FastEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
					handler.addObject(new SmartEnemy(generateEnemyX(),generateEnemyY(), ID.SmartEnemy, handler));
				}  
				if(hud.getLevel() == bossLevel){
					handler.clearEnemys();
					handler.addObject(new EnemyBoss(game,(Game.WIDTH / 2)- 48, -20, ID.EnemyBoss, handler));
				}     
			}
		}

		/*
		if(hud.getLevel() > 20 && handler.noMoreEnemys()){
			hud.setLevel(bossLevel - 1);
			hud.setScore(7400); //(24*300)+200
		}
		*/
		
		//sets the state to Winner if past last level and all enemies are killed
		if(hud.getLevel() > finalLevel && handler.noMoreEnemys()){
			game.gameState = STATE.Winner;
		}
	}
	
	
	public int getBossLevel(){
		return bossLevel;
	}
	
	public float generateEnemyX(){
		boolean spawned = true;
		float x = 0;
		while(spawned){
			x = r.nextInt(Game.WIDTH - 50);
			if((int)(x) > (int)(player.getX()) + 100){
				spawned = false;
			}
			else if((int)(x) < (int)(player.getX()) - 100){
				spawned = false;
			}
		}
		return x;
	}
	
	public float generateEnemyY(){
		boolean spawned = true;
		float y = 0;
		while(spawned){
			y = r.nextInt(Game.HEIGHT - 50);
			if((int)(y) > (int)(player.getY()) + 100){
				spawned = false;
			}
			else if((int)(y) < (int)(player.getY()) - 100){
				spawned = false;
			}
		}
		return y;
	}
}


