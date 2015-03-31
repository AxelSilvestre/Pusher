package fr.sedara.Pusher;

import java.awt.Color;

public enum Type {

    PLAYER("P", Color.BLUE, "Joueur"),
    WALL("W", Color.RED, "Mur"),
    PLAYABLE_BLOCK("X", Color.GRAY, "Bloc jouable"),
    DEADLY("D", Color.WHITE, "Bloc tueur"),
    BREAKABLE("B", Color.YELLOW, "Bloc destructible"),
    OBJETIVE("O", Color.CYAN, "Bloc objectif"),
    NULL(" ", Color.BLACK, "Vide");

    public static final int NUMBER_OF_BLOCKS = 7;
    private final String toStringChar;
    private final Color  color;
    private final String name;

    private Type(String toStringChar, Color color, String name) {
        this.toStringChar = toStringChar;
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

    public Color getColor() {
        return color;
    }


}
