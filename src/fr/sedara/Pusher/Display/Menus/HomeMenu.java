package fr.sedara.Pusher.Display.Menus;

import fr.sedara.Pusher.Display.JButtons.JButtonCreateLevel;
import fr.sedara.Pusher.Display.JButtons.JButtonPlay;
import fr.sedara.Pusher.Display.JButtons.JButtonQuit;

import javax.swing.JPanel;

public class HomeMenu extends JPanel {

    private static final long serialVersionUID = 1L;
    private static JButtonCreateLevel creator;
    private static JButtonPlay        play;
    private static JButtonQuit        quit;

    public HomeMenu() {
        play = new JButtonPlay();
        add(play);
        creator = new JButtonCreateLevel();
        add(creator);
        quit = new JButtonQuit();
        add(quit);

    }


}
