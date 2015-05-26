package fr.sedara.pusher.view.buttons;

import fr.sedara.pusher.model.Board;
import fr.sedara.pusher.view.JPanelEditor;
import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonCreateLevel extends JButtonPusher implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final TaskDisplay taskDisplay;

    public JButtonCreateLevel(TaskDisplay taskDisplay) {
        setText(taskDisplay.getController().getString("createlevel"));
        this.taskDisplay = taskDisplay;
        id = "createlevel";
        addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        taskDisplay.editorPanel = new JPanelEditor(new Board(), taskDisplay);
        taskDisplay.frame.setContentPane(taskDisplay.editorPanel);
        taskDisplay.frame.setSize(taskDisplay.editorPanel.getChamps().getX() * 50 + 100,
                                  taskDisplay.editorPanel.getChamps().getY() * 50);
        taskDisplay.frame.setLocationRelativeTo(null);
        taskDisplay.frame.revalidate();
    }


}
