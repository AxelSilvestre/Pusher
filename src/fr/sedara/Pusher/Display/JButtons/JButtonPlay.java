package fr.sedara.Pusher.Display.JButtons;

import fr.sedara.Pusher.Display.JPanelChooseLevel;
import fr.sedara.Pusher.Display.TaskDisplay;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonPlay extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final TaskDisplay taskDisplay;


    public JButtonPlay(TaskDisplay taskDisplay) {
        setText("Jouer");
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        taskDisplay.frame.setContentPane(new JPanelChooseLevel(taskDisplay));
        taskDisplay.frame.revalidate();
    }


}
