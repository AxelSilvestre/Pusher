package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.sedara.Pusher.Display.JPanelEditor;
import fr.sedara.Pusher.Display.TaskDisplay;
import fr.sedara.Pusher.Champs;

public class JButtonCreateLevel extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;


	public JButtonCreateLevel() {
		setText("Créer un niveau");
		addActionListener(this);
	}


	public void actionPerformed(ActionEvent e){
		TaskDisplay.editorPanel = new JPanelEditor(new Champs());
		TaskDisplay.frame.setContentPane(TaskDisplay.editorPanel);
		TaskDisplay.frame.setSize(TaskDisplay.editorPanel.getChamps().getX()*50 + 100,
				TaskDisplay.editorPanel.getChamps().getY()*50);
		TaskDisplay.frame.setLocationRelativeTo(null);
		TaskDisplay.frame.revalidate();
	}
	
	

}
