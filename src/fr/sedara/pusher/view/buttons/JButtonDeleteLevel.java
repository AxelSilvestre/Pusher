package fr.sedara.pusher.view.buttons;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.sedara.pusher.controller.LevelFileManager;
import fr.sedara.pusher.view.JFrameEditorChooseLevel;
import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonDeleteLevel extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;

    private String fileName;
    private JFrame current;
    private final TaskDisplay taskDisplay;

    public JButtonDeleteLevel(JFrame currentFrame, TaskDisplay taskDisplay) {
        super("Supprimer");
        fileName = "";
        current = currentFrame;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (!fileName.equalsIgnoreCase("")) {
            LevelFileManager.delete(fileName);
            current.dispose();
            current.setState(JFrame.EXIT_ON_CLOSE);
            taskDisplay.frame.toFront();
            new JFrameEditorChooseLevel(taskDisplay);
        }
    }

    public void setFileName(String name) {
        fileName = name;
    }


}
