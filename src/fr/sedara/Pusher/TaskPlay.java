package fr.sedara.Pusher;

import fr.sedara.Pusher.Display.TaskDisplay;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TaskPlay {

    public static Champs  champs;
    public static Timer   timer;
    public static boolean caught;
    public static boolean inMovement;
    public static ArrayList<Case> playingCases;
    public static ArrayList<Case> objectives;

    public static void start() {
        caught = false;
        champs = Pusher.getChamps();
        inMovement = false;
        objectives = champs.getObjectives();
    }

    public static boolean playerForward(int dirX, int dirY) {
        inMovement = true;
        Case firstCase = champs.getPlayer();
        try {
        	
            if (caught) {
            	playingCases.add(firstCase);
            	if (isMovableList(playingCases, dirX, dirY)) {
            		playerWithPlayableBlocksForward(playingCases, dirX, dirY);
            		playingCases.remove(champs.getPlayer());
            		return true;
            	}
            	playingCases.remove(champs.getPlayer());
            }

            
            Case endCase = champs.getCase(firstCase.getPosition().getX() + dirX,
            		firstCase.getPosition().getY() + dirY);
            
            if (!caught) {
                if (endCase.getType() == Type.NULL) {
                    firstCase.setType(Type.NULL);
                    endCase.setType(Type.PLAYER);
                    return true;
                }
                if (endCase.getType() == Type.DEADLY) {
                    firstCase.setType(Type.NULL);
                    inMovement = false;
                    timer.cancel();
                    timer.purge();
                    System.out.println("dead");
                }
                if (endCase.getType() == Type.BREAKABLE) {
                    endCase.setType(Type.NULL);
                    timer.cancel();
                    timer.purge();
                    inMovement = false;
                    return true;
                }
            }

            // TODO End game

        }
        catch (ArrayIndexOutOfBoundsException e) {
            firstCase.setType(Type.NULL);
            inMovement = false;
            timer.cancel();
            timer.purge();
            System.out.println("dead");
        }

        inMovement = false;
        return false;
    }

    public static TimerTask timerTask(final int dirX, final int dirY) {

        TimerTask tm = new TimerTask() {

            public void run() {
                if (TaskPlay.playerForward(dirX, dirY)) {
                    TaskDisplay.gamePanel.setColor();
                }
                else {
                    TaskDisplay.gamePanel.setColor();
                    timer.cancel();
                    timer.purge();
                }
                if(objectives.isEmpty()){
                	timer.cancel();
                    timer.purge();
                	System.out.println("Win");
                }
            }

        };
        return tm;
    }
    
    public static void setplayingList(){
		Position p = champs.getPlayer().getPosition();
    	if(caught && isNearPlayableBlock(p))
    		playingCases = getAllPlayableBlocks(p);
    	else
    		playingCases = null;
    	
    }

    private static boolean isNearPlayableBlock(Position position) {
        Case cc;
        int tab[] = {-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cc = champs.getCase(position.getX() + tab[i], position.getY() + tab[j]);
                if (cc.getType() == Type.PLAYABLE_BLOCK) { return true; }
            }
        }
        return false;
    }

    private static void playerWithPlayableBlocksForward(ArrayList<Case> blocks, int dirX, int dirY) {
        int size = blocks.size();
        Object tab[][] = new Object[size][2];
        int i = 0;        

        for (Case c : blocks) {
            tab[i][1] = c.getType();
            tab[i][0] = champs.getCase(c.getPosition().getX() + dirX, c.getPosition().getY() + dirY);
            if(((Case) tab[i][0]).getType() == Type.OBJETIVE)
            	objectives.remove((Case) tab[i][0]); 
            i++;
        }

        for (Case c : blocks) {
            c.setType(Type.NULL);
        }

        blocks.clear();
        
        for (i = 0; i < size; i++) {
            ((Case) tab[i][0]).setType((Type) tab[i][1]);
            blocks.add((Case) tab[i][0]);
        }


    }

    private static boolean isMovableList(ArrayList<Case> blocks, int dirX, int dirY) {
    	if(blocks == null) return false;
        for (Case c : blocks) {
            Case cc = champs.getCase(c.getPosition().getX() + dirX, c.getPosition().getY() + dirY);
            if(cc.getType() == Type.OBJETIVE && c.getType() == Type.PLAYER)
            	return false;
            if (cc.getType() != Type.NULL && !blocks.contains(cc) && cc.getType() != Type.OBJETIVE) 
                return false;
            
        }
        return true;
    }
    
    private static ArrayList<Case> getAllPlayableBlocks(Position position){
        ArrayList<Case> list = new ArrayList<Case>();
        ArrayList<Case> tempList = new ArrayList<Case>();
        ArrayList<Case> tested = new ArrayList<Case>();
        ArrayList<Case> tempList2 = new ArrayList<Case>();
        
		tempList2 = getClosePlayableBlocks(position);

		while(true){
			
			list.clear();
			list.addAll(tested);
			
			for(Case c : tempList2){
				if(!tested.contains(c)){
					tempList.addAll(getClosePlayableBlocks(c.getPosition()));
					tested.add(c);
				}
			}
			
			if(tested.equals(list)){
				break;
			}
			
			tempList2.addAll(tempList);			
			
		}
   	
		return list;    	
    }

    private static ArrayList<Case> getClosePlayableBlocks(Position position) {
        ArrayList<Case> list = new ArrayList<Case>();
        Case c;
        int tab[][] = {{-1,0} , {1,0}, {0,-1} , {0,1}};
        for (int i = 0; i < 4; i++) {
        	c = champs.getCase(position.getX() + tab[i][0], position.getY() + tab[i][1]);
        	if (c.getType() == Type.PLAYABLE_BLOCK) {
        		list.add(c);
        	}

        }
                
        return list;
    }


}
