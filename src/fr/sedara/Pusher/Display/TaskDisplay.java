package fr.sedara.Pusher.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JFrame;

import fr.sedara.Pusher.Display.Menus.HomeMenu;
import fr.sedara.Pusher.TaskPlay;
import fr.sedara.Pusher.Display.Menus.HomeMenu;

public class TaskDisplay implements Runnable, KeyListener{

	public static JFrame frame;
	public static JPanelGame gamePanel;
	public static JPanelEditor editorPanel;
	public static HomeMenu home;
	
	public void run() {
		frame = new JFrame();
		home = new HomeMenu();
		frame.setContentPane(home);	
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setEnabled(true);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void keyPressed(KeyEvent e) {

	}

	
	public void keyReleased(KeyEvent e) {
		if(!TaskPlay.inMovement){
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
			if(e.getKeyCode() == KeyEvent.VK_SPACE){
				TaskPlay.caught = !TaskPlay.caught;
			}
		}
	}

	
	public void keyTyped(KeyEvent e) {
		
	}


}
