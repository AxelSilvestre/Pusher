package fr.sedara.Pusher;

import java.io.Serializable;

public class Case implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7685868685838189677L;
	private Position position;
	private Type type;
	
	public Case(Position position) {
		this.position = position;
		type = null;
		
	}

	public Position getPosition() {
		return position;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public String toString(){
		return "["+Type.toString(type)+"]";
	}


}
