package firstgame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import firstgame.main.Game.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private Game game;
	private Player player;
	private boolean[] keyDown = new boolean[4]; // used for sticky keys bug
	
	public KeyInput(Game game, Handler handler, Player player){
		this.handler = handler;
		this.game = game;
		this.player = player;
		
		// fixes sticky keys bug where player doesn't move and gets frozen for a very short time
		getKeyDown()[0] = false; // UP
		getKeyDown()[1] = false; // DOWN
		getKeyDown()[2] = false; // RIGHT
		getKeyDown()[3] = false; // LEFT
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player){
				//key events for player 1
				if(key == KeyEvent.VK_UP) 	{ tempObject.setVelY(-player.getSpeed()); getKeyDown()[0] = true; }
				if(key == KeyEvent.VK_DOWN) { tempObject.setVelY(player.getSpeed()); getKeyDown()[1] = true;  }
				if(key == KeyEvent.VK_RIGHT){ tempObject.setVelX(player.getSpeed()); tempObject.setL(false); getKeyDown()[2] = true;  }
				if(key == KeyEvent.VK_LEFT) { tempObject.setVelX(-player.getSpeed()); tempObject.setL(true); getKeyDown()[3] = true; }
			}
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1); //exits out of game when escape or backspace is pressed

	}

	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1
				
				if(key == KeyEvent.VK_UP) 	 getKeyDown()[0] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN)  getKeyDown()[1] = false; //tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) getKeyDown()[2] = false; //tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT)  getKeyDown()[3] = false; //tempObject.setVelX(0);
			
			// vertical movement
			if(!getKeyDown()[0] && !getKeyDown()[1]) tempObject.setVelY(0);
			
			// horizontal movement
			if(!getKeyDown()[2] && !getKeyDown()[3]) tempObject.setVelX(0);
			
			}
		}
		
		if(key == KeyEvent.VK_SPACE && game.gameState == STATE.Game && HUD.bombCount > 0) player.deployBomb();

		if(key == KeyEvent.VK_P && game.gameState == STATE.Game) game.gameState = STATE.Pause;
		
		if(key == KeyEvent.VK_R && game.gameState == STATE.Pause) game.gameState = STATE.Game;
		
	}

	public boolean[] getKeyDown() {
		return keyDown;
	}

}
