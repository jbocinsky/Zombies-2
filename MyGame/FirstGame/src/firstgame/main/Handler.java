package firstgame.main;

import java.awt.Graphics;
import java.util.LinkedList;

import firstgame.main.Game.STATE;

public class Handler {

	private Game game;
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public Handler(Game game){
		this.game = game;
	}
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemys(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if(game.gameState != STATE.End){
				if(tempObject.getId() != ID.Player && tempObject.getId() != ID.HealthRegenerator && tempObject.getId() != ID.Bomb){
					removeObject(tempObject); 
					i--;
				}
			}
			else if(game.gameState == STATE.End){
				if(tempObject.getId() != ID.Player){
					removeObject(tempObject); 
					i--;
				}
			}
		}
	}
	
	public boolean noMoreEnemys(){
		boolean bool = true;
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if(tempObject.getId() != ID.Player && tempObject.getId() != ID.HealthRegenerator && tempObject.getId() != ID.Bomb){ //if it finds a enemy it returns false
				bool = false;
				break;
			}
		}
		return bool;
	}
	
	public void clearPlayer(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			if(tempObject.getId() == ID.Player){
				removeObject(tempObject); 
				i--;
			}
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}
