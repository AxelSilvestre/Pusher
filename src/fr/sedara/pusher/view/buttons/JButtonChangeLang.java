package fr.sedara.pusher.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.sedara.pusher.view.TaskDisplay;

public class JButtonChangeLang extends JButtonPusher implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TaskDisplay taskDisplay;
	
	private int i;
	
	private String[] lang = {"en","fr"};

	public JButtonChangeLang(TaskDisplay taskDisplay) {
		setText(taskDisplay.getController().getString("language"));
		this.taskDisplay = taskDisplay;
		id = "language";
		addActionListener(this);
		i=0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		i++;		
		taskDisplay.getController().setLanguage(lang[i%lang.length]);	
		taskDisplay.home.setDisplayName();
	}

}
