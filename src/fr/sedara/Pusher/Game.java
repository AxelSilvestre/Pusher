package fr.sedara.Pusher;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import fr.sedara.Pusher.Display.JFrameEndGame;
import fr.sedara.Pusher.Display.TaskDisplay;

public class Game {

    private Champs  champs;
    private Timer   timer;
    private boolean caught;
    private boolean inMovement;
    private List<Case> playingCases;
    private List<Case> objectives;
    private String currentLevel;
    
    public Game() {
        this(new Champs());
    }
    
    public Game(int x, int y){
        this(new Champs(x,y));
    }
    
    public Game(Champs champs){
        caught = false;
        this.champs = champs;
        inMovement = false;
        objectives = champs.getObjectives();
    }

    public boolean playerForward(int dirX, int dirY) {
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
            	inMovement = false;
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
                    new JFrameEndGame(false);
                    return false;
                }
                if (endCase.getType() == Type.BREAKABLE) {
                    endCase.setType(Type.NULL);
                    timer.cancel();
                    timer.purge();
                    inMovement = false;
                    return true;
                }
            }

        }
        catch (ArrayIndexOutOfBoundsException e) {
            firstCase.setType(Type.NULL);
            inMovement = false;
            timer.cancel();
            timer.purge();
            new JFrameEndGame(false);
        }

        inMovement = false;
        return false;
    }

    public TimerTask timerTask(final int dirX, final int dirY) {

        TimerTask tm = new TimerTask() {
        	@Override
            public void run() {
                
        		if (playerForward(dirX, dirY)) {
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
                	new JFrameEndGame(true);
                }
            }

        };
        return tm;
    }
    
    public void setPlayingList(){
		Position p = champs.getPlayer().getPosition();
    	if(caught && isNearPlayableBlock(p))
    		playingCases = getAllPlayableBlocks(p);
    	else
    		playingCases = null;
    	
    }

    public boolean isNearPlayableBlock(Position position) {
        Case c;
        int tab[][] = {{-1,0} , {1,0}, {0,-1} , {0,1}};
        for (int i = 0; i < 4; i++) {
        	c = champs.getCase(position.getX() + tab[i][0], position.getY() + tab[i][1]);
        	if (c.getType() == Type.PLAYABLE_BLOCK) {
        		return true;
        	}

        }
        return false;
    }

    private void playerWithPlayableBlocksForward(List<Case> blocks, int dirX, int dirY) {
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

    private boolean isMovableList(List<Case> blocks, int dirX, int dirY) {
    	boolean b = true;
    	if(blocks == null) return false;
        for (Case c : blocks) {
        	try{
            Case cc = champs.getCase(c.getPosition().getX() + dirX, c.getPosition().getY() + dirY);
        	
            if(cc.getType() == Type.BREAKABLE){
            	cc.setType(Type.NULL);
            	b = false;
            }
            if(cc.getType() == Type.OBJETIVE && c.getType() == Type.PLAYER)
            	return false;
            if(cc.getType() == Type.DEADLY && c.getType() == Type.PLAYER){
            	c.setType(Type.NULL);
            	timer.purge();
            	timer.cancel();
            	new JFrameEndGame(false);
            	return false;
            }
            
            if (cc.getType() != Type.NULL && !blocks.contains(cc) && cc.getType() != Type.OBJETIVE) 
                return false;
        	}catch(ArrayIndexOutOfBoundsException e){}
            
        }
        return b;
    }
    
    private List<Case> getAllPlayableBlocks(Position position){
        List<Case> list = new ArrayList<Case>();
        List<Case> tempList = new ArrayList<Case>();
        List<Case> tested = new ArrayList<Case>();
        List<Case> tempList2 = new ArrayList<Case>();
        
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

    private List<Case> getClosePlayableBlocks(Position position) {
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

	public Champs getChamps() {
		return champs;
	}

	public void setChamps(Champs champs) {
		this.champs = champs;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public boolean isCaught() {
		return caught;
	}

	public void setCaught(boolean caught) {
		this.caught = caught;
	}

	public boolean isInMovement() {
		return inMovement;
	}

	public void setInMovement(boolean inMovement) {
		this.inMovement = inMovement;
	}

	public List<Case> getPlayingCases() {
		return playingCases;
	}

	public void setPlayingCases(List<Case> playingCases) {
		this.playingCases = playingCases;
	}

	public List<Case> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Case> objectives) {
		this.objectives = objectives;
	}

	public String getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(String currentLevel) {
		this.currentLevel = currentLevel;
	}


    
    
}
