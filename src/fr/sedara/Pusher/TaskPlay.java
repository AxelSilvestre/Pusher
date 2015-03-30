package fr.sedara.Pusher;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import fr.sedara.Pusher.Display.TaskDisplay;

public class TaskPlay {
	
	public static Champs champs;
	public static Timer timer;
	public static boolean caught;
	public static boolean inMovement;
	
	public static void start(){
		caught = false;
		champs = Pusher.getChamps();
		inMovement = false;
	}
	
	public static boolean playerForward(int dirX, int dirY){
		inMovement = true;
		Case firstCase = champs.getPlayer();
		try{
		Case endCase = champs.getCase(firstCase.getPosition().getX()+dirX,
				firstCase.getPosition().getY()+dirY);
		
		if(caught){
			if(isNearPlayableBlock(firstCase.getPosition())){
				ArrayList<Case> list = getPlayableBlocks(firstCase.getPosition());
				if(isMovableList(list, dirX, dirY, firstCase)){
					playerWithPlayableBlocksForward(list, dirX, dirY, firstCase);
					return true;
				}
			}else
				caught = false;
		}
		
		if(!caught){
			if(endCase.getType() == Type.NULL){
				firstCase.setType(Type.NULL);
				endCase.setType(Type.PLAYER);
				return true;
			}
			if(endCase.getType() == Type.DEADLY){
				firstCase.setType(Type.NULL);
				inMovement = false;
				timer.cancel();
				timer.purge();
				System.out.println("dead");
			}
			if(endCase.getType() == Type.BREAKABLE){
				endCase.setType(Type.NULL);
				timer.cancel();
				timer.purge();
				inMovement = false;
				return true;
			}
		}

		// TODO End game
		
		}catch(ArrayIndexOutOfBoundsException e){firstCase.setType(Type.NULL);inMovement = false;
		timer.cancel();timer.purge();System.out.println("dead");}
		
		inMovement = false;
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
	
	private static void playerWithPlayableBlocksForward(ArrayList<Case> blocks, int dirX, int dirY,Case playerCase){
		blocks.add(playerCase);
		Object tab[][] = new Object[blocks.size()][2];
		int i=0;
		
		for(Case c : blocks){
			tab[i][1] = c.getType();
			tab[i][0] = champs.getCase(c.getPosition().getX()+dirX,c.getPosition().getY()+dirY);
			i++;
			}
		
		for(Case c : blocks){
			c.setType(Type.NULL);
		}
		
		for(i = 0; i<blocks.size();i++){
			((Case) tab[i][0]).setType((Type) tab[i][1]);
		}

	}
	
	private static boolean isMovableList(ArrayList<Case> blocks, int dirX, int dirY, Case playerCase){
		blocks.add(playerCase);
		for(Case c : blocks){
			Case cc = champs.getCase(c.getPosition().getX()+dirX, c.getPosition().getY()+dirY);
			if(cc.getType() != Type.NULL && cc.getType() != Type.PLAYABLE_BLOCK && cc.getType() != Type.PLAYER){
				return false;
			}
		}

		return true;
	}
	
	private static ArrayList<Case> getPlayableBlocks(Position position){
		ArrayList<Case> list = new ArrayList<Case>();
		Case c;
		int tab[] = {-1,0,1};
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				c = champs.getCase(position.getX()+tab[i], position.getY()+tab[j]);
				if(c.getType() == Type.PLAYABLE_BLOCK){
					list.add(c);
				}
			}
		}				
		
		if(list.isEmpty()){
			return null;
		}
		return list;
	}
	
	

}
