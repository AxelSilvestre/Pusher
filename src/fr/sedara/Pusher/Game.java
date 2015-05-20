package fr.sedara.Pusher;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/** A game to play.
 * @author Sedara
 *
 */
public class Game {

    /**
     * The board of the game.
     */
    private final Board  board;
    
    /**
     * The timer which allows the game to run.
     */
    private Timer   timer;
    
    /**
     * If the player holds the playing boxes.
     */
    private boolean caught;
    
    /**
     * If the player is in movement.
     */
    private boolean inMovement;
    
    /**
     * The list of all the boxes which are played at the moment.
     */
    private List<Box> playingBoxs;
    
    /**
     * The list of all the objectives in the board.
     */
    private final List<Box> objectives;
    
    /**
     * The name of the current level played.
     */
    private final String currentLevel;
    
    /**
     * The controller.
     */
    private final Controller controller;
    
    /** Creates a new Game.
     * @param controller :  the controller.
     */
    public Game(Controller controller) {
        this(new Board(),"default", controller);
    }
    

    /** Creates a new Game.
     * @param x : X size.
     * @param y : Y size.
     * @param controller : The controller.
     */
    public Game(int x, int y, Controller controller){
        this(new Board(x,y),"default", controller);
    }
    
    /** Creates a new Game.
     * @param board : The board of the game.
     * @param levelName : The name of the level loaded.
     * @param controller : The controller.
     */
    public Game(Board board, String levelName, Controller controller){
        caught = false;
        this.board = board;
        inMovement = false;
        objectives = board.getObjectives();
        this.controller = controller;
        currentLevel = levelName;
    }

    /** Internal function. Makes the player move, with or without the playable boxes attached.
     * @param dirX : The X direction to move.
     * @param dirY : The Y direction to move.
     * @return True : The player is still moving; False : The player has finished his movement.
     */
    private boolean playerForward(int dirX, int dirY) {
        inMovement = true;
        Box firstCase = board.getPlayer();
        try {
        	
            if (caught) {
            	playingBoxs.add(firstCase);
            	if (isMovableList(playingBoxs, dirX, dirY)) {
            		playerWithPlayableBoxesForward(playingBoxs, dirX, dirY);
            		playingBoxs.remove(board.getPlayer());
            		return true;
            	}
            	inMovement = false;
            	playingBoxs.remove(board.getPlayer());
            }

            
            Box endCase = board.getBox(firstCase.getLocation().getX() + dirX,
            		firstCase.getLocation().getY() + dirY);
            
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
                    controller.endGame(false);
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
            controller.endGame(false);
        }

        inMovement = false;
        return false;
    }

    /** Creates the TimerTask which makes the player movement until he reaches something stops him.
     * @param dirX : The X direction to move.
     * @param dirY : The Y direction to move.
     * @return A new timerTask.
     */
    public TimerTask timerTask(final int dirX, final int dirY) {

        TimerTask tm = new TimerTask() {
        	@Override
            public void run() {
                
        		if (playerForward(dirX, dirY)) {
                    controller.refreshView();
                }
                else {
                	controller.refreshView();
                    timer.cancel();
                    timer.purge();
                }
                if(objectives.isEmpty()){
                	timer.cancel();
                    timer.purge();
                	controller.endGame(true);
                }
            }

        };
        return tm;
    }
    
    
    /** Fill the list of playing boxes caught by the player
     * 
     */
    public void setPlayingList(){
		Location p = board.getPlayer().getLocation();
    	if(caught && isNearPlayableBox(p))
    		playingBoxs = getAllPlayableBoxes(p);
    	else
    		playingBoxs = null;
    	
    }

    /**
     * @param location : The location of the player.
     * @return True : the player is near playable boxes; False : He's not.
     */
    public boolean isNearPlayableBox(Location location) {
        Box c;
        int tab[][] = {{-1,0} , {1,0}, {0,-1} , {0,1}};
        for (int i = 0; i < 4; i++) {
        	c = board.getBox(location.getX() + tab[i][0], location.getY() + tab[i][1]);
        	if (c.getType() == Type.PLAYABLE_BOX) {
        		return true;
        	}

        }
        return false;
    }

