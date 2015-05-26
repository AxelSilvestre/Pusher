package fr.sedara.pusher.view.buttons;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.sedara.pusher.controller.LevelFileManager;
import fr.sedara.pusher.view.JFrameEditorChooseLevel;
import fr.sedara.pusher.view.JPanelEditor;
import fr.sedara.pusher.view.TaskDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JButtonOpenFile extends JButton implements ActionListener {

    private static final long serialVersionUID = 1L;
    private String fileName;
    private JFrame current;
    private final TaskDisplay taskDisplay;

    public JButtonOpenFile(JFrame currentFrame, TaskDisplay taskDisplay) {
        super(taskDisplay.getController().getString("open"));
        current = currentFrame;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public JButtonOpenFile( TaskDisplay taskDisplay) {
        super(taskDisplay.getController().getString("open"));
        current = null;
        this.taskDisplay = taskDisplay;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (current != null) {
            current.dispose();
            current.setState(JFrame.EXIT_ON_CLOSE);
            try {
                taskDisplay.editorPanel = new JPanelEditor(LevelFileManager.load(fileName), taskDisplay);
            }
            catch (ClassNotFoundException e1) {}
            catch (IOException e1) {}
            taskDisplay.frame.setContentPane(taskDisplay.editorPanel);
            taskDisplay.frame.setEnabled(true);
            taskDisplay.frame.toFront();
            taskDisplay.frame.revalidate();
        }
        else {
            new JFrameEditorChooseLevel(taskDisplay);
        }
    }

    public void setFileName(String name) {
        fileName = name;
    }

}
