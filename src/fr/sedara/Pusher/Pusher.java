package fr.sedara.Pusher;

import javax.swing.SwingUtilities;

import fr.sedara.Pusher.Display.TaskDisplay;

public class Pusher {

	private static Champs champs;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new TaskDisplay());
	}

	public static Champs getChamps() {
		return champs;
	}

	public static void setChamps(Champs champs) {
		Pusher.champs = champs;
	}
	
	

}
