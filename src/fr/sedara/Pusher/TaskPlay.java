package fr.sedara.Pusher;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import fr.sedara.Pusher.Display.TaskDisplay;

public class TaskPlay {
	
	public static Champs champs;
	public static Timer timer;
	public static boolean caught;
	
	public static void start(){
		caught = false;
		champs = Pusher.getChamps();
		LevelGenerator.generateLevel(champs);
	}
	
	public static boolean playerForward(int dirX, int dirY){
		Case firstCase = champs.getPlayer();
		try{
		Case endCase = champs.getCase(firstCase.getPosition().getX()+dirX,
				firstCase.getPosition().getY()+dirY);
		if(endCase.getType() == Type.NULL){
			firstCase.setType(Type.NULL);
			endCase.setType(Type.PLAYER);
			return true;
		}
		if(endCase.getType() == Type.DEADLY){
			firstCase.setType(Type.NULL);
			timer.cancel();
			timer.purge();
			System.out.println("dead");
		}
		if(endCase.getType() == Type.BREAKABLE){
			firstCase.setType(Type.NULL);
			endCase.setType(Type.NULL);
			timer.cancel();
			timer.purge();
			return true;
		}
		if(caught && isNearPlayableBlock(firstCase.getPosition())){
			ArrayList<Case> list = getPlayableBlocks(firstCase.getPosition());
			if(isMovableList(list, dirX, dirY)){
				playerWithPlayableBlocksForward(list, dirX, dirY);
			}
		}
		
		}catch(ArrayIndexOutOfBoundsException e){firstCase.setType(Type.NULL);timer.cancel();timer.purge();System.out.println("dead");}
		
		return false;
	}
	
	public static TimerTask timerTask(final int dirX, final int dirY){

		TimerTask tm = new TimerTask() {

			public void run() {
				if(TaskPlay.playerForward(dirX, dirY)){
					TaskDisplay.gamePanel.setColor();
				}	
				else{
					TaskDisplay.gamePanel.setColor();
					timer.cancel();
					timer.purge();
				}
			}

		};
		return tm;
	}
	
	private static boolean isNearPlayableBlock(Position position){
		Case cc;
		int tab[] = {-1,0,1};
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				cc = champs.getCase(position.getX()+tab[i],position.getY()+tab[j]);
				if(cc.getType() == Type.PLAYABLE_BLOCK)
					return true;
			}
		}
		return false;
	}
	
	private static void playerWithPlayableBlocksForward(ArrayList<Case> blocks, int dirX, int dirY){
		for(Case c : blocks){
			champs.getCase(c.getPosition().getX()+dirX,c.getPosition().getY()+dirY).setType(c.getType());
			c.setType(Type.NULL);
		}
	}
	
	private static boolean isMovableList(ArrayList<Case> blocks, int dirX, int dirY){
		for(Case c : blocks){
			Case cc = champs.getCase(c.getPosition().getX()+dirX, c.getPosition().getY()+dirY);
			if(cc.getType() != Type.NULL && cc.getType() != Type.PLAYABLE_BLOCK){
				return false;
			}
		}

		return true;
	}
	
	private static ArrayList<Case> getPlayableBlocks(Position position){
		ArrayList<Case> list = new ArrayList<Case>();
		Case c;
		int tab[] = {-1,0,1};
		loop:
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				c = champs.getCase(position.getX()+tab[i], position.getY()+tab[j]);
				if(c.getType() == Type.PLAYABLE_BLOCK){
					list.add(c);
					break loop;
				}
			}
		}
		
		if(list.isEmpty()){
			return null;
		}
		
		try{
		for(Case cc : getPlayableBlocks(list.get(0).getPosition())){
			list.add(cc);
		}
		}catch(NullPointerException e){};
		
		return list;
	}
	
	

}
