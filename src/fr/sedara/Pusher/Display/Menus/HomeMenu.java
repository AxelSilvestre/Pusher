package fr.sedara.Pusher.Display.Menus;

import fr.sedara.Pusher.Display.TaskDisplay;
import fr.sedara.Pusher.Display.JButtons.JButtonCreateLevel;
import fr.sedara.Pusher.Display.JButtons.JButtonPlay;
import fr.sedara.Pusher.Display.JButtons.JButtonQuit;

import javax.swing.JPanel;

public class HomeMenu extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButtonCreateLevel creator;
    private JButtonPlay        play;
    private JButtonQuit        quit;

    public HomeMenu(TaskDisplay taskDisplay) {
        play = new JButtonPlay(taskDisplay);
        add(play);
        creator = new JButtonCreateLevel(taskDisplay);
        add(creator);
        quit = new JButtonQuit(taskDisplay);
        add(quit);

    }


}
