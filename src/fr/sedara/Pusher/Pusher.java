package fr.sedara.Pusher;

import java.io.IOException;

import javax.swing.SwingUtilities;

import fr.sedara.Pusher.Display.TaskDisplay;

public class Pusher {

	private static Champs champs;
	
	public static void main(String[] args) {
		try {
			champs = LevelFileManager.load();
		} catch (ClassNotFoundException e) {} catch (IOException e) {}
//		champs = new Champs();
//		LevelGenerator.generateLevel(champs);
//		try {
//			LevelFileManager.save(champs);
//		} catch (IOException e) {}

		TaskPlay.start();
		SwingUtilities.invokeLater(new TaskDisplay());
			




	}

	public static Champs getChamps() {
		return champs;
	}

	public static void setChamps(Champs champs) {
		Pusher.champs = champs;
	}
	
	

}
