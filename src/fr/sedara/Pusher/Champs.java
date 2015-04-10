package fr.sedara.Pusher;

import java.io.Serializable;
import java.util.ArrayList;

public class Champs implements Serializable {


    public static final  int  DEFAULT_X        = 20;
    public static final  int  DEFAULT_Y        = 15;
    /**
     *
     */
    private static final long serialVersionUID = -9165433451064342283L;
    private Case[][] champs;
    private int      x;
    private int      y;

    public Champs(int x, int y) {
        this.x = x;
        this.y = y;
        champs = new Case[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                champs[j][i] = new Case(new Position(j, i));
            }
        }
    }

    public Champs() {
        this.x = DEFAULT_X;
        this.y = DEFAULT_Y;
        champs = new Case[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                champs[j][i] = new Case(new Position(j, i));
            }
        }
    }

    public Case getCase(Position position) {
        return champs[position.getX()][position.getY()];
    }

    public Case getCase(int x, int y) {
        return champs[x][y];
    }


    public Case getPlayer() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (getCase(i, j).getType() == Type.PLAYER) { return getCase(i, j); }
            }
        }
        System.out.println("No player was found");
        return null;
    }
    
    public ArrayList<Case> getObjectives(){
    	ArrayList<Case> list = new ArrayList<Case>();
    	Case c;
    	for(int i = 0; i < x; i++){
    		for(int j = 0; j < y; j++){
    			c = getCase(i, j);
    			if(c.getType() == Type.OBJETIVE)
    				list.add(c);
    		}
    	}
    	
    	return list;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < y; i++) {
            str += "\n";
            for (int j = 0; j < x; j++) {
                str += getCase(j, i).toString();
            }
        }
        return str;
    }


}
