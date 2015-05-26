package fr.sedara.pusher.view.buttons;

import javax.swing.JFrame;

import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonQuit extends JButtonPusher implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final TaskDisplay taskDisplay;

    public JButtonQuit(TaskDisplay taskDisplay) {
        setText(taskDisplay.getController().getString("exit"));
        this.taskDisplay = taskDisplay;
        id = "exit";
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        taskDisplay.frame.dispose();
        taskDisplay.frame.setState(JFrame.EXIT_ON_CLOSE);
    }
}
