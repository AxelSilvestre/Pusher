package fr.sedara.Pusher.Display.Menus;

import javax.swing.JPanel;

import fr.sedara.Pusher.Display.JButtons.JButtonCreateLevel;
import fr.sedara.Pusher.Display.JButtons.JButtonPlay;

public class HomeMenu extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private static JButtonCreateLevel creator;
	private static JButtonPlay play;

	public HomeMenu() {
		creator = new JButtonCreateLevel();
		add(creator);
		play = new JButtonPlay();
		add(play);
	}
	
	

}
