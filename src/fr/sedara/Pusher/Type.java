package fr.sedara.Pusher;

import java.awt.Color;

public enum Type {
	
	PLAYER,
	WALL,
	PLAYABLE_BLOCK,
	DEADLY,
	BREAKABLE;
	
	public static String toString(Type type){
		if(type == null)
			return " ";
		switch(type){
		case PLAYER : return "P";
		case BREAKABLE : return "B";
		case DEADLY : return "D";
		case WALL : return "W";
		case PLAYABLE_BLOCK : return "O";
		}
		
		return null;
	}
	
	public static Type getType(int i){
		switch(i){
		case 0 : return PLAYER;
		case 1 : return BREAKABLE;
		case 2 : return DEADLY;
		case 3 : return WALL;
		case 4 : return PLAYABLE_BLOCK;
		}
		
		return null;
	}
	
	public static Color getColor(Type type){
		if(type == null)
			return Color.BLACK;
		switch(type){
		case PLAYER : return Color.BLUE;
		case BREAKABLE : return Color.YELLOW;
		case DEADLY : return Color.WHITE;
		case WALL : return Color.RED;
		case PLAYABLE_BLOCK : return Color.GRAY;
		}
		
		return null;
	}

}
