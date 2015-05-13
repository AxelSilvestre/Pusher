package fr.sedara.Pusher.Display;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import fr.sedara.Pusher.Game;

public class KeyListener extends KeyAdapter {

	private Game game;
	private TaskDisplay taskDisplay;

	
	public KeyListener(Game game, TaskDisplay taskDisplay) {
		this.game = game;
		this.taskDisplay = taskDisplay;
	}

	public void keyPressed(KeyEvent e) {
		if (!game.isInMovement()) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				startTimer(1, 0);
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				startTimer(-1, 0);
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				startTimer(0, -1);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				startTimer(0, 1);
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				if(game.isNearPlayableBlock(game.getChamps().getPlayer().getPosition())){
					game.setCaught(!game.isCaught());
					game.setPlayingList();
				}

			}
		}
	}
	
	private void startTimer(int x, int y){
		game.setTimer(new Timer());
		game.getTimer().schedule(game.timerTask(x, y), 0, 100);
	}

	public void keyReleased(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if(taskDisplay.frame.getContentPane().equals(taskDisplay.gamePanel))
				new JFramePause();
		}
	}

}
