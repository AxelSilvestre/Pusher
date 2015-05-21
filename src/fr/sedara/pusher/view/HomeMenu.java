package fr.sedara.pusher.view;

import javax.swing.JPanel;

import fr.sedara.pusher.view.buttons.JButtonCreateLevel;
import fr.sedara.pusher.view.buttons.JButtonPlay;
import fr.sedara.pusher.view.buttons.JButtonQuit;

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
