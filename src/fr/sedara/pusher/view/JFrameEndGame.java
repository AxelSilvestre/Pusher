package fr.sedara.pusher.view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import fr.sedara.pusher.view.buttons.JButtonCancel;
import fr.sedara.pusher.view.buttons.JButtonRetry;

public class JFrameEndGame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public JFrameEndGame(boolean win, TaskDisplay taskDisplay){
		super(taskDisplay.getController().getString("endgame"));
		JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel jp = new JPanel();
		JLabel jl = new JLabel(win ? taskDisplay.getController().getString("win") : taskDisplay.getController().getString("lost"));
		jsp.add(jl);
		jl.setVerticalAlignment(SwingConstants.CENTER);
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		JButtonCancel menu = new JButtonCancel(this, true, taskDisplay);
		JButtonRetry retry = new JButtonRetry(this, taskDisplay);
		jp.add(retry);
		jp.add(menu);
		jsp.add(jp);
		add(jsp);
		jsp.setDividerSize(0);
		toFront();
		taskDisplay.frame.setEnabled(false);
		
		setSize(200, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
	}
	

}
