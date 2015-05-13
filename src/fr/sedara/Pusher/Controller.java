package fr.sedara.Pusher;

import javax.swing.SwingUtilities;

import fr.sedara.Pusher.Display.TaskDisplay;

public class Controller {
	private Game game;
	private TaskDisplay display;
	
	// TODO Deux interfaces pour modèle et vue
	
	public Controller() {
		game = new Game(this);
		display = new TaskDisplay(this);
		SwingUtilities.invokeLater(display);
	}
	
	public void createNewGame() {
		game = new Game(this);
	}
	
}
