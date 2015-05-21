package fr.sedara.pusher.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	private TaskDisplay taskDisplay;

	
	public KeyListener(TaskDisplay taskDisplay) {
		this.taskDisplay = taskDisplay;
	}

	public void keyPressed(KeyEvent e) {
		if (!taskDisplay.getController().isPlayerInMovement()) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				taskDisplay.getController().movePlayerRight();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				taskDisplay.getController().movePlayerLeft();
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				taskDisplay.getController().movePlayerUp();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				taskDisplay.getController().movePlayerDown();
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				taskDisplay.getController().playerCatchBlocks();

			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if(taskDisplay.frame.getContentPane().equals(taskDisplay.gamePanel))
				new JFramePause(taskDisplay);
		}
	}

}
