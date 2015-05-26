package fr.sedara.pusher.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.sedara.pusher.view.buttons.JButtonCancel;
import fr.sedara.pusher.view.buttons.JButtonRetry;

public class JFrameEndGame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public JFrameEndGame(boolean win, TaskDisplay taskDisplay){
		super(taskDisplay.getController().getString("endgame"));
		JPanel jp = new JPanel();
		JLabel jl = new JLabel(win ? taskDisplay.getController().getString("win") : taskDisplay.getController().getString("lost"));
		jp.add(jl);
		JButtonCancel menu = new JButtonCancel(this, true, taskDisplay);
		JButtonRetry retry = new JButtonRetry(this, taskDisplay);
		jp.add(retry);
		jp.add(menu);
		add(jp);
		toFront();
		taskDisplay.frame.setEnabled(false);
		
		setSize(200, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
	}
	

}
