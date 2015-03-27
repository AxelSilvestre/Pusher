package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.sedara.Pusher.Display.TaskDisplay;

public class JButtonCancel extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	public JButtonCancel() {
		setText("Annuler");
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Menu home
		TaskDisplay.frame.setContentPane(null);
	}

}
