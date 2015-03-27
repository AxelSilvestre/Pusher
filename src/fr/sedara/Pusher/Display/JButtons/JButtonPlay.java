package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.sedara.Pusher.Display.JPanelChooseLevel;
import fr.sedara.Pusher.Display.TaskDisplay;

public class JButtonPlay extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;


	public JButtonPlay() {
		setText("Jouer");
		addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		TaskDisplay.frame.setContentPane(new JPanelChooseLevel());
		TaskDisplay.frame.revalidate();
	}
	
	

}
