package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.sedara.Pusher.Display.TaskDisplay;

public class JButtonCancel extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private JFrame frameToClose;
	private JFrame previousFrame;
	
	
	public JButtonCancel() {
		setText("Annuler");
		frameToClose = null;
		previousFrame = null;
		addActionListener(this);
	}
	
	public JButtonCancel(JFrame frame){
		frameToClose = frame;
		previousFrame = null;
	}
	
	public JButtonCancel(JFrame frame, JFrame previous){
		frameToClose = frame;
		previousFrame = previous;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(frameToClose != null){
			frameToClose.dispose();
			frameToClose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		}
		if(previousFrame != null)
			TaskDisplay.frame.setContentPane(previousFrame);
		else
			TaskDisplay.frame.setContentPane(TaskDisplay.home);
		TaskDisplay.frame.revalidate();
	}

}
