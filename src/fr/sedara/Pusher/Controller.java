package fr.sedara.Pusher;

import javax.swing.SwingUtilities;

import fr.sedara.Pusher.Display.TaskDisplay;

public class Controller {
	private Game game;
	private TaskDisplay display;
	
	// TODO Deux interfaces pour modèle et vue
	
	public Controller() {
		display = new TaskDisplay(this);
		SwingUtilities.invokeLater(display);
	}
	
	public void createNewGame() {
		game = new Game(this);
	}
	
	public void createNewGame(Champs champs, String levelName) {
		game = new Game(champs, levelName, this);
	}
	
	public void refreshView(){
		display.gamePanel.setColor();
	}
	
	public Game getGame() {
		return game;
	}
	
	public void endGame(boolean win){
		display.endGame(win);
	}
}
