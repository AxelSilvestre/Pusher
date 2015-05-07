package fr.sedara.Pusher.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.sedara.Pusher.Display.JButtons.JButtonCancel;
import fr.sedara.Pusher.Display.JButtons.JButtonRetry;

public class JFramePause extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	
	public JFramePause() {
		super("Pause");
		TaskDisplay.frame.setEnabled(false);
		JPanel jp = new JPanel();
		JButtonCancel home = new JButtonCancel(this, true);
		JButtonCancel cancel = new JButtonCancel(this, false, "Reprendre");
		JButtonRetry retry = new JButtonRetry(this);
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
			TaskDisplay.frame.setEnabled(true);
			TaskDisplay.frame.requestFocusInWindow();
			dispose();
			setState(JFrame.EXIT_ON_CLOSE);
		}
		
	}


	public void keyTyped(KeyEvent e) {
		
	}
	

}