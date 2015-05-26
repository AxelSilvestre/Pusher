package fr.sedara.pusher.view.buttons;

import fr.sedara.pusher.view.JPanelChooseLevel;
import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonPlay extends JButtonPusher implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final TaskDisplay taskDisplay;


    public JButtonPlay(TaskDisplay taskDisplay) {
        setText(taskDisplay.getController().getString("play"));
        this.taskDisplay = taskDisplay;
        id = "play";
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        taskDisplay.frame.setContentPane(new JPanelChooseLevel(taskDisplay));
        taskDisplay.frame.revalidate();
    }
    
}
