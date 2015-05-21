package fr.sedara.pusher.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.sedara.pusher.view.buttons.JButtonCancel;
import fr.sedara.pusher.view.buttons.JButtonRetry;

public class JFramePause extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	private final TaskDisplay taskDisplay;
	
	
	public JFramePause(TaskDisplay taskDisplay) {
		super("Pause");
		this.taskDisplay = taskDisplay;
		taskDisplay.frame.setEnabled(false);
		JPanel jp = new JPanel();
		JButtonCancel home = new JButtonCancel(this, true, taskDisplay);
		JButtonCancel cancel = new JButtonCancel(this, false, "Reprendre", taskDisplay);
		JButtonRetry retry = new JButtonRetry(this, taskDisplay);
		jp.add(cancel);
		jp.add(retry);
		jp.add(home);
		add(jp);
		setLocationRelativeTo(null);
		setSize(200,150);
		setEnabled(true);
		toFront();
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		requestFocusInWindow();
		addKeyListener(this);
	}


	public void keyPressed(KeyEvent e) {
	}


	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			taskDisplay.frame.setEnabled(true);
			taskDisplay.frame.requestFocusInWindow();
			dispose();
			setState(JFrame.EXIT_ON_CLOSE);
		}
		
	}


	public void keyTyped(KeyEvent e) {
		
	}
	

}
