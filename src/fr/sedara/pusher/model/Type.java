package fr.sedara.pusher.model;

import java.awt.Color;

/** Boxes' type.
 * @author Sedara
 *
 */
public enum Type {


    /**
     * The Player.
     */
    PLAYER("P", Color.BLUE, "Joueur"),
    
    /**
     * A wall.
     */
    WALL("W", Color.RED, "Mur"),
    
    /**
     * A playable box.
     */
    PLAYABLE_BOX("X", Color.GRAY, "Bloc jouable"),
    
    /**
     * A box which kills the player if he touches it.
     */
    DEADLY("D", Color.WHITE, "Bloc tueur"),
    
    /**
     * A breakable box which will be destroyed if the player of a playable box touches it.
     */
    BREAKABLE("B", Color.YELLOW, "Bloc destructible"),
    
    /**
     * An objective block.
     */
    OBJETIVE("O", Color.CYAN, "Bloc objectif"),
    
    /**
     * A box which contains nothing.
     */
    NULL(" ", Color.BLACK, "Vide");

    /**
     * The number of all the different boxes.
     */
    public static final int NUMBER_OF_BLOCKS = 7;
    
    /**
     * The character which represents the box.
     */
    private final String toStringChar;
    
    /**
     * The color of the box.
     */
    private final Color  color;
    
    /**
     * The name of the box.
     */
    private final String name;

    /** Creates a new Type.
     * @param toStringChar : The character which represents the box.
     * @param color : The color of the box.
     * @param name : The name of the box.
     */
    private Type(String toStringChar, Color color, String name) {
        this.toStringChar = toStringChar;
        this.color = color;
        this.name = name;
    }

    /**
     * @param index : The number of the Type.
     * @return The type searched.
     */
    public static Type getType(int index) {
        switch (index) {
            case 0:
                return PLAYER;
            case 1:
                return WALL;
            case 2:
                return OBJETIVE;
            case 3:
                return PLAYABLE_BOX;
            case 4:
                return BREAKABLE;
            case 5:
                return DEADLY;
            case 6:
                return NULL;
        }

        return NULL;
    }

    /**
     * @return The name of the Type.
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return toStringChar;
    }

    /**
     * @return The color of the Type.
     */
    public Color getColor() {
        return color;
    }


}
