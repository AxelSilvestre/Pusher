package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JButtonEditLevel extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	public JButtonEditLevel() {
		super("Ouvrir");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
