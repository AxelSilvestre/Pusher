package fr.sedara.Pusher;

import java.util.Timer;

import javax.swing.SwingUtilities;

import fr.sedara.Pusher.Display.TaskDisplay;

/** The controller allows your display to ask the game what does he have to do. And reciprocally.
 * @author Sedara
 *
 */
public class Controller {
	
	/**
	 * The current game.
	 */
	private Game game;
	
	/**
	 * The display.
	 */
	private TaskDisplay display;
	
	// TODO Deux interfaces pour modèle et vue
	
	/** Creates a new Controller.
	 * 
	 */
	public Controller() {
		display = new TaskDisplay(this);
		SwingUtilities.invokeLater(display);
	}
	
	/** Creates a new Game.
	 * 
	 */
	public void createNewGame() {
		game = new Game(this);
	}
	
	/** Creates a new Game.
	 * @param board : The board of the game created.
	 * @param levelName : If a level is loaded, you've got to give its name.
	 */
	public void createNewGame(Board board, String levelName) {
		game = new Game(board, levelName, this);
	}
	
	/** Refresh the current display.
	 * 
	 */
	public void refreshView(){
		display.gamePanel.setColor();
	}
	
	/**
	 * @return The current game.
	 */
	public Game getGame() {
		return game;
	}
	
	/** End the current game.
	 * @param win : If it's win (true) or not (false).
	 */
	public void endGame(boolean win){
		display.endGame(win);
	}
	
	/** Moves the player in the game up.
	 * 
	 */
	public void movePlayerUp(){
		startTimer(0, -1);
	}

	/** Moves the player in the game down.
	 * 
	 */
	public void movePlayerDown(){
		startTimer(0, 1);
	}
	
	/** Moves the player in the game right.
	 * 
	 */
	public void movePlayerRight(){
		startTimer(1, 0);
	}
	
	/** Moves the player in the game left.
	 * 
	 */
	public void movePlayerLeft(){
		startTimer(-1, 0);
	}
	
	/**
	 * @return If the player is currently in movement.
	 */
	public boolean isPlayerInMovement(){
		return game.isInMovement();
	}
	
	/** Makes the player catch the playable blocks.
	 * 
	 */
	public void playerCatchBlocks(){
		if(game.isNearPlayableBox(game.getBoard().getPlayer().getLocation())){
			game.setCaught(!game.isCaught());
			game.setPlayingList();
		}
	}
	
	/** Internal function. Start the game timer to start a move.
	 * @param x : X direction
	 * @param y : Y direction
	 */
	private void startTimer(int x, int y){
		game.setTimer(new Timer());
		game.getTimer().schedule(game.timerTask(x, y), 0, 100);
	}
}