    /** Internal function. Makes the player move with all the playable boxes he's holding.
     * @param boxes : All the boxes caught.
     * @param dirX : The X direction to move.
     * @param dirY : The Y direction to move.
     */
    private void playerWithPlayableBoxesForward(List<Box> boxes, int dirX, int dirY) {
        int size = boxes.size();
        Object tab[][] = new Object[size][2];
        int i = 0;        

        for (Box c : boxes) {
            tab[i][1] = c.getType();
            tab[i][0] = board.getBox(c.getLocation().getX() + dirX, c.getLocation().getY() + dirY);
            if(((Box) tab[i][0]).getType() == Type.OBJETIVE)
            	objectives.remove((Box) tab[i][0]); 
            i++;
        }

        for (Box c : boxes) {
            c.setType(Type.NULL);
        }

        boxes.clear();
        
        for (i = 0; i < size; i++) {
            ((Box) tab[i][0]).setType((Type) tab[i][1]);
            boxes.add((Box) tab[i][0]);
        }


    }

    /** Internal function.
     * 
     * @param boxes : The list of playable boxes.
     * @param dirX : The X direction to move.
     * @param dirY : The Y direction to move.
     * @return True : The list is movable in this direction; False : It cannot.
     */
    private boolean isMovableList(List<Box> boxes, int dirX, int dirY) {
    	boolean b = true;
    	if(boxes == null) return false;
        for (Box c : boxes) {
        	try{
            Box cc = board.getBox(c.getLocation().getX() + dirX, c.getLocation().getY() + dirY);
        	
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
            	controller.endGame(false);
            	return false;
            }
            
            if (cc.getType() != Type.NULL && !boxes.contains(cc) && cc.getType() != Type.OBJETIVE) 
                return false;
        	}catch(ArrayIndexOutOfBoundsException e){}
            
        }
        return b;
    }
    
    /** Internal function.
     * @param location : The location of the player.
     * @return The list of all the playable boxes caught by the player.
     */
    private List<Box> getAllPlayableBoxes(Location location){
        List<Box> list = new ArrayList<Box>();
        List<Box> tempList = new ArrayList<Box>();
        List<Box> tested = new ArrayList<Box>();
        List<Box> tempList2 = new ArrayList<Box>();
        
		tempList2 = getClosePlayableBoxes(location);

		while(true){
			
			list.clear();
			list.addAll(tested);
			
			for(Box c : tempList2){
				if(!tested.contains(c)){
					tempList.addAll(getClosePlayableBoxes(c.getLocation()));
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

    /** Internal function.
     * @param location : The location of the player.
     * @return The list of all the playable boxes near the player ( up, down, right and left locations).
     */
    private List<Box> getClosePlayableBoxes(Location location) {
        ArrayList<Box> list = new ArrayList<Box>();
        Box c;
        int tab[][] = {{-1,0} , {1,0}, {0,-1} , {0,1}};
        for (int i = 0; i < 4; i++) {
        	try{
        	c = board.getBox(location.getX() + tab[i][0], location.getY() + tab[i][1]);
        	if (c.getType() == Type.PLAYABLE_BOX) {
        		list.add(c);
        	}
        	}catch(ArrayIndexOutOfBoundsException e){}

        }
                
        return list;
    }

	/**
	 * @return The board of the game.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @return The timer of the game.
	 */
	public Timer getTimer() {
		return timer;
	}

	/** Sets the timer for the game.
	 * @param timer : A new timer.
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * @return True : the player is catching playable boxes; False : He's not.
	 */
	public boolean isCaught() {
		return caught;
	}

	/** Sets the catching state of the player for playable boxes.
	 * @param caught : True : He's catching; False : He's not.
	 */
	public void setCaught(boolean caught) {
		this.caught = caught;
	}

	/**
	 * @return True : The player is in movement; False: He's not.
	 */
	public boolean isInMovement() {
		return inMovement;
	}

	/** Sets the movement state of the player.
	 * @param inMovement : True : He's moving; False : He's not.
	 */
	public void setInMovement(boolean inMovement) {
		this.inMovement = inMovement;
	}

	/**
	 * @return The list of all boxes which are currently played.
	 */
	public List<Box> getPlayingCases() {
		return playingBoxs;
	}

	/** Sets the list of all boxes which are currently played.
	 * @param playingCases : The boxes list.
	 */
	public void setPlayingCases(List<Box> playingCases) {
		this.playingBoxs = playingCases;
	}

	/**
	 * @return The list of all the objectives in the level played.
	 */
	public List<Box> getObjectives() {
		return objectives;
	}

	/**
	 * @return The name of the level currently played.
	 */
	public String getCurrentLevel() {
		return currentLevel;
	}
   
    
}
