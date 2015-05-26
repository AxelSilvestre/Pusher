package fr.sedara.pusher.view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.sedara.pusher.view.buttons.JButtonChangeLang;
import fr.sedara.pusher.view.buttons.JButtonCreateLevel;
import fr.sedara.pusher.view.buttons.JButtonPlay;
import fr.sedara.pusher.view.buttons.JButtonQuit;

public class HomeMenu extends JSplitPane {

    private static final long serialVersionUID = 1L;
    private JButtonCreateLevel creator;
    private JButtonPlay        play;
    private JButtonQuit        quit;
    private JButtonChangeLang        lang;
    private TaskDisplay taskDisplay;

    public HomeMenu(TaskDisplay taskDisplay) {
    	super(JSplitPane.VERTICAL_SPLIT);
    	this.taskDisplay = taskDisplay;
    	JPanel j = new JPanel();
        play = new JButtonPlay(taskDisplay);
        j.add(play);
        creator = new JButtonCreateLevel(taskDisplay);
        j.add(creator);
        quit = new JButtonQuit(taskDisplay);
        j.add(quit);
        add(j);
        setDividerSize(0);
        setResizeWeight(0.9);
        JPanel j2 = new JPanel();
        lang = new JButtonChangeLang(taskDisplay);
        j2.add(lang);
        add(j2);

    }
    
    public void setDisplayName(){
    	creator.setText(taskDisplay.getController().getString("createlevel"));
    	play.setText(taskDisplay.getController().getString("play"));
    	quit.setText(taskDisplay.getController().getString("exit"));
    	lang.setText(taskDisplay.getController().getString("language"));

    }


}
