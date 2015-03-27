package fr.sedara.Pusher.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JFrame;

import fr.sedara.Pusher.Champs;
import fr.sedara.Pusher.TaskPlay;

public class TaskDisplay implements Runnable, KeyListener{

	public static JFrame frame;
	public static JPanelGame gamePanel;
	public static JPanelEditor editorPanel;
	
	public void run() {
		frame = new JFrame();	
		gamePanel = new JPanelGame(TaskPlay.champs);
		editorPanel = new JPanelEditor(new Champs());
		frame.setContentPane(editorPanel);
		frame.setSize(gamePanel.getChamps().getX()*50,gamePanel.getChamps().getY()*50);
		frame.setVisible(true);
		frame.setEnabled(true);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void keyPressed(KeyEvent e) {

	}

	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			TaskPlay.timer = new Timer();
			TaskPlay.timer.schedule(TaskPlay.timerTask(1,0), 0 , 100);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			TaskPlay.timer = new Timer();
			TaskPlay.timer.schedule(TaskPlay.timerTask(-1,0), 0 , 100);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			TaskPlay.timer = new Timer();
			TaskPlay.timer.schedule(TaskPlay.timerTask(0,-1), 0 , 100);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			TaskPlay.timer = new Timer();
			TaskPlay.timer.schedule(TaskPlay.timerTask(0,1), 0 , 100);
		}
	}

	
	public void keyTyped(KeyEvent e) {
		
	}


}
