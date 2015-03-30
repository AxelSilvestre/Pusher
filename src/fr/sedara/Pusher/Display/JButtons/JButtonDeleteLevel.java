package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.sedara.Pusher.Display.JPanelChooseLevel;
import fr.sedara.Pusher.Display.TaskDisplay;
import fr.sedara.Pusher.LevelFileManager;

public class JButtonDeleteLevel extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private String fileName;

	public JButtonDeleteLevel() {
		super("Supprimer");
		fileName = "";
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(!fileName.equalsIgnoreCase("")){
			LevelFileManager.delete(fileName);
			TaskDisplay.frame.setContentPane(new JPanelChooseLevel());
			TaskDisplay.frame.revalidate();
		}
	}
	
	public void setFileName(String name){
		fileName = name;
	}
	
	

}
