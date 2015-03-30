package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.sedara.Pusher.Display.JFrameNameAsker;
import fr.sedara.Pusher.Display.TaskDisplay;


public class JButtonValidateEdition extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;

	public JButtonValidateEdition() {
		setText("Valider");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		TaskDisplay.frame.setEnabled(false);
		new JFrameNameAsker();
		
	}
	
}
