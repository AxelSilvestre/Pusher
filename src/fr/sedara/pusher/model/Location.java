package fr.sedara.pusher.model;

import java.io.Serializable;

/** A simple (x,y) location
 * @author Sedara
 *
 */
public class Location implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1810013978124484773L;
    
    /**
     * The location on the X axis
     */
    private final int x;
    
    /**
     * The location on the Y axis
     */
    private final int y;

    /** Creates a new Location
     * @param x : Location on the X axis
     * @param y : Location on the Y axis
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return X location
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y location
     */
    public int getY() {
        return y;
    }


}
