package fr.sedara.pusher.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** The Board class. It is the main board where the game is played in.
 * @author Sedara
 *
 */
public class Board implements Serializable {


    /**
     * The default X size.
     */
    public static final  int  DEFAULT_X        = 20;
    
    /**
     * The default Y size.
     */
    public static final  int  DEFAULT_Y        = 15;
    /**
     *
     */
    private static final long serialVersionUID = -9165433451064342283L;
    
    /**
     * The box table, which represents the whole board.
     */
    private Box[][] board;
    
    /**
     * X size.
     */
    private int      x;
    
    /**
     * Y size.
     */
    private int      y;

    /** Creates a new Board.
     * @param x : X size.
     * @param y : Y size.
     */
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        board = new Box[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[j][i] = new Box(new Location(j, i));
            }
        }
    }

    /** Creates a new default Board.
     * 
     */
    public Board() {
        this.x = DEFAULT_X;
        this.y = DEFAULT_Y;
        board = new Box[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[j][i] = new Box(new Location(j, i));
            }
        }
    }

    /**
     * @param location : The location of the box to get.
     * @return A box in the board.
     */
    public Box getBox(Location location) {
        return board[location.getX()][location.getY()];
    }

    /**
     * @param x : The X location of the box to get.
     * @param y : The Y location of the box to get.
     * @return A box in the board.
     */
    public Box getBox(int x, int y) {
        return board[x][y];
    }


    /**
     * @return The box which contains the player in the board.
     */
    public Box getPlayer() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (getBox(i, j).getType() == Type.PLAYER) { return getBox(i, j); }
            }
        }
        return null;
    }
    
    /**
     * @return A list of the objectives in the board.
     */
    public List<Box> getObjectives(){
    	List<Box> list = new ArrayList<Box>();
    	Box c;
    	for(int i = 0; i < x; i++){
    		for(int j = 0; j < y; j++){
    			c = getBox(i, j);
    			if(c.getType() == Type.OBJECTIVE)
    				list.add(c);
    		}
    	}
    	
    	return list;
    }

    /**
     * @return X size.
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y size.
     */
    public int getY() {
        return y;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < y; i++) {
            str += "\n";
            for (int j = 0; j < x; j++) {
                str += getBox(j, i).toString();
            }
        }
        return str;
    }


}
