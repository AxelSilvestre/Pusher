package fr.sedara.Pusher;

import java.awt.Color;

public enum Type {

    PLAYER("P", 0, Color.BLUE, "Joueur"),
    WALL("W", 3, Color.RED, "Mur"),
    PLAYABLE_BLOCK("X", 4, Color.GRAY, "Bloc jouable"),
    DEADLY("D", 2, Color.WHITE, "Bloc tueur"),
    BREAKABLE("B", 1, Color.YELLOW, "Bloc destructible"),
    OBJETIVE("O", 6, Color.CYAN, "Bloc objectif"),
    NULL(" ", 5, Color.BLACK, "Vide");

    public static final int NUMBER_OF_BLOCKS = 7;
    private final String toStringChar;
    private final int    value;
    private final Color  color;
    private final String name;

    private Type(String toStringChar, int value, Color color, String name) {
        this.toStringChar = toStringChar;
        this.value = value;
        this.color = color;
        this.name = name;
    }

    public static Type getType(int i) {
        switch (i) {
            case 0:
                return PLAYER;
            case 1:
                return WALL;
            case 2:
                return OBJETIVE;
            case 3:
                return PLAYABLE_BLOCK;
            case 4:
                return BREAKABLE;
            case 5:
                return DEADLY;
            case 6:
                return NULL;
        }

        return NULL;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return toStringChar;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    //	public static String toString(Type type){
    //		if(type == null)
    //			return " ";
    //		switch(type){
    //		case PLAYER : return "P";
    //		case BREAKABLE : return "B";
    //		case DEADLY : return "D";
    //		case WALL : return "W";
    //		case PLAYABLE_BLOCK : return "O";
    //		}
    //
    //		return null;
    //	}

    //	public static Color getColor(Type type){
    //		if(type == null)
    //			return Color.BLACK;
    //		switch(type){
    //		case PLAYER : return Color.BLUE;
    //		case BREAKABLE : return Color.YELLOW;
    //		case DEADLY : return Color.WHITE;
    //		case WALL : return Color.RED;
    //		case PLAYABLE_BLOCK : return Color.GRAY;
    //		}
    //
    //		return null;
    //	}

}
